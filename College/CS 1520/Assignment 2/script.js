window.onload = function () {
    init();
}

var player1;
var player2;
var targetGrid;
var myGrid;
var gameboard;
var scoreboard;
var currentPlayer;
var otherPlayer

function init() {
    player1 = new Object();
    player2 = new Object();
    currentPlayer = player1;
    otherPlayer = player2;
    initGrids();
    getPlayerInfo();
    parseShipPlacement(player1);
    parseShipPlacement(player2);
    beginRound();
}

function beginRound() {
    alert("Click OK to begin " + currentPlayer.name + "'s turn");
    document.getElementById("targetGridLabel").innerHTML = otherPlayer.name + "'s Grid &#9650;";
    document.getElementById("turnIdentifier").innerHTML = currentPlayer.name + "'s Turn";
    gameboard.style.display = "block";
    populateGrids();
}

function endRound() {
    gameboard.style.display = "none";
    clearGrids();
    if (!checkForWinner()) {
        if (currentPlayer === player1) {
            currentPlayer = player2;
            otherPlayer = player1;
        } else {
            currentPlayer = player1;
            otherPlayer = player2;
        }
        beginRound();
    }
}

function populateGrids() {
    //targetGrid
    currentPlayer.hits.forEach(function(item) {
        var element = document.getElementById("targetGrid_" + item);
        element.classList.remove("clickable");
        element.classList.remove("lightblueBG");
        element.classList.add("redBG");
    });
    currentPlayer.misses.forEach(function(item) {
        var element = document.getElementById("targetGrid_" + item);
        element.classList.remove("clickable");
        element.classList.remove("lightblueBG");
        element.classList.add("whiteBG");
    });

    // myGrid
    currentPlayer.myAircraftCarrier.forEach(function(item) {
        var label = document.createElement("p");
        label.innerHTML = "A";
        document.getElementById("myGrid_" + item).appendChild(label);
    });
    currentPlayer.myBattleship.forEach(function(item) {
        var label = document.createElement("p");
        label.innerHTML = "B";
        document.getElementById("myGrid_" + item).appendChild(label);
    });
    currentPlayer.mySubmarine.forEach(function(item) {
        var label = document.createElement("p");
        label.innerHTML = "S";
        document.getElementById("myGrid_" + item).appendChild(label);
    });

    otherPlayer.hits.forEach(function(item) {
        var element = document.getElementById("myGrid_" + item);
        element.classList.remove("lightblueBG");
        element.classList.add("redBG");
    });
    otherPlayer.misses.forEach(function(item) {
        var element = document.getElementById("myGrid_" + item);
        element.classList.remove("lightblueBG");
        element.classList.add("whiteBG");
    });
}

function clearGrids() {
    while (targetGrid.firstChild) {
        targetGrid.removeChild(targetGrid.firstChild);
    }
    while (myGrid.firstChild) {
        myGrid.removeChild(myGrid.firstChild);
    }
    initGrids();
}

function getPlayerInfo() {
    player1.name = prompt("Enter the name of Player 1:", "Alice");
    player1.shipPlacement = prompt("Enter " + player1.name + "'s ship positions:", "A:A1-A5; B:B6-E6; S:H3-J3");
    player1.hits = [];
    player1.misses = [];
    player2.name = prompt("Enter the name of Player 2:", "Bob");
    player2.shipPlacement = prompt("Enter " + player2.name + "'s ship positions:", "B(B6-E6);S(H3-J3);A(A6-A6)");
    player2.hits = [];
    player2.misses = [];
}

