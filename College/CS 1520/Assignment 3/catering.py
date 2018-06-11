from flask import Flask, render_template, session, redirect, request, abort, url_for
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config.from_pyfile("config.cfg")
db = SQLAlchemy(app)
statusLookup = {"owner":0, "staff":1, "customer":2}

@app.route("/")
def checkStatus():
    if "status" not in session:
        return redirect(url_for("login_get"))
    elif session["status"] == statusLookup["owner"]:
        return redirect(url_for("owner_viewEvents"))
    elif session["status"] == statusLookup["staff"]:
        return redirect(url_for("staff_viewEvents"))
    elif session["status"] == statusLookup["customer"]:
        return redirect(url_for("customer_viewEvents_get"))
    else:
        return abort(500)



@app.route("/login", methods=["GET"])
def login_get():
    return render_template("login.html", title="Login")

@app.route("/login", methods=["POST"])
def login_post():
    loginForm = request.form
    uname = request.form.get("username")
    pwd = request.form.get("password")
    isNewUser = request.form.get("isNewUser") == "True"
    uError = ""
    pError = ""
    if len(uname) < 4 or len(pwd) < 4:
        if len(loginForm.get("username")) < 4:
            uError = "Must be 4 characters or longer."
        if len(loginForm.get("password")) < 4:
            pError = "Must be 4 characters or longer."
    else:
        user = Users.query.filter_by(username = uname).first()
        if isNewUser:
            if user is None:
                customer = Users(uname, pwd, statusLookup["customer"])
                db.session.add(customer)
                db.session.commit()
                return setSession(customer)
            else:
                uError = "Username is not available."
        else:
            if user is None:
                uError = "Username does not exist."
            else:
                if user.password == pwd:
                    return setSession(user)
                else:
                    pError = "Password is incorrect."
    return render_template("login.html", title="Login", username=uname, usernameError=uError, passwordError=pError)



@app.route("/owner/viewEvents", methods=["GET"])
def owner_viewEvents():
    if "status" in session and session["status"] == statusLookup["owner"]:
        events = Events.query.all()
        ids=[]
        names=[]
        dates=[]
        reqs=[]
        assigned=[]
        for event in events:
            ids.append(event.id)
            names.append(event.name)
            dates.append(event.date)
            req = Users.query.filter_by(id=event.requestedBy).first()
            if req is not None:
                reqs.append(req.username)
            assignList = []
            assign = Users.query.filter_by(id=event.staffMember1).first()
            if assign is not None:
                assignList.append(assign.username)
            assign = Users.query.filter_by(id=event.staffMember2).first()
            if assign is not None:
                assignList.append(assign.username)
            assign = Users.query.filter_by(id=event.staffMember3).first()
            if assign is not None:
                assignList.append(assign.username)
            assigned.append(", ".join(assignList))
        return render_template("viewEvents.html", title="View All Events", altViewButton="Create Staff Account", altViewURL=url_for("owner_createStaffAccount_get"), eventList=events, id=ids, name=names, date=dates, req=reqs, assign=assigned, noEventsMessage="There are no events scheduled.")
    else:
        return abort(403)

@app.route("/owner/createStaffAccount", methods=["GET"])
def owner_createStaffAccount_get():
    if "status" in session and session["status"] == statusLookup["owner"]:
        return render_template("owner_createStaff.html", title="Create Staff Account", altViewButton="View All Events", altViewURL=url_for("owner_viewEvents"))
    else:
        return abort(403)

@app.route("/owner/createStaffAccount", methods=["POST"])
def owner_createStaffAccount_post():
    if "status" in session and session["status"] == statusLookup["owner"]:
        accountForm = request.form
        uname = request.form.get("username")
        pwd = request.form.get("password")
        uError = ""
        pError = ""
        gError = ""
        if len(uname) < 4 or len(pwd) < 4:
            if len(loginForm.get("username")) < 4:
                uError = "Must be 4 characters or longer."
            if len(loginForm.get("password")) < 4:
                pError = "Must be 4 characters or longer."
        else:
            user = Users.query.filter_by(username = uname).first()
            if user is None:
                staff = Users(uname, pwd, statusLookup["staff"])
                db.session.add(staff)
                db.session.commit()
                gError = "Account created successfully."
            else:
                uError = "Username is not available."
        return render_template("owner_createStaff.html", title="Create Staff Account", altViewButton="View Events", altViewURL=url_for("owner_viewEvents"), username=uname, usernameError=uError, passwordError=pError, generalError=gError)
    else:
        return abort(403)



