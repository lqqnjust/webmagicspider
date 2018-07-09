package com.spider.douban.hotshot.dao;

import com.spider.douban.hotshot.models.ReviewBean;
import org.apache.ibatis.annotations.Insert;

public interface ReviewDao {

    @Insert("insert into review (nickname,review_id_url,review_id,review_film,review_film_url,time,content) values (#{nickname},#{review_id_url},#{review_id},#{review_film},#{review_film_url},#{time},#{content})")
    public int addReview(ReviewBean reviewBean);

    //private String nickname;
    //    private String review_id_url;
    //    private String review_id;
    //    private String review_film;
    //    private String review_film_url;
    //    private String time;
    //    private String content;


}
