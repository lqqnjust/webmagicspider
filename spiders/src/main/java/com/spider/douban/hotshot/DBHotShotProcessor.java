package com.spider.douban.hotshot;

import com.spider.douban.hotshot.models.ReviewBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBHotShotProcessor implements PageProcessor{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");

    private final String TOPIC_POST_URL_RE = "https://movie.douban.com/review/best/\\D+stat=\\d+$";
    private final String TOPIC_CONTENT_URL_RE = "https://movie.douban.com/review/\\d+/";
    private Pattern pattern = Pattern.compile("https://www.douban.com/people/(\\w+)/");//此处一定要打括号，否则不能group
    @Override
    public void process(Page page) {
        String URL = page.getUrl().toString();
        if (page.getUrl().regex(TOPIC_POST_URL_RE).match()) {
//            String nickname = page.getHtml().xpath("//*[@id=\"9485488\"]/header/a[2]/text()").toString();
            //选取所有div的class是main-bd的，h2的子标签的href属性。
            List<String> list = page.getHtml().xpath("//div[@class='main-bd']/h2/a/@href").all();
            for (String s : list) {
                System.out.println(s);
            }
            logger.info(list.toString());
            page.addTargetRequests(list);
//            System.out.println(nickname);
        } else if(page.getUrl().regex(TOPIC_CONTENT_URL_RE).match()){
            ////*[@id="9485488"]/header/a[1]/span
            String nickname = page.getHtml().xpath("//header[@class=\"main-hd\"]/a[1]/span/text()").toString();
            String review_id_url = page.getHtml().xpath("//header[@class=\"main-hd\"]/a[1]/@href").toString();
            Matcher matcher = pattern.matcher(review_id_url);
            String review_id = "";
            if (matcher.find()){
                review_id = matcher.group(1);
            }

            String review_film = page.getHtml().xpath("//header[@class=\"main-hd\"]/a[2]/text()").toString();
            String review_film_url = page.getHtml().xpath("//header[@class=\"main-hd\"]/a[2]/@href").toString();
            String time = page.getHtml().xpath("//span[@class=\"main-meta\"]/text()").toString();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <10 ; i++) {
                String str = "//div[@class=\"main-bd\"]/div[1]/div[1]/p["+i+"]/text()";
                String p = page.getHtml().xpath(str).toString();
                if ( null!=p && !"".equals(p) ){
                    sb.append(p).append("\r\n");
                    continue;
                }else if(null!=p && !"".equals(p) && i==1){
                    p = page.getHtml().xpath("//div[@class=\"main-bd\"]/div[1]/div[1]/p/text()").toString();
                    sb.append(p).append("\r\n");
                    break;
                }
                break;
            }
            System.out.println(sb.toString());
//            System.out.println(nickname+"--"+review_id+"--"+review_film+"--"+review_film_url);
//            System.out.println(time+"--");

            ReviewBean rb = new ReviewBean();
            rb.setContent(sb.toString());
            rb.setNickname(nickname);
            rb.setReview_film(review_film);
            rb.setReview_film_url(review_film_url);
            rb.setReview_id(review_id);
            rb.setTime(time);
            rb.setReview_id_url(review_id_url);

            page.putField("reviewBean",rb);
        }





    }

    @Override
    public Site getSite() {
        return this.site;
    }
}
