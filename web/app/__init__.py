from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_login import LoginManager
from config import config


db = SQLAlchemy()
login_manager = LoginManager()
login_manager.session_protection = 'None' # 可以设置None,'basic','strong'  以提供不同的安全等级,一般设置strong,如果发现异常会登出用户。
login_manager.login_view = 'admin.login' # 这里填写你的登陆界面的路由

# 工厂函数
def create_app(config_name):
    app = Flask(__name__)
    app.config.from_object(config[config_name])
    config[config_name].init_app(app)

    db.init_app(app)
    #login_manager.init_app(app=app)

    #注册蓝本
    from .main import main as main_blueprint
    app.register_blueprint(main_blueprint)

    from .admin import admin as admin_blueprint
    app.register_blueprint(admin_blueprint)

    return app

