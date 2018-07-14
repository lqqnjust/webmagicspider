import requests
from lxml import etree
from app import db,create_app
from app.models import DoubanGroupTopic,DoubanGroupImage
import os


class DoubanGroupSpider:

    def __init__(self):
        self.urls = ['https://www.douban.com/group/haixiuzu/discussion?start=0']
        self.session = requests.Session()
        self.headers = {
            "User-Agent": "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0"
        }
        self.savedir = r"E:\work\javawork\webmagicspider\web\app\static\images"
        if not os.path.exists(self.savedir):
            os.mkdir(self.savedir)

    def run(self):
        for url in self.urls:
            response = self.session.get(url,headers = self.headers)
            content = response.content
            html = etree.HTML(content)
            topicurls = html.xpath("//td[@class='title']/a/@href")
            for topicurl in topicurls:
                print(topicurl)
                self.processtopic(topicurl)
                #break

    def processtopic(self, topicurl):
        topicid = topicurl.split("/")[-2]
        print(topicid)
        response = self.session.get(topicurl, headers=self.headers)
        content = response.content
        html = etree.HTML(content)
        title = html.xpath("//div[@id='content']/h1/text()")[0].strip()
        print(title)
        author_name = html.xpath("//span[@class='from']/a/text()")[0]

        author_profile = html.xpath("//span[@class='from']/a/@href")[0]
        print(author_name, author_profile)

        content = ''.join(html.xpath("//div[@class='topic-richtext']/p/text()"))
        groupurl = html.xpath('//div[@class="group-item"]/div[2]/div/a/@href')[0]

        topic = DoubanGroupTopic()

        topic.topictitle = title
        topic.author_name = author_name
        topic.authro_profile = author_profile
        topic.topicid = topicid
        topic.topicurl = topicurl
        topic.content = content
        topic.group_url = groupurl
        try:
            db.session.add(topic)
            db.session.commit()
        except Exception as e:
            db.session.rollback()

        imgs = html.xpath("//div[@class='image-wrapper']/img/@src")
        for img in imgs:
            basename = os.path.basename(img)
            image = DoubanGroupImage()
            image.topicid = topicid
            image.imageid = basename
            try:
                db.session.add(image)
                db.session.commit()
            except:
                db.session.rollback()

            self.down(img)

    def down(self, img):
        html = self.session.get(img)
        basename = os.path.basename(img)
        filename = os.path.join(self.savedir,basename)
        with open(filename, 'wb') as file:
            file.write(html.content)


if __name__ == '__main__':
    app = create_app('default')
    app.app_context().push()
    spider = DoubanGroupSpider()
    spider.run()
