from flask import render_template
from flask import request
from flask import redirect
from flask import url_for
from flask import jsonify
from flask_login import login_required, login_user, logout_user
from . import admin
from app.models import User, DoubanGroupTopic


@admin.route('/')
def home():
    return render_template('admin/index.html')

@admin.route('/spiderlist')
def spiderlist():
    return render_template('admin/spiderlist.html')

@admin.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        user_name = request.form.get('username', None)
        password = request.form.get('password', None)
        user = User(user_name)
        user.password = password
        if user.verify_password(password):
            login_user(user)
            return redirect(request.args.get('next') or url_for('admin.home'))

    return render_template('admin/login.html')

@admin.route('/doubantopiclist')
def douban_topic_list():
    return render_template("admin/doubantopiclist.html")

@admin.route('/gettopiclist')
def get_topic_list():
    start = int(request.args.get("start"))
    length = int(request.args.get("length"))
    draw = int(request.args.get("draw"))
    print(request.args)

    data = []
    pagination = DoubanGroupTopic.query.paginate((start/length)+1, per_page=length, error_out=False)
    topics = pagination.items

    for topic in topics:
        data.append({
            "id":topic.topicid,
            "title":topic.topictitle,
            "author":topic.author_name
        })
    total = DoubanGroupTopic.query.count()

    context = {
        "draw": draw,
        "recordsTotal": total,
        "recordsFiltered": total,
        "data":data
    }
    return jsonify(context)

@admin.route('/doubanimagelist')
def douban_image_list():
    return render_template("admin/doubanimagelist.html")

