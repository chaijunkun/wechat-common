package com.github.chaijunkun.wechat.common.api.qrcode;

import com.github.chaijunkun.wechat.common.api.WeChatAPIRet;

/**
 * 二维码响应代码
 * @author chaijunkun
 * @since 2016年9月1日
 */
public class QrCodeResult extends WeChatAPIRet {
	private static final long serialVersionUID = 4386631314677341070L;

	private String ticket;

    private int expire_seconds;

    private String url;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
