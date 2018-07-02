package com.spider.douban.group;

import com.spider.douban.group.pipline.MysqlPipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class DoubanGroupSpider {

    @Autowired
    @Qualifier("mysqlpipline")
    private Pipeline jobInfoDaoPipeline;


    public void crawl() {
        Spider.create(new DoubanGroupProcessor()).addUrl("https://www.douban.com/group/haixiuzu/discussion?start=0")
                .addPipeline(jobInfoDaoPipeline)
                .run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final DoubanGroupSpider jobCrawler = applicationContext.getBean(DoubanGroupSpider.class);
        jobCrawler.crawl();
    }
}
