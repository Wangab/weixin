package com.wang.weixin.protracted.requestmsg;

/**
 * 图片消息
 *
 * @author WangAnbang
 */
public class ImageMessage extends BaseMessage {
	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}