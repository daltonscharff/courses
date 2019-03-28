from app import app, db
from app.models import User, Room, Message

@app.cli.command("initdb")
def initdb():
    db.create_all()
    adm = User(username="adm", password="password")
    db.session.add(adm)
    db.session.commit()
    print("Database initialized.")
