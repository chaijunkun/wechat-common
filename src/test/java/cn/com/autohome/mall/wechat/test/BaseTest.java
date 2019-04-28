package cn.com.autohome.mall.wechat.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 基础测试类
 * @author chaijunkun
 * @since 2016年9月6日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public abstract class BaseTest {
	
	protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	
}
