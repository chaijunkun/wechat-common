package com.github.chaijunkun.wechat.common;

/**
 * 微信API接入配置
 * @author chaijunkun
 * @since 2016年9月5日
 */
public class WeChatAPIConfig {
	
	/** appId */
	private String appId;
	
	/** 密钥 */
	private String secret;
	
	/** 回调时使用的token */
	private String callbackToken;
	
	/** 消息加密密钥 */
	private String encodingAESKey;
	
	/**
	 * 获取appId
	 * @return appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * 设置appId
	 * @param appId appId
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * 获取密钥
	 * @return 密钥
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * 设置密钥
	 * @param secret 密钥
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * 获取回调时使用的token
	 * @return 回调时使用的token
	 */
	public String getCallbackToken() {
		return callbackToken;
	}

	/**
	 * 设置回调时使用的token
	 * @param callbackToken 回调时使用的token
	 */
	public void setCallbackToken(String callbackToken) {
		this.callbackToken = callbackToken;
	}

	/**
	 * 获取消息加密密钥
	 * @return 消息加密密钥
	 */
	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	/**
	 * 设置消息加密密钥
	 * @param encodingAESKey 消息加密密钥
	 */
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

}
