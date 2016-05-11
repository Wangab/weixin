package com.wang.weixin.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by wanganbang on 5/11/16.
 */

public class TuLinCompoment {

    private String TULING_TALK_URL;
    private String DEFAULT_TALK;
    private String API_KEY;

    public TuLinCompoment(String api_key, String default_talk, String tulin_url) {
        this.API_KEY = api_key;
        this.DEFAULT_TALK = default_talk;
        this.TULING_TALK_URL = tulin_url;
    }

    public String talk(String apikey, String contents, String userid) {
        try {
            String APIKEY = apikey;
            String INFO = URLEncoder.encode(contents, "utf-8");
            String getURL = TULING_TALK_URL + "?key=" + APIKEY + "&info=" + INFO + "&userid=" + userid;
            URL getUrl = new URL(getURL);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            connection.disconnect();
            return result == null ? DEFAULT_TALK : result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DEFAULT_TALK;
    }

    public String talk(String contents, String userid) {
        return talk(API_KEY, contents, userid);
    }

}
