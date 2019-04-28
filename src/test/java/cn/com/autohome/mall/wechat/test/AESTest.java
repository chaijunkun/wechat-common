package cn.com.autohome.mall.wechat.test;

import java.io.IOException;
import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.github.chaijunkun.wechat.common.util.AESDecryptionException;
import com.github.chaijunkun.wechat.common.util.AESEncryptionException;
import com.github.chaijunkun.wechat.common.util.AESUtil;
import com.github.chaijunkun.wechat.common.util.JSONUtil;

/**
 * AES加解密测试
 * @author chaijunkun
 * @since 2016年9月3日
 */
public class AESTest extends BaseTest {
	
	private String cipher = "GGdTHV1fEG1kYA1ER82E+H/1qZwbTpiATAGKT85gI9itBDazLmk2g+GOXa7qukUO/OE7CKdU81Dg1DKdwnRDmX55KQRFITyzpuKqwSzblHBD5arucfKYI3qoWlDmGgdH+WThn8yeIcxdQ4HzxpGOLlra6gZeLfaByZxiiU3GbcSITZ8Sn7CMsLKlFA3iM71hXhjUV05MZnnSoXkkt7Y2dnkBIe6GvmY4vXslCdHtffMMuqJioJ8Fb0K1RNbuJ16Eh26pi6w+eEy0SVHdVbHtVw==";
	
	private String aesKey = "C680C073C54FC672";
	
	public static class CookieUser{
		private String scope;
		private String openId;
		private String nickname;
		private String headImgUrl;
		private Long timestamp;
		private Integer unknownflag1;
		private String unknownflag2;
		private String unknownflag3;
		private Integer unknownflag4;
		public String getScope() {
			return scope;
		}
		public void setScope(String scope) {
			this.scope = scope;
		}
		public String getOpenId() {
			return openId;
		}
		public void setOpenId(String openId) {
			this.openId = openId;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getHeadImgUrl() {
			return headImgUrl;
		}
		public void setHeadImgUrl(String headImgUrl) {
			this.headImgUrl = headImgUrl;
		}
		public Long getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
		}
		public Integer getUnknownflag1() {
			return unknownflag1;
		}
		public void setUnknownflag1(Integer unknownflag1) {
			this.unknownflag1 = unknownflag1;
		}
		public String getUnknownflag2() {
			return unknownflag2;
		}
		public void setUnknownflag2(String unknownflag2) {
			this.unknownflag2 = unknownflag2;
		}
		public String getUnknownflag3() {
			return unknownflag3;
		}
		public void setUnknownflag3(String unknownflag3) {
			this.unknownflag3 = unknownflag3;
		}
		public Integer getUnknownflag4() {
			return unknownflag4;
		}
		public void setUnknownflag4(Integer unknownflag4) {
			this.unknownflag4 = unknownflag4;
		}
	}
	
	@Test
	public void doTest() throws AESDecryptionException, AESEncryptionException, IOException {
		byte[] cipherData = Base64.decodeBase64(cipher);
		byte[] plain = AESUtil.decrypt(cipherData, aesKey.getBytes());
		String plainText = new String(plain);
		logger.info("解密后的名文:{}", plainText);
		String[] fields = StringUtils.splitPreserveAllTokens(plainText, "|");
		if (ArrayUtils.isNotEmpty(fields)){
			CookieUser cookieUser = new CookieUser();
			int i = 0;
			for (String field : fields) {
				logger.info("数组下标:{}, 字段值:{}", i, field);
				i++;
			}
			cookieUser.setScope(fields[0]);
			cookieUser.setOpenId(fields[1]);
			cookieUser.setNickname(fields[2]);
			cookieUser.setHeadImgUrl(URLDecoder.decode(fields[3], "utf-8"));
			cookieUser.setTimestamp(Long.parseLong(fields[4]));
			cookieUser.setUnknownflag1(Integer.parseInt(fields[5]));
			cookieUser.setUnknownflag2(fields[6]);
			cookieUser.setUnknownflag3(fields[7]);
			cookieUser.setUnknownflag4(Integer.parseInt(fields[8]));
			logger.info("cookie用户对象:{}", JSONUtil.toJSON(cookieUser));
		}
		byte[] newCipherData = AESUtil.encrypt(plain, aesKey.getBytes());
		String cipherText = Base64.encodeBase64String(newCipherData);
		logger.info("加密后的密文:{}", cipherText);
	}
	

}
