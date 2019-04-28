package com.github.chaijunkun.wechat.common.api.qrcode;

import com.github.chaijunkun.wechat.common.api.WeChatAPI;
import com.github.chaijunkun.wechat.common.api.WeChatAPIException;

/**
 * 获取二维码接口
 * @author chaijunkun
 * @date 2016年9月10日
 */
public class QrCodeAPI extends WeChatAPI<QrCodeURLFactory> {

	@Override
	public QrCodeURLFactory getUrlFactory() {
		return urlFactory;
	}

	@Override
	public void setUrlFactory(QrCodeURLFactory urlFactory) {
		this.urlFactory = urlFactory;
	}

	public QrCodeResult getQrCode(QrCodeParam param) throws WeChatAPIException {
		return super.doPostAPIWithAccessToken(urlFactory.getQrCodeUrl(), param, QrCodeResult.class);
	}

}
