package com.wang.weixin.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.json.JSONArray;
import org.json.JSONException;

public class DWZUtils {
	HttpClient httpClient = new HttpClient();

	public String mkURL(String intURL, String url){
		JSONArray jsonObject = getDataByHTTPGET(intURL+"?source=1681459862&url_long=" + url);
		System.out.println(jsonObject);
		try {
			return jsonObject.getJSONObject(0).getString("url_short");
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	public JSONArray getDataByHTTPGET(String url){
		HttpClient httpClient=new HttpClient();
		//设置url
		GetMethod get = new GetMethod(url);
		//设置请求参数
		try {
			//提交请求
			int code = httpClient.executeMethod(get);
			if (code == 200) {
				return new JSONArray(get.getResponseBodyAsString());
			} else {
				System.err.println("error： " + code + " -- " + get.getResponseBodyAsString());
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		DWZUtils dwzUtils = new DWZUtils();
		System.out.println(dwzUtils.mkURL("http://api.t.sina.com.cn/short_url/shorten.json", "http://www.baidu.com/"));
	}
}