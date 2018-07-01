package com.spider.douban.group.models;

import java.util.List;

public class TopicBean {
    String title;
    String topicid;
    String author;
    String author_profile;
    List<String> imageurls;
    String content;
    String groupid;

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_profile() {
        return author_profile;
    }

    public void setAuthor_profile(String author_profile) {
        this.author_profile = author_profile;
    }

    public List<String> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<String> imageurls) {
        this.imageurls = imageurls;
    }

    @Override
    public String toString() {
        return "TopicBean{" +
                "title='" + title + '\'' +
                ", topicid='" + topicid + '\'' +
                ", author='" + author + '\'' +
                ", author_profile='" + author_profile + '\'' +
                ", imageurls=" + imageurls +
                ", content='" + content + '\'' +
                ", groupid='" + groupid + '\'' +
                '}';
    }
}
