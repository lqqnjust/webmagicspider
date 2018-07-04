package com.spider.douban.group.pipline;

import com.spider.douban.group.dao.GroupDao;
import com.spider.douban.group.models.ImageBean;
import com.spider.douban.group.models.TopicBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Component("mysqlpipline")
public class MysqlPipline implements Pipeline {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private GroupDao groupDao;

    String savedir="images";

    @Override
    public void process(ResultItems resultItems, Task task) {
        TopicBean bean = (TopicBean)resultItems.get("topic");

        try {
            groupDao.addTopic(bean);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("bean:"+bean);
        }

        List<String> urls = bean.getImageurls();
        for(String url:urls){
            ImageBean img = new ImageBean();
            img.setTopicid(bean.getTopicid());
            img.setUrl(url);
            try{
                groupDao.addImage(img);
            }catch (Exception e){

            }

            try{
                download(url,getfilename(url),this.savedir);
            }catch (Exception e){
                logger.error(e.toString());
            }



        }
    }

    private String getfilename(String url){
        String[] items = url.split("/");
        return items[items.length-1];
    }

    public void download(String urlString, String filename, String savePath) throws Exception {
                // 构造URL
                URL url = new URL(urlString);
               // 打开连接
               URLConnection con = url.openConnection();
               // 设置请求头
                con.addRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)");
                // 设置请求超时为5s
                con.setConnectTimeout(5 * 1000);
                // 输入流
                InputStream is = con.getInputStream();
               // 1K的数据缓冲
                byte[] bs = new byte[1024];
                // 读取到的数据长度
                 int len;
                // 输出的文件流
                File sf = new File(savePath);
                 if (!sf.exists()) {
                        sf.mkdirs();
                     }
                OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
                // 开始读取
                while ((len = is.read(bs)) != -1) {
                         os.write(bs, 0, len);
                   }
                // 完毕，关闭所有链接
                 os.close();
                is.close();
            }
}
