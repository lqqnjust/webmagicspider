package com.spider.douban.hotshot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
@Component
public class DBHotShotSpider {


    @Autowired
    @Qualifier("dbReviewPipeline")
    private Pipeline dbReviewPipeline;

    public void craw(){
        Spider.create(new DBHotShotProcessor()).thread(5).addUrl("https://movie.douban.com/review/best/?stat=0").addPipeline(dbReviewPipeline).run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        DBHotShotSpider dbHotShotSpider = applicationContext.getBean(DBHotShotSpider.class);
        dbHotShotSpider.craw();
    }
}
