package com.spider.douban.hotshot.models;

public class ReviewBean {

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getReview_id_url() {
        return review_id_url;
    }

    public void setReview_id_url(String review_id_url) {
        this.review_id_url = review_id_url;
    }

    public String getReview_id() {
        return review_id;
    }

    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

    public String getReview_film() {
        return review_film;
    }

    public void setReview_film(String review_film) {
        this.review_film = review_film;
    }

    public String getReview_film_url() {
        return review_film_url;
    }

    public void setReview_film_url(String review_film_url) {
        this.review_film_url = review_film_url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String nickname;
    private String review_id_url;
    private String review_id;
    private String review_film;
    private String review_film_url;
    private String time;
    private String content;

}
