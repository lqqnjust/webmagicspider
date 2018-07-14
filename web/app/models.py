from app import db
from werkzeug.security import  generate_password_hash,check_password_hash

from flask_login import UserMixin


class User(UserMixin,db.Model):
    __tablename__ = 'sys_users'

    id = db.Column(db.Integer, primary_key=True)
    UserCode = db.Column(db.String(64), unique=True, index=True)
    Password = db.Column(db.String(128))

    def __init__(self, UserCode=None, Password=None):
        self.UserCode = UserCode

    def __repr__(self):
        return '<User %r>' % self.UserCode

    @property
    def password(self):
        raise AttributeError('password is not a readable attribute')

    @password.setter
    def password(self, password):
        self.Password = generate_password_hash(password)

    def verify_password(self, password):
        return check_password_hash(self.Password, password)








class DoubanGroupTopic(db.Model):
    __tablename__ = 'doubangroup_topic'

    topicid = db.Column(db.String(64), primary_key=True)
    topictitle = db.Column(db.String(128))
    topicurl = db.Column(db.String(128))
    author_name = db.Column(db.String(64))
    authro_profile = db.Column(db.String(128))
    group_url = db.Column(db.String(128))
    content = db.Column(db.Text())

class DoubanGroupImage(db.Model):
    __tablename__ = 'doubangroup_image'

    imageid = db.Column(db.String(64), primary_key = True)
    topicid = db.Column(db.String(64))