function initGrids() {
    targetGrid = document.getElementById("targetGrid");
    myGrid = document.getElementById("myGrid");

    for (var i = 1; i <= 11; i++) {
        for (var j = 65; j <= 75; j++) {
            var label = String.fromCharCode(j-1).concat(i-1);
            var tg_grid_item = document.createElement("DIV");
            var mg_grid_item = document.createElement("DIV");
            tg_grid_item.classList.add("gridItem");
            tg_grid_item.classList.add("targetGrid");
            mg_grid_item.classList.add("gridItem");
            mg_grid_item.classList.add("myGrid");
            tg_grid_item.id = "targetGrid_" + label;
            mg_grid_item.id = "myGrid_" + label;

            if (i == 1 && j == 65) {
                // Do Nothing
            } else if (i == 1) {
                tg_grid_item.classList.add("centerAlign");
                mg_grid_item.classList.add("centerAlign");
                var tg_topLabel = document.createElement("LABEL");
                var mg_topLabel = document.createElement("LABEL");
                tg_topLabel.innerHTML = String.fromCharCode(j-1);
                mg_topLabel.innerHTML = String.fromCharCode(j-1);
                tg_grid_item.appendChild(tg_topLabel);
                mg_grid_item.appendChild(mg_topLabel);
            } else if (j == 65) {
                tg_grid_item.classList.add("rightAlign");
                mg_grid_item.classList.add("rightAlign");
                var tg_sideLabel = document.createElement("LABEL");
                var mg_sideLabel = document.createElement("LABEL");
                tg_sideLabel.innerHTML = i-1;
                mg_sideLabel.innerHTML = i-1;
                tg_grid_item.appendChild(tg_sideLabel);
                mg_grid_item.appendChild(mg_sideLabel);
            } else {
                tg_grid_item.classList.add("lightblueBG");
                tg_grid_item.classList.add("gridBody");
                tg_grid_item.classList.add("clickable");
                mg_grid_item.classList.add("lightblueBG");
                mg_grid_item.classList.add("gridBody");
                tg_grid_item.addEventListener("click", function(){
                    attack(this)
                });
            }

            targetGrid.appendChild(tg_grid_item);
            myGrid.appendChild(mg_grid_item);
        }
    }

    gameboard = document.getElementsByClassName("gameboard")[0];
    scoreboard = document.getElementsByClassName("scoreboard")[0];
    scoreboard.style.display = "none";
}

function parseShipPlacement(player) {
    shipPlacement = player.shipPlacement;
    var pattern = /[ABS]:?\(?[A-J]\d0?-[A-J]\d0?\)?;?\s?/gi;
    var matches = shipPlacement.match(pattern);

    getPlayerShipLocations(player, matches);
}

function getPlayerShipLocations(player, matches) {
    matches.forEach(function(item) {
        var pattern = /[A-J]\d0?/ig;
        if (item.match(pattern).length != 2) {
            alert(player.name + " entered invalid ship coordinates: " + player.shipPlacement);
            throw new Error(player.name + " entered invalid ship coordinates: " + player.shipPlacement);
        }
        var begin = item.match(pattern)[0].toUpperCase();
        var end = item.match(pattern)[1].toUpperCase();
        var positionArray = [];

        if (begin.charAt(0) === end.charAt(0)) {
            if (Number(begin.substring(1)) > Number(end.substring(1))) {
                var temp = begin;
                begin = end;
                end = temp;
            }
            var letterPosition = begin.charAt(0);
            for (var i = begin.substring(1); i <= end.substring(1); i++) {
                positionArray.push(letterPosition + i);
            }
        } else if(begin.substring(1) == end.substring(1)) {
            if(begin.charCodeAt(0) > end.charCodeAt(0)) {
                var temp = begin;
                begin = end;
                end = temp;
            }
            var numberPosition = begin.substring(1);
            var arrayCounter = 0;
            for (var i = begin.charCodeAt(0); i <= end.charCodeAt(0); i++) {
                positionArray.push(String.fromCharCode(i) + numberPosition);
            }
        }

        if (item.charAt(0) === "A" && positionArray.length === 5) {
            player.myAircraftCarrier = positionArray;
        } else if (item.charAt(0) === "B" && positionArray.length === 4) {
            player.myBattleship = positionArray;
        } else if (item.charAt(0) === "S" && positionArray.length === 3) {
            player.mySubmarine = positionArray;
        } else {
            alert(player.name + " entered invalid ship coordinates: " + player.shipPlacement);
            throw new Error(player.name + " entered invalid ship coordinates: " + player.shipPlacement);
        }
    });

    var isOverlapping = false;
    player.myAircraftCarrier.forEach(function(item) {
        if (player.myBattleship.indexOf(item) > -1 || player.mySubmarine.indexOf(item) > -1) {
            isOverlapping = true;
        }
    });
    player.myBattleship.forEach(function(item) {
        if (player.myAircraftCarrier.indexOf(item) > -1 || player.mySubmarine.indexOf(item) > -1) {
            isOverlapping = true;
        }
    });
    if (isOverlapping) {
        alert(player.name + " entered overlapping ship coordinates: " + player.shipPlacement);
        throw new Error(player.name + " entered overlapping ship coordinates: " + player.shipPlacement);
    }
}

function attack(gridItem) {
    var pattern = /[A-J]\d0?/;
    var position = gridItem.id.match(pattern)[0];
    if (currentPlayer.hits.indexOf(position) == -1 && currentPlayer.misses.indexOf(position) == -1) {
        hitOrMiss(position);
        endRound();
    }
}

