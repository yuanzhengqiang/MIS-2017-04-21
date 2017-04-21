package weixin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import sbtj.init.SystemInit;
import weixin.tools.SignUtil;

public class createMenu extends HttpServlet {
	private static Logger logger = Logger.getLogger(createMenu.class);

	/**
	 * 确认请求来自微信服务器
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createMenu();
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createMenu();
	}
	
	//创建目录,单独运行，网页直接调
	public int createMenu() throws IOException {
		String user_define_menu = "{\"button\":[";
		
		String corporateOfficialWebsite_url = "http://" + SignUtil.yumingdizhi + "/" + "wechatweimob.do?corporateOfficialWebsite&weixin=weixin";
		corporateOfficialWebsite_url = URLEncoder.encode(corporateOfficialWebsite_url);
		
		String oldMall_url = "http://" + SignUtil.yumingdizhi + "/" + "wechatweimob.do?oldMall&weixin=weixin";
		oldMall_url = URLEncoder.encode(oldMall_url);
		
		String historicalInformation_url = "http://" + SignUtil.yumingdizhi + "/" + "wechatweimob.do?historicalInformation&weixin=weixin";
		historicalInformation_url = URLEncoder.encode(historicalInformation_url);
		
		String longActingInsuranceAgent_url = "http://" + SignUtil.yumingdizhi + "/" + "wechatweimob.do?longActingInsuranceAgent&weixin=weixin";
		longActingInsuranceAgent_url = URLEncoder.encode(longActingInsuranceAgent_url);
		
		String myConcern_url = "http://" + SignUtil.yumingdizhi + "/" + "wechatOlder.do?main&weixin=weixin";
		myConcern_url = URLEncoder.encode(myConcern_url);
		
		String reservationService_url = "http://" + SignUtil.yumingdizhi + "/" + "wechatReservationService.do?main&weixin=weixin";
		reservationService_url = URLEncoder.encode(reservationService_url);
		
		String onlineService_url = "http://" + SignUtil.yumingdizhi + "/" + "wechatweimob.do?onlineService&weixin=weixin";
		onlineService_url = URLEncoder.encode(onlineService_url);
		
		
		//user_define_menu += "{\"type\":\"view\",\"name\":\"用户中心\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + userCenter_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
		
		user_define_menu += "{";
		user_define_menu += "\"name\":\"用户中心\",";
		user_define_menu += "\"sub_button\":[";
		user_define_menu += "{\"type\":\"view\",\"name\":\"企业官网\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + corporateOfficialWebsite_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
		user_define_menu += "{\"type\":\"view\",\"name\":\"老年商城\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + oldMall_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
		user_define_menu += "{\"type\":\"view\",\"name\":\"历史信息\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + historicalInformation_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"}";
		user_define_menu += "]";
		user_define_menu += "},";
		
		user_define_menu += "{";
		user_define_menu += "\"name\":\"在线服务\",";
		user_define_menu += "\"sub_button\":[";
		user_define_menu += "{\"type\":\"view\",\"name\":\"长护险申请\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + longActingInsuranceAgent_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
		user_define_menu += "{\"type\":\"view\",\"name\":\"关注老人\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + myConcern_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
		user_define_menu += "{\"type\":\"view\",\"name\":\"预约服务\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + reservationService_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
		user_define_menu += "{\"type\":\"view\",\"name\":\"在线帮助\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=" + onlineService_url + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"}";
		user_define_menu += "]";
		user_define_menu += "}";
		
		
		
		
		
		/*
		user_define_menu += "{";
		user_define_menu += "\"name\":\"我的账户\",";
		user_define_menu += "\"sub_button\":[";
		user_define_menu += "{\"type\":\"view\",\"name\":\"历史服务\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=http%3a%2f%2f" + SignUtil.yumingdizhi + "%2fHisService.aspx&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
		user_define_menu += "{\"type\":\"view\",\"name\":\"账户信息\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID + "&redirect_uri=http%3a%2f%2f" + SignUtil.yumingdizhi + "%2fUserInfo.aspx&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"}";
		user_define_menu += "]";
		user_define_menu += "}";*/
	
		user_define_menu += "]}";
		logger.debug("微信服务器       创建菜单" + user_define_menu);
		// 此处改为自己想要的结构体，替换即可
		//true则代表正式环境，可以开启获取token线程，获取微信服务器数据
		if("formal".equals(SystemInit.weixinmsgpush)){
			SignUtil.getAccess_tokenByThread();
		}
		String access_token = SystemInit.access_token;

		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();

			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(user_define_menu.getBytes("UTF-8"));// 传入参数
			os.flush();
			os.close();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			System.out.println(message);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
