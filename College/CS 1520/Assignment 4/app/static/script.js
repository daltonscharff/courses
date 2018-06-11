var interval = 1000;

function setIsNewUser(value) {
    document.getElementById("isNewUserField").value = value;
    document.getElementById("loginForm").submit();
}

function toggleCreateTableButton() {
    var input = document.getElementById("createTableInputBox");
    var button = document.getElementById("createTableButton");
    button.disabled = input.value.length == 0 || input.value.length > 256;
}

function toggleSendMessageButton(event) {
    var input = document.getElementById("sendMessageInputBox");
    var button = document.getElementById("sendMessageButton");
    button.disabled = input.value.length == 0 || input.value.length > 512;

    if(event && !button.disabled && (event.which == 13 || event.keyCode == 13)) {
        button.click();
    }
}

function sendMessage(userId, roomId) {
    var message = {
        "timestamp": new Date().getTime(),
        "text": document.getElementById("sendMessageInputBox").value,
        "roomId": roomId,
        "userId": userId
    };
    var response = null;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            response = this.responseText;
        }
    };
    xhttp.open("POST", "/api/messages", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(message));
}

function getMessages(roomId, getAllMessages) {
    var message = "/api/messages?"
    message += "timestamp=" +  new Date().getTime();
    message += "&roomId=" + roomId;
    message += "&getAllMessages=" + getAllMessages;
    var response = null;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            response = JSON.parse(this.responseText);
            updateConversation(response);
        }
    };
    xhttp.open("GET", message, true);
    xhttp.send();
}

function updateConversation(json) {
    var conversationTable = document.getElementById("conversationTable");

    for (var i = 0; i < json.length; i++) {
        var message = json[i];
        var tr = document.createElement("TR");
        var td1 = document.createElement("TD");
        var td2 = document.createElement("TD");
        tr.classList.add("messageRow");
        td1.classList.add("senderCell");
        td2.classList.add("textCell");

        if(document.getElementById("usernameArea").innerHTML.trim() == message["sender"]) {
            td1.classList.add("bold");
        }

        if(message["sender"] == "adm" && message["text"] == "delete") {
            alert("This room has been deleted by the owner.");
            window.location.replace("/api/ackDeletion");
        } else {
            td1.innerHTML = message["sender"] + ":";
            td2.innerHTML = message["text"];
            tr.appendChild(td1);
            tr.appendChild(td2);
            conversationTable.insertBefore(tr, conversationTable.firstChild);
        }
    }

}

function startPolling(roomId) {
    getMessages(roomId, 1);
    window.setInterval(function(){ getMessages(roomId, 0); }, interval);
}
