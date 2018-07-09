package com.spider.douban.hotshot.pipline;

import com.spider.douban.hotshot.dao.ReviewDao;
import com.spider.douban.hotshot.models.ReviewBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
@Component("dbReviewPipeline")
public class DBReviewPipeline implements Pipeline {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ReviewDao reviewDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        ReviewBean bean = (ReviewBean)resultItems.get("reviewBean");

        try {
            reviewDao.addReview(bean);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