@app.route("/staff/viewEvents", methods=["GET"])
def staff_viewEvents():
    if "status" in session and session["status"] == statusLookup["staff"]:
        events = Events.query.filter_by(staffMember1=session["id"]).all() + Events.query.filter_by(staffMember2=session["id"]).all() + Events.query.filter_by(staffMember3=session["id"]).all()
        ids=[]
        names=[]
        dates=[]
        reqs=[]
        assigned=[]
        for event in events:
            ids.append(event.id)
            names.append(event.name)
            dates.append(event.date)
            req = Users.query.filter_by(id=event.requestedBy).first()
            if req is not None:
                reqs.append(req.username)
            assignList = []
            assign = Users.query.filter_by(id=event.staffMember1).first()
            if assign is not None:
                assignList.append(assign.username)
            assign = Users.query.filter_by(id=event.staffMember2).first()
            if assign is not None:
                assignList.append(assign.username)
            assign = Users.query.filter_by(id=event.staffMember3).first()
            if assign is not None:
                assignList.append(assign.username)
            assigned.append(", ".join(assignList))
        return render_template("viewEvents.html", title="My Events", altViewButton="View Open Events", altViewURL=url_for("staff_eventSignUp_get"), eventList=events, id=ids, name=names, date=dates, req=reqs, assign=assigned, noEventsMessage="You are not signed up for any events.")
    else:
        return abort(403)

@app.route("/staff/signUp", methods=["GET"])
def staff_eventSignUp_get():
    if "status" in session and session["status"] == statusLookup["staff"]:
        events = Events.query.all()
        ids=[]
        names=[]
        dates=[]
        reqs=[]
        assigned=[]
        for event in events:
            if not(event.staffMember1 and event.staffMember2 and event.staffMember3) and not(event.staffMember1==session["id"] or event.staffMember2==session["id"] or event.staffMember3==session["id"]):
                ids.append(event.id)
                names.append(event.name)
                dates.append(event.date)
                req = Users.query.filter_by(id=event.requestedBy).first()
                if req is not None:
                    reqs.append(req.username)
                assignList = []
                assign = Users.query.filter_by(id=event.staffMember1).first()
                if assign is not None:
                    assignList.append(assign.username)
                assign = Users.query.filter_by(id=event.staffMember2).first()
                if assign is not None:
                    assignList.append(assign.username)
                assign = Users.query.filter_by(id=event.staffMember3).first()
                if assign is not None:
                    assignList.append(assign.username)
                assigned.append(", ".join(assignList))
        return render_template("staff_eventSignUp.html", title="Open Events", altViewButton="View My Events", altViewURL=url_for("staff_viewEvents"), eventList=events, id=ids, name=names, date=dates, req=reqs, assign=assigned)
    else:
        return abort(403)

@app.route("/staff/signUp", methods=["POST"])
def staff_eventSignUp_post():
    if "status" in session and session["status"] == statusLookup["staff"]:
        event = Events.query.filter_by(id=request.form.get("eventID")).first()
        if not event.staffMember1:
            event.staffMember1 = session["id"]
        elif not event.staffMember2:
            event.staffMember2 = session["id"]
        else:
            event.staffMember3 = session["id"]
        db.session.commit()
        return redirect(url_for("staff_eventSignUp_get"))
    else:
        return abort(403)



@app.route("/customer/viewEvents", methods=["GET"])
def customer_viewEvents_get():
    if "status" in session and session["status"] == statusLookup["customer"]:
        events = Events.query.filter_by(requestedBy = session["id"]).all()
        ids=[]
        names=[]
        dates=[]
        reqs=[]
        assigned=[]
        for event in events:
            ids.append(event.id)
            names.append(event.name)
            dates.append(event.date)
            req = Users.query.filter_by(id=event.requestedBy).first()
            if req is not None:
                reqs.append(req.username)
            assignList = []
            assign = Users.query.filter_by(id=event.staffMember1).first()
            if assign is not None:
                assignList.append(assign.username)
            assign = Users.query.filter_by(id=event.staffMember2).first()
            if assign is not None:
                assignList.append(assign.username)
            assign = Users.query.filter_by(id=event.staffMember3).first()
            if assign is not None:
                assignList.append(assign.username)
            assigned.append(", ".join(assignList))
        return render_template("customer_viewEvents.html", title="My Events", altViewButton="Create New Event", altViewURL=url_for("customer_createEvent_get"), eventList=events, id=ids, name=names, date=dates, req=reqs, assign=assigned)
    else:
        return abort(403)

