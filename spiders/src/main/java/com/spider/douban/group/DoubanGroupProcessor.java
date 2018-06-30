package com.spider.douban.group;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class DoubanGroupProcessor implements PageProcessor {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");

    private String TOPIC_LIST_URL_RE = "https://www.douban.com/group/\\w+/";
    private String TOPIC_POST_URL_RE = "https://www.douban.com/group/topic/\\d+/";

    public void process(Page page) {

       if(page.getUrl().regex(TOPIC_POST_URL_RE).match()){
            String title = page.getHtml().xpath("//*[@id=\"content\"]/h1/text()").get();
            page.putField("title",title);


            String author = page.getHtml().xpath("//span[@class='from']/a/text()").get();
            page.putField("author",author);
            String profile = page.getHtml().xpath("//span[@class='from']/a/@href").get();
            page.putField("profile",profile);


            String content = page.getHtml().xpath("//div[@class='topic-richtext']/text()").get();
           page.putField("content",content);
        }else if(page.getUrl().regex(TOPIC_LIST_URL_RE).match()){
            List<String>  urls = page.getHtml().xpath("//td[@class='title']/a/@href").all();
            logger.info(urls.toString());
            page.addTargetRequests(urls);
        }
    }




    public Site getSite() {
        return this.site;
    }


    public static  void main(String[] args){
        Spider.create(new DoubanGroupProcessor()).addUrl("https://www.douban.com/group/haixiuzu/")
                .run();
    }
}
