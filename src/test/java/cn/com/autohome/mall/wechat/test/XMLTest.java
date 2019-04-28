package cn.com.autohome.mall.wechat.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.github.chaijunkun.wechat.common.callback.xml.msg.LocationMsg;
import com.github.chaijunkun.wechat.common.util.JSONUtil;
import com.github.chaijunkun.wechat.common.util.XMLUtil;

/**
 * xml序列化与反序列化测试
 * @author chaijunkun
 * @since 2016年8月29日
 */
public class XMLTest extends BaseTest {
	
	@Test
	public void doTest() throws IOException {
		LocationMsg msg = new LocationMsg();
		msg.setToUserName("jackson");
		msg.setFromUserName("hawaii");
		msg.setLocationX(new BigDecimal("23.134521"));
		msg.setLabel("jack<xml val='Json'>]]>");
		
		ByteArrayOutputStream xmlOut = null;
		ByteArrayInputStream xmlIn = null;
		try{
			xmlOut = new ByteArrayOutputStream();
			XMLUtil.toXML(msg, xmlOut);
			String xml = new String(xmlOut.toByteArray());
			logger.info("生成xml:{}", xml);
			xmlIn = new ByteArrayInputStream(xml.getBytes());
			LocationMsg msgFromXml = XMLUtil.fromXML(xmlIn, LocationMsg.class);
			logger.info("反序列化结果:{}", JSONUtil.toJSON(msgFromXml));
		}finally{
			IOUtils.closeQuietly(xmlIn);
			IOUtils.closeQuietly(xmlOut);
		}
	}

}
