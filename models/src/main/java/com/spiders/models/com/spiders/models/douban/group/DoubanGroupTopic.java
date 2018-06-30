package com.spiders.models.com.spiders.models.douban.group;

import java.util.Date;

/**
 * 豆瓣小组话题
 */
public class DoubanGroupTopic {
    //标题
    String title;
    //url
    String url;
    //作者id
    String author;
    //创建时间
    Date createDate;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
