package com.spider.douban.group;

import com.spider.douban.group.models.TopicBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubanGroupProcessor implements PageProcessor {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");

    private String TOPIC_LIST_URL_RE = "https://www.douban.com/group/\\w+/";
    private String TOPIC_POST_URL_RE = "https://www.douban.com/group/topic/\\d+/";
    Pattern r = Pattern.compile("https://www.douban.com/group/(\\w+)/\\?ref=sidebar");

    public void process(Page page) {

        if (page.getUrl().regex(TOPIC_POST_URL_RE).match()) {

            String groupurl = page.getHtml().xpath("//div[@class='pic']/a/@href").toString();
            Matcher matcher = r.matcher(groupurl);
            String groupid="";
            if(matcher.find()){
                groupid =matcher.group(1);
            }
            String id=page.getUrl().regex("https://www.douban.com/group/topic/(\\d+)/").toString();

            TopicBean topic=new TopicBean();

            String title = page.getHtml().xpath("//*[@id=\"content\"]/h1/text()").get();
            topic.setTitle(title);
            topic.setTopicid(id);
            topic.setGroupid(groupid);

            String author = page.getHtml().xpath("//span[@class='from']/a/text()").get();

            String profile = page.getHtml().xpath("//span[@class='from']/a/@href").get();

            topic.setAuthor(author);
            topic.setAuthor_profile(profile);

            String content = page.getHtml().xpath("//div[@class='topic-richtext']/p/text()").get();
            if(content==null){
                content = "";
            }

            topic.setContent(content);

            List<String> imgurls = page.getHtml().xpath("//div[@class='topic-richtext']/div/div/img/@src").all();
            topic.setImageurls(imgurls);

            page.putField("topic",topic);

        } else if (page.getUrl().regex(TOPIC_LIST_URL_RE).match()) {
            List<String> urls = page.getHtml().xpath("//td[@class='title']/a/@href").all();
            logger.info(urls.toString());
            page.addTargetRequests(urls);
        }
    }


    public Site getSite() {
        return this.site;
    }

}
