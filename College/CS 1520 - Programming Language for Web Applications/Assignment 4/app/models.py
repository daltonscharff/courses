from app import db

ownedRooms = db.Table('ownedRooms',
    db.Column('user_id', db.Integer, db.ForeignKey('user.id'), primary_key=False),
    db.Column('room_id', db.Integer, db.ForeignKey('room.id'), primary_key=True)
)

sentMessages = db.Table('sentMessages',
    db.Column('user_id', db.Integer, db.ForeignKey('user.id'), primary_key=False),
    db.Column('message_id', db.Integer, db.ForeignKey('message.id'), primary_key=False)
)

roomUsers = db.Table('roomUsers',
    db.Column('room_id', db.Integer, db.ForeignKey('room.id'), primary_key=False),
    db.Column('user_id', db.Integer, db.ForeignKey('user.id'), primary_key=True)
)

containsMessages = db.Table('containsMessages',
    db.Column('room_id', db.Integer, db.ForeignKey('room.id'), primary_key=False),
    db.Column('message_id', db.Integer, db.ForeignKey('message.id'), primary_key=True)
)


class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(64), unique=True, nullable=False)
    password = db.Column(db.String(64), nullable=False)

    ownedRooms = db.relationship('Room', secondary=ownedRooms, lazy='subquery', backref=db.backref('owner', lazy=True))
    sentMessages = db.relationship('Message', secondary=sentMessages, lazy='subquery', backref=db.backref('sender', lazy=True))
    # currentRoom

    def __repr__(self):
        return '<User %r>' % self.username

class Room(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(256), nullable=False)
    available = db.Column(db.Integer, nullable=False, default=1)

    roomUsers = db.relationship('User', secondary=roomUsers, lazy='subquery', backref=db.backref('currentRoom', lazy=True))
    messages = db.relationship('Message', secondary=containsMessages, lazy='subquery', backref=db.backref('room', lazy=True))
    # owner

    def __repr__(self):
        return '<Room %r>' % self.id

class Message(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    timestamp = db.Column(db.Integer, nullable=False)
    text = db.Column(db.String(512), nullable=False)

    # room
    # sender

    def __repr__(self):
        return '<Message %r>' % self.id
