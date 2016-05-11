package com.wang.weixin.protracted.responsemsg;

/**
 * 音乐消息
 *
 * @author WangAnbang
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}