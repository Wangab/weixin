package com.wang.weixin.service.impl;

import com.wang.weixin.protracted.MessageInfo;
import com.wang.weixin.protracted.dao.ActivityDAO;
import com.wang.weixin.protracted.dao.UserDAO;
import com.wang.weixin.protracted.responsemsg.*;
import com.wang.weixin.service.BaiduMusicComponet;
import com.wang.weixin.service.ICoreService;
import com.wang.weixin.service.TuLinCompoment;
import com.wang.weixin.utils.DWZUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/10.
 */
public class CoreService implements ICoreService{
    @Resource
    @Qualifier("tulinComponet")
    private TuLinCompoment talks;

    @Resource
    @Qualifier("baidumusic")
    private BaiduMusicComponet baiduMusic;

    @Resource
    @Qualifier("userDAO")
    private UserDAO userDAO;

    @Resource
    @Qualifier("activityDAO")
    private ActivityDAO activityDAO;

    @Resource
    @Qualifier("dwzUtils")
    DWZUtils dwzUtils;

    List<String> words;

    public CoreService(List<String> words) {
        this.words = words;
    }

    /**
     * 处理微信发过来的请求
     * @param request
     * @return
     */
    @Override
    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, String> requestMap = MessageInfo.parseXml(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageInfo.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            // 文本消息
            if (msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_TEXT)) {
                List<Article> articleList = new ArrayList<Article>();

                String contents = requestMap.get("Content");
                System.out.println();
                if(contents.startsWith("@")){
                    if(contents.substring(1) !=null || !"".equals(contents.substring(1).trim())){

                        List<Map<String, Object>> userMaps = userDAO.getUserInfoList(contents.substring(1));
                        if (userMaps.size() > 0 ){
                            for (Map<String, Object> userMap:userMaps){
                                String uid = userMap.get("uid").toString();
                                String nick = userMap.get("nick").toString();
                                String picUrl = dwzUtils.mkURL("http://api.t.sina.com.cn/short_url/shorten.json", userDAO.getUserIconURL(uid));
                                String url = dwzUtils.mkURL("http://api.t.sina.com.cn/short_url/shorten.json", "http://*.*.*.*/weixin/wx/show?uid="+uid);
                                System.out.println(uid + "\t" + nick + "\t" + picUrl + "\t" + url);

                                Article article1 = new Article();
                                article1.setTitle(nick + "的主页");
                                article1.setDescription(nick + "的说明");
                                article1.setPicUrl(picUrl);
                                article1.setUrl(url);
                                articleList.add(article1);
                            }
                            NewsMessage newsMessage = new NewsMessage();
                            newsMessage.setMsgType(MessageInfo.RESP_MESSAGE_TYPE_NEWS);
                            newsMessage.setToUserName(fromUserName);
                            newsMessage.setFromUserName(toUserName);
                            newsMessage.setCreateTime(new Date().getTime());
                            newsMessage.setArticleCount(articleList.size());
                            newsMessage.setArticles(articleList);
                            return MessageInfo.newsMessageToXml(newsMessage);
                        }else {
                                JSONObject jsonObject = new JSONObject(talks.talk(contents, fromUserName));
                                respContent = jsonObject.optString("text");
                            }

                    }else{
                        JSONObject jsonObject = new JSONObject(talks.talk(contents, fromUserName));
                        respContent = jsonObject.optString("text") + " !";
                    }
                }else if(words.contains(contents.trim())){
                    Article article1 = new Article();
                    article1.setTitle("最新的活动尽在这里");
                    article1.setDescription("我们将展示最新的活动给你");
                    article1.setPicUrl("http://123.57.249.68/M00/00/01/CjNWhFdAQCSAGKC5AAMCmLKKuAk346.png");
                    article1.setUrl("http://123.57.249.54/westar-api-service/actlist.action?page=0&pageSize=100");
                    articleList.add(article1);

                    NewsMessage newsMessage = new NewsMessage();
                    newsMessage.setMsgType(MessageInfo.RESP_MESSAGE_TYPE_NEWS);
                    newsMessage.setToUserName(fromUserName);
                    newsMessage.setFromUserName(toUserName);
                    newsMessage.setCreateTime(new Date().getTime());
                    newsMessage.setArticleCount(articleList.size());
                    newsMessage.setArticles(articleList);
                    return MessageInfo.newsMessageToXml(newsMessage);
                }else{
                    JSONObject jsonObject = new JSONObject(talks.talk(contents, fromUserName));
                    respContent = jsonObject.optString("text") + " !";
                }

            }
            // 图片消息
            else if (msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 音频消息
            else if (msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
            }
            // 短视频消息
            else if(msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_SHORTVIDEO)){
                respContent = "您发送的是短视频消息！";
            }
            // 视频消息
            else if(msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_VOICE)){
                respContent = "您正在发送视频";
            }
            // 事件推送
            else if (msgType.equals(MessageInfo.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageInfo.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！我可是人工智能机器人哦！向我发送文字可以跟我聊天哦！另外通过\"@手机号或昵称\"可以查看你的主页哦!例如：@15811525879,可以输入\"#活动\"，来查询最新的活动哦！";
                }
                // 取消订阅
                else if (eventType.equals(MessageInfo.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageInfo.EVENT_TYPE_CLICK)) {
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应
                    String eventKey = requestMap.get("EventKey");

                    if (eventKey.equals("11")) {
                        //获取菜单点击事件的值，做一些事情。。。。。。。
                    } else if (eventKey.equals("12")) {
                        //获取菜单点击事件的值，做一些事情。。。。。。。
                    } else if (eventKey.equals("13")) {
                        //获取菜单点击事件的值，做一些事情。。。。。。。
                    } else if (eventKey.equals("14")) {
                        //获取菜单点击事件的值，做一些事情。。。。。。。
                    } else if (eventKey.equals("21")) {
                        // 搜索音乐
                        Music music = baiduMusic.searchMusic("泡沫", "邓紫棋");
                        // 音乐消息
                        MusicMessage musicMessage = new MusicMessage();
                        musicMessage.setToUserName(fromUserName);
                        musicMessage.setFromUserName(toUserName);
                        musicMessage.setCreateTime(new Date().getTime());
                        musicMessage.setMsgType(MessageInfo.RESP_MESSAGE_TYPE_MUSIC);
                        musicMessage.setMusic(music);
                        return MessageInfo.musicMessageToXml(musicMessage);
                    } else if (eventKey.equals("22")) {
                        //获取菜单点击事件的值，做一些事情。。。。。。。
                    } else if (eventKey.equals("23")) {
                        //获取菜单点击事件的值，做一些事情。。。。。。。
                    } else if (eventKey.equals("24")) {
                        Article article1 = new Article();
                        article1.setTitle("第1篇\n伟大的领袖（一）");
                        article1.setDescription("新闻说明");
                        article1.setPicUrl("http://b56.photo.store.qq.com/psu?/db7bc7a6-7ee8-41cd-938a-a4b729257602/YcI*a51P7kjZ1Y43enjYuHawKqC7BZDxX1vvWOy1bTA!/b/YaQGrRxHTwAAYjtKdiGxBgAA&a=48&b=56&bo=9AHuAgAAAAABBDo!&rf=viewer_4");
                        article1.setUrl("http://user.qzone.qq.com/909240405/main");

                        Article article2 = new Article();
                        article2.setTitle("第2篇\n伟大的领袖（二）");
                        article2.setDescription("新闻说明");
                        article2.setPicUrl("http://b56.photo.store.qq.com/psu?/db7bc7a6-7ee8-41cd-938a-a4b729257602/YcI*a51P7kjZ1Y43enjYuHawKqC7BZDxX1vvWOy1bTA!/b/YaQGrRxHTwAAYjtKdiGxBgAA&a=48&b=56&bo=9AHuAgAAAAABBDo!&rf=viewer_4");
                        article2.setUrl("http://user.qzone.qq.com/909240405/main");

                        Article article3 = new Article();
                        article3.setTitle("第3篇\n伟大的领袖（三）");
                        article3.setDescription("新闻说明");
                        article3.setPicUrl("http://b56.photo.store.qq.com/psu?/db7bc7a6-7ee8-41cd-938a-a4b729257602/YcI*a51P7kjZ1Y43enjYuHawKqC7BZDxX1vvWOy1bTA!/b/YaQGrRxHTwAAYjtKdiGxBgAA&a=48&b=56&bo=9AHuAgAAAAABBDo!&rf=viewer_4");
                        article3.setUrl("http://user.qzone.qq.com/909240405/main");

                        List<Article> articleList = new ArrayList<Article>();
                        articleList.add(article1);
                        articleList.add(article2);
                        articleList.add(article3);

                        NewsMessage newsMessage = new NewsMessage();
                        newsMessage.setMsgType(MessageInfo.RESP_MESSAGE_TYPE_NEWS);
                        newsMessage.setToUserName(fromUserName);
                        newsMessage.setFromUserName(toUserName);
                        newsMessage.setCreateTime(new Date().getTime());
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);

                        return MessageInfo.newsMessageToXml(newsMessage);
                    } else if (eventKey.equals("25")) {
                        //获取菜单点击事件的值，做一些事情。。。。。。。
                    }
                }
            }

            textMessage.setContent(respContent);
            respMessage = MessageInfo.textMessageToXml(textMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----- >>>> " + respMessage);
        return respMessage;
    }

    public void setTalks(TuLinCompoment talks) {
        this.talks = talks;
    }

}