@app.route("/customer/viewEvents", methods=["POST"])
def customer_viewEvents_post():
    if "status" in session and session["status"] == statusLookup["customer"]:
        event = Events.query.filter_by(id=request.form.get("eventID")).first()
        db.session.delete(event)
        db.session.commit()
        return redirect(url_for("customer_viewEvents_get"))
    else:
        return abort(403)

@app.route("/customer/createEvent", methods=["GET"])
def customer_createEvent_get():
    if "status" in session and session["status"] == statusLookup["customer"]:
        return render_template("customer_createEvent.html", title="Create New Event", altViewButton="View Events", altViewURL=url_for("customer_viewEvents_get"))
    else:
        return abort(403)

@app.route("/customer/createEvent", methods=["POST"])
def customer_createEvent_post():
    if "status" in session and session["status"] == statusLookup["customer"]:
        eventForm = request.form
        name = request.form.get("name")
        date = request.form.get("date")
        nameError = ""
        dateError = ""
        generalError = ""
        if len(name) < 4 or len(date) < 6:
            if len(name) < 4:
                nameError = "Must be 4 characters or longer."
            if len(date) < 6:
                dateError = "Select a valid date."
        else:
            e = Events.query.filter_by(date=date).first()
            print(e)
            print(date)
            if e is None:
                event = Events(name, date, session["id"], None, None, None)
                db.session.add(event)
                db.session.commit()
                return redirect(url_for("customer_viewEvents_get"))
            else:
                generalError = "The company is already booked for this date."
        return render_template("customer_createEvent.html", title="Create New Event", altViewButton="View Events", altViewURL=url_for("customer_viewEvents_get"), name=name, date=date, nameError=nameError, dateError=dateError, generalError=generalError)
    else:
        return abort(403)



@app.route("/logout", methods=["GET"])
def endSession():
    session.pop("username", None)
    session.pop("status", None)
    session.pop("id", None)
    return redirect("/")

def setSession(user):
    session["username"] = user.username
    session["status"] = user.status
    session["id"] = user.id
    return redirect("/")



class Users(db.Model):
    __tablename__ = 'users'
    id = db.Column(db.Integer, primary_key = True)
    username = db.Column(db.String(64), unique = True, nullable = False)
    password = db.Column(db.String(256), nullable = False)
    status = db.Column(db.Integer, nullable = False)

    def __init__(self, username, password, status):
        self.username = username
        self.password = password
        self.status = status

class Events(db.Model):
    __tablename__ = 'events'
    id = db.Column(db.Integer, primary_key = True)
    name = db.Column(db.String(256), nullable = False)
    date = db.Column(db.String, nullable = False)
    requestedBy = db.Column(db.Integer)
    staffMember1 = db.Column(db.Integer)
    staffMember2 = db.Column(db.Integer)
    staffMember3 = db.Column(db.Integer)

    def __init__(self, name, date, requestedBy, staffMember1, staffMember2, staffMember3):
        self.name = name
        self.date = date
        self.requestedBy = requestedBy
        self.staffMember1 = staffMember1
        self.staffMember2 = staffMember2
        self.staffMember3 = staffMember3




@app.cli.command("initdb")
def initdb():
    db.create_all()
    owner = Users("owner", "pass", statusLookup["owner"])
    db.session.add(owner)
    db.session.commit()
    print("Database initialized.")

@app.cli.command("viewdb")
def viewdb():
    print("\n")
    print("USERS:")
    print("{0:3s} | {1:20s} | {2:20s} | {3:6s}".format("id", "username", "password", "status"))
    print("----------------------------------------------------------")
    for user in Users.query.all():
        print("{0:3d} | {1:20s} | {2:20s} | {3:6s}".format(user.id, repr(user.username), repr(user.password), repr(user.status)))
    print("\n\n")
    print("EVENTS:")
    print("{0:3s} | {1:20s} | {2:12s} | {3:5s} | {4:5s} | {5:5s} | {6:5s}".format("id", "name", "date", "req", "sm1", "sm2", "sm3"))
    print("------------------------------------------------------------------------")
    for event in Events.query.all():
        print("{0:3d} | {1:20s} | {2:12s} | {3:5s} | {4:5s} | {5:5s} | {6:5s}".format(event.id, repr(event.name), repr(event.date), repr(event.requestedBy), repr(event.staffMember1), repr(event.staffMember2), repr(event.staffMember3)))
    print("\n")

@app.cli.command("cleardb")
def cleardb():
    db.drop_all()
    print("Database cleared.")




if __name__ == "__main__":
    app.run()
