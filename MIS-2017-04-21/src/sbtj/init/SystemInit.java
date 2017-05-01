package sbtj.init;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import sbtj.util.FileUtil;

public class SystemInit implements ServletContextListener {
	private static Logger logger = Logger.getLogger(SystemInit.class);
	public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	public static String photourl = "";

	public static String gpskey = "";

	public static String weixinurl = "";

	public static String dataserverurl = "";

	public static String appkey = "";

	public static String appid = "";

	public static String version = "";

	public static String timeout = "";

	public static String readtime = "";

	public static String datatcpurl = "";

	public static String medport = "";

	public static String smskey = "";

	public static String weixinmsgpush = "";

	private static SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String access_token = null;
	public static String jsapi_ticket = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * 启动初始化
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		readConfig();
	}

	private void readConfig() {
		try {
			String path = SystemInit.class.getResource("SystemInit.class").toString();
			String separator = FileUtil.getFileSeparator();
			String projectName = FileUtil.getProjectName();
			if ("file".equals(path.substring(0, 4))) {
				if ("\\".equals(separator))
					path = path.substring(6);
				else {
					path = path.substring(5);
				}
			}
			String localPath = path.substring(0, path.indexOf("webapps")) + "webapps" + separator + projectName + separator + "WEB-INF" + separator + "conf"
			        + separator + "config.properties";
			localPath = URLDecoder.decode(localPath);
			localPath = localPath.replace("/", separator);
			localPath = localPath.replace("\\", separator);
			Properties localProperties = FileUtil.readProperties(localPath);
			photourl = (String) localProperties.get("photo.url");
			logger.info("photourl:" + photourl);

			gpskey = (String) localProperties.get("gps.key");
			logger.info("gpskey:" + gpskey);
			weixinurl = (String) localProperties.get("weixin.pushurl");
			logger.info("weixinurl:" + weixinurl);

			dataserverurl = (String) localProperties.get("dataserver.url");
//			appkey = (String) localProperties.get("dataserver.appkey");
//			version = (String) localProperties.get("dataserver.version");
			timeout = (String) localProperties.get("dataserver.timeout");
//			readtime = (String) localProperties.get("dataserver.readtime");
//			datatcpurl = (String) localProperties.get("dataserver.tcp.url");
//			medport = (String) localProperties.get("dataserver.med.port");
//			appid = (String) localProperties.get("dataserver.appid");
			smskey = (String) localProperties.get("sms.key");
//			weixinmsgpush = (String) localProperties.get("weixin.msg.push");
			logger.info("dataserver.url:" + dataserverurl);
//			logger.info("dataserver.appkey:" + appkey);
//			logger.info("dataserver.version:" + version);
//			logger.info("dataserver.readtime:" + readtime);
//			logger.info("dataserver.tcp.url:" + datatcpurl);
//			logger.info("dataserver.med.port:" + medport);
//			logger.info("dataserver.appid:" + appid);
		} catch (Exception e) {
			logger.error(e.toString());
		}
	}

}