function hitOrMiss(position) {
    var alertMessage;
    if (otherPlayer.myAircraftCarrier.indexOf(position) != -1 || otherPlayer.myBattleship.indexOf(position) != -1 || otherPlayer.mySubmarine.indexOf(position) != -1) {
        currentPlayer.hits.push(position);
        alertMessage = "You got a hit" + checkIfSunk(position);
    } else {
        currentPlayer.misses.push(position);
        alertMessage = "That was a miss.";
    }
    alert(alertMessage);
}

function checkIfSunk(position) {
    if (otherPlayer.myAircraftCarrier.indexOf(position) != -1) {
        var hitCounter = 0;
        currentPlayer.hits.forEach(function(item) {
            if (otherPlayer.myAircraftCarrier.indexOf(item) != -1) {
                hitCounter++;
            }
        });
        if (hitCounter == 5) {
            return " and sunk " + otherPlayer.name + "'s aircraft carrier!";
        }
    } else if (otherPlayer.myBattleship.indexOf(position) != -1) {
        var hitCounter = 0;
        currentPlayer.hits.forEach(function(item) {
            if (otherPlayer.myBattleship.indexOf(item) != -1) {
                hitCounter++;
            }
        });
        if (hitCounter == 4) {
            return " and sunk " + otherPlayer.name + "'s battleship!";
        }
    } else {
        var hitCounter = 0;
        currentPlayer.hits.forEach(function(item) {
            if (otherPlayer.mySubmarine.indexOf(item) != -1) {
                hitCounter++;
            }
        });
        if (hitCounter == 3) {
            return " and sunk " + otherPlayer.name + "'s submarine!";
        }
    }
    return "!";
}

function checkForWinner() {
    if (currentPlayer.hits.length == 12) {
        var points = 24;
        otherPlayer.hits.forEach(function() {
            points -= 2;
        });
        alert(currentPlayer.name + " has won with a score of " + points + " points!");
        displayScoreboard(points);
        return true;
    }
    return false;
}

function displayScoreboard(score) {
    var curName = currentPlayer.name;
    var curScore = score;
    document.getElementById("turnIdentifier").innerHTML = "Scoreboard";
    gameboard.style.display = "none";
    scoreboard.style.display = "block";
    var scores = localStorage.getItem("scores");
    var names = localStorage.getItem("names");

    if (scores == null || names == null) {
        scores = [0,0,0,0,0,0,0,0,0,0];
        names = ["--","--","--","--","--","--","--","--","--","--"];
        if (curScore != -1) {
            names[0] = curName;
            scores[0] = curScore;
        }
    } else {
        scores = scores.split(",");
        names = names.split(",");
        for (var i = 0; i < 10; i++) {
            if (scores[i] < curScore) {
                scores.splice(i, 0, curScore);
                names.splice(i, 0, curName);
                while (scores.length > 10) {
                    scores.pop();
                }
                while (names.length > 10) {
                    names.pop();
                }
                break;
            }
        }
    }
    localStorage.setItem("scores", scores);
    localStorage.setItem("names", names);

    var table = document.createElement("TABLE");
    var firstRow = document.createElement("TR");
    var leftTH = document.createElement("TH");
    var rightTH = document.createElement("TH");
    var numberTH = document.createElement("TH");
    leftTH.innerHTML = "Name";
    rightTH.innerHTML = "Score";
    numberTH.innerHTML = "#";
    firstRow.appendChild(numberTH);
    firstRow.appendChild(leftTH);
    firstRow.appendChild(rightTH);
    table.appendChild(firstRow);
    for (var i = 0; i < 10; i++) {
        var row = document.createElement("TR");
        var leftTD = document.createElement("TD");
        var rightTD = document.createElement("TD");
        var numberTD = document.createElement("TD");
        leftTD.innerHTML = names[i];
        rightTD.innerHTML = scores[i];
        numberTD.innerHTML = i+1;
        row.appendChild(numberTD);
        row.appendChild(leftTD);
        row.appendChild(rightTD);
        table.appendChild(row);
    }
    var clearButton = document.createElement("BUTTON");
    clearButton.innerHTML = "Clear Scoreboard";
    clearButton.onclick = function() {
        localStorage.removeItem("scores");
        localStorage.removeItem("names");
        scoreboard.removeChild(table);
        scoreboard.removeChild(clearButton);
        displayScoreboard(-1);
    };
    scoreboard.appendChild(table);
    scoreboard.appendChild(clearButton);
}
