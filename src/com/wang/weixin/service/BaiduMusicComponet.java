package com.wang.weixin.service;

import com.wang.weixin.protracted.responsemsg.Music;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by wanganbang on 5/11/16.
 */
public class BaiduMusicComponet {
    private String requestUrl;

    public BaiduMusicComponet(String url) {
        this.requestUrl = url;
    }

    public Music searchMusic(String musicTitle, String musicAuthor) {
        requestUrl = requestUrl.replace("{TITLE}", urlEncodeUTF8(musicTitle));
        requestUrl = requestUrl.replace("{AUTHOR}", urlEncodeUTF8(musicAuthor));
        requestUrl = requestUrl.replaceAll("\\+", "%20");

        InputStream inputStream = httpRequest(requestUrl);
        Music music = parseMusic(inputStream);

        if (null != music) {
            music.setTitle(musicTitle);
            if (!"".equals(musicAuthor))
                music.setDescription(musicAuthor);
            else
                music.setDescription("ÀŽ×Ô°Ù¶ÈÒôÀÖ");
        }
        return music;
    }
    private String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    private InputStream httpRequest(String requestUrl) {
        InputStream inputStream = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            // »ñµÃ·µ»ØµÄÊäÈëÁ÷
            inputStream = httpUrlConn.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }
    private Music parseMusic(InputStream inputStream) {
        Music music = null;
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            String count = root.element("count").getText();
            if (!"0".equals(count)) {
                List<Element> urlList = root.elements("url");
                List<Element> durlList = root.elements("durl");

                String urlEncode = urlList.get(0).element("encode").getText();
                String urlDecode = urlList.get(0).element("decode").getText();
                String url = urlEncode.substring(0, urlEncode.lastIndexOf("/") + 1) + urlDecode;
                if (-1 != urlDecode.lastIndexOf("&"))
                    url = urlEncode.substring(0, urlEncode.lastIndexOf("/") + 1) + urlDecode.substring(0, urlDecode.lastIndexOf("&"));
                String durl = url;
                Element durlElement = durlList.get(0).element("encode");
                if (null != durlElement) {
                    String durlEncode = durlList.get(0).element("encode").getText();
                    String durlDecode = durlList.get(0).element("decode").getText();
                    durl = durlEncode.substring(0, durlEncode.lastIndexOf("/") + 1) + durlDecode;
                    if (-1 != durlDecode.lastIndexOf("&"))
                        durl = durlEncode.substring(0, durlEncode.lastIndexOf("/") + 1) + durlDecode.substring(0, durlDecode.lastIndexOf("&"));
                }
                music = new Music();
                music.setMusicUrl(url);
                music.setHQMusicUrl(durl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return music;
    }
}
