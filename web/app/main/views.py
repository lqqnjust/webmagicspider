from flask import render_template

from . import main

@main.route("/")
def index():
    return 'hello'