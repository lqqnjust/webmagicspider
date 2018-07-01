package com.spider.douban.group.dao;

import com.spider.douban.group.models.ImageBean;
import com.spider.douban.group.models.TopicBean;
import org.apache.ibatis.annotations.Insert;

public interface GroupDao {
    @Insert("insert into topic (title,topicid,author,profile,content,groupid) values (#{title},#{topicid},#{author},#{author_profile},#{content},#{groupid})")
    public int addTopic(TopicBean topic);

    @Insert("insert into image (topicid,url) values (#{topicid},#{url})")
    public int addImage(ImageBean image);
}
