package com.github.chaijunkun.wechat.common.callback.msg;

import com.github.chaijunkun.wechat.common.callback.xml.msg.BaseMsg;
import com.github.chaijunkun.wechat.common.callback.WeChatCallbackException;

/**
 * 基础消息处理服务
 * @author chaijunkun
 * @since 2016年9月7日
 */
public interface BaseMsgDispatchService<T extends BaseMsg> {
	
	public BaseMsg dispatchMsg(T msg) throws WeChatCallbackException;

}
