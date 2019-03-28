from app import app, db
from app.models import User, Room, Message
from flask import Flask, render_template, session, redirect, request, abort, url_for, json
from flask_sqlalchemy import SQLAlchemy
from time import time

currentTime = lambda: int(round(time() * 1000))
currentUser = lambda: User.query.filter_by(id=session["id"]).first()
currentRoom = lambda: User.query.filter_by(id=session["id"]).first().currentRoom[0]
interval = 1000;

def setSession(user):
    session["username"] = user.username
    session["id"] = user.id
    return redirect("/")

@app.route("/", methods=["GET"])
def redirect_get():
    user = None
    if "username" not in session:
        return render_template("login.html", title="Login")
    else:
        user = currentUser();
        if user == None:
            return redirect(url_for("endSession"))
    if user.currentRoom:
        return redirect("/room/" + repr(currentRoom().id))
    else:
        myRooms = [room for room in user.ownedRooms if room.available == 1];
        allRooms = [room for room in Room.query.all() if room.available == 1];
        otherRooms = list(set(allRooms) - set(myRooms))
        return render_template("rooms.html", title="Chatrooms", myRooms=myRooms, otherRooms=otherRooms)

@app.route("/", methods=["POST"])
def redirect_post():
    loginForm = request.form
    usernameField = request.form.get("username")
    passwordField = request.form.get("password")
    isNewUser = request.form.get("isNewUser") == "True"
    usernameError = ""
    passwordError = ""
    if len(usernameField) < 4 or len(passwordField) < 4:
        if len(usernameField) < 4:
            usernameError = "Username must be 4 characters or longer."
        if len(passwordField) < 4:
            passwordError = "Password must be 4 characters or longer."
    else:
        user = User.query.filter_by(username = usernameField).first()
        if isNewUser:
            if user is None:
                user = User(username=usernameField, password=passwordField)
                db.session.add(user)
                db.session.commit()
                return setSession(user)
            else:
                usernameError = "Username is not available."
        else:
            if user is None:
                usernameError = "Username does not exist."
            else:
                if user.password == passwordField:
                    return setSession(user)
                else:
                    passwordError = "Password is incorrect."
    return render_template("login.html", title="Login", username=usernameField, usernameErrorField=usernameError, passwordErrorField=passwordError)

@app.route("/room/<id>")
def chatroom(id):
    room = Room.query.filter_by(id=id).first()
    user = currentUser()
    user.currentRoom.append(room)
    db.session.commit()
    return render_template("chat.html", title=room.name, room=room, user=user)

@app.route("/logout", methods=["GET"])
def endSession():
    session.pop("username", None)
    session.pop("id", None)
    return redirect("/")

@app.route("/api/createRoom", methods=["GET"])
def createRoom():
    roomName = request.args.get("roomName")
    newRoom = Room(name=roomName)
    owner = currentUser()
    db.session.add(newRoom)
    db.session.commit()
    newRoom.owner.append(owner)
    db.session.commit()
    return redirect(url_for("redirect_get"))

@app.route("/api/deleteRoom", methods=["GET"])
def deleteRoom():
    roomId = request.args.get("id")
    room = Room.query.filter_by(id=roomId).first()
    adm = User.query.filter_by(username="adm").first()
    message = Message(timestamp=currentTime(), text="delete")
    message.room.append(room)
    message.sender.append(adm)
    db.session.add(message)
    db.session.commit()
    room.available = 0
    db.session.commit()
    return redirect(url_for("redirect_get"))

@app.route("/api/leaveRoom", methods=["GET"])
def leaveRoom():
    user = currentUser()
    roomId = request.args.get("id")
    room = Room.query.filter_by(id=roomId).first()
    room.roomUsers.remove(user)
    db.session.commit()
    return redirect(url_for("redirect_get"))

@app.route("/api/ackDeletion", methods=["GET"])
def ackDeletion():
    user = currentUser();
    room = currentRoom();
    room.roomUsers.remove(user)
    db.session.add(room)
    db.session.commit()
    return redirect(url_for("redirect_get"))

@app.route("/api/messages", methods=["POST"])
def messages_post():
    msg = request.get_json()
    message = Message(timestamp=msg.get("timestamp"), text=msg.get("text"))
    message.room.append(currentRoom())
    message.sender.append(currentUser())
    db.session.add(message)
    db.session.commit()
    return ""

@app.route("/api/messages", methods=["GET"])
def message_get():
    timestamp = int(request.args.get("timestamp"))
    oldTimestamp = timestamp - interval
    allMessages = Message.query.all()

    if request.args.get("getAllMessages") == "1":
        oldTimestamp = 0

    newMessages = []
    messageObj = {}
    for message in allMessages:
        if (message.timestamp > oldTimestamp and message.room[0].id == currentRoom().id):
            messageObj = {}
            messageObj['sender'] = message.sender[0].username
            messageObj['text'] = message.text
            messageObj['time'] = message.timestamp
            newMessages.append(messageObj)

    return json.dumps(newMessages)
