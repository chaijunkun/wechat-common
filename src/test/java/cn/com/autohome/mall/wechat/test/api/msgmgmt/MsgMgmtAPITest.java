package cn.com.autohome.mall.wechat.test.api.msgmgmt;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.autohome.mall.wechat.test.BaseTest;
import com.github.chaijunkun.wechat.common.api.WeChatAPIException;
import com.github.chaijunkun.wechat.common.api.access.TokenAPI;
import com.github.chaijunkun.wechat.common.api.access.TokenResult;
import com.github.chaijunkun.wechat.common.api.msgmgmt.MsgMgmtAPI;
import com.github.chaijunkun.wechat.common.api.msgmgmt.TemplateSendParam;
import com.github.chaijunkun.wechat.common.api.msgmgmt.TemplateSendResult;
import com.github.chaijunkun.wechat.common.api.msgmgmt.TemplateSendParam.TemplateData;
import com.github.chaijunkun.wechat.common.util.JSONUtil;

/**
 * 消息管理API测试
 * @author chaijunkun
 * @since 2016年9月8日
 */
public class MsgMgmtAPITest extends BaseTest {
	
	@Autowired
	private TokenAPI tokenAPI;
	
	@Autowired
	private MsgMgmtAPI msgMgmtAPI;
	
	private static final String templateId = "rSaJfWJQ8Lkc0ztRa9tuMoU34byGnkbOANChuIR-YDg";
	
	private static final String toUserOpenId = "oy1bywzY6EhKtrK2mVazB2ZzUT7o";
	
	@Test
	public void doTest() throws WeChatAPIException, IOException{
		TokenResult token = tokenAPI.token();
		TemplateSendParam param = new TemplateSendParam();
		param.setAccessToken(token.getAccessToken());
		HashMap<String, TemplateData> model = new HashMap<String, TemplateData>();
		model.put("first", new TemplateData("欢迎使用测试用例"));
		model.put("now", new TemplateData(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
		model.put("remark", new TemplateData("期待您的下次使用"));
		param.setData(model);
		param.setTemplateId(templateId);
		param.setToUser(toUserOpenId);
		param.setUrl("http://www.csdn.net");
		TemplateSendResult result = msgMgmtAPI.templateSend(param);
		logger.info("发送消息回执:{}", JSONUtil.toJSON(result));
	}

}
