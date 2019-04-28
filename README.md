# 说明
本项目指在封装微信对外提供的接口，使其能够方便地进行任何项目的对接，不再关心具体的接口细节，更专心地针对业务进行开发

# 关于本地调试

1. 登录微信公众号平台. 登录地址:https://mp.weixin.qq.com/ ,查看自己的公众号

	a. 若使用正式公众号调试，请在左侧菜单中找到"开发"->"基本配置"->"开发者ID"和"服务器配置"中找到对应的配置项
	
	b. 若使用公众号的测试账号调试，请在左侧菜单中找到"开发"->"开发者工具"->"公众平台测试帐号"->"进入"->扫描登录二维码->"测试号信息"和"接口配置信息"中找到对应的配置项
	
2. 修改测试用微信接入配置.配置文件路径为:src/test/resources/wx.properties,请按文件中的注释修改相应的配置参数

3. 修改redis服务器连接参数.由于微信针对获取token进行了日调用次数限制,应尽量减少"获取Token"API的实际访问次数,每次访问后对结果进行缓存,需要时从缓存中直接获取.为配合这一逻辑,需要引入redis.相应的配置文件路径为:src/test/resources/config.properties,请按实际情况进行配置

# 特别注意

如果接入的微信账号打开了安全模式，程序运行时抛出异常java.security.InvalidKeyException:illegal Key Size，请按下述方式解决：

1. 在官方网站下载JCE无限制权限策略文件
    
    a. 如果使用的是JDK7:下载地址:http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
    
    b. 如果使用的是JDK8:下载地址:http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
2. 下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt。

3. 如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件，如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件 

# wiki
description articles: https://blog.csdn.net/chaijunkun/column/info/13831