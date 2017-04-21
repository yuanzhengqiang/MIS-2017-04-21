package sbtj.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

import sbtj.init.SystemInit;

public class HttpUtils {
	private static Logger logger = Logger.getLogger(HttpUtils.class);
	private static SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static String doHttpPost(String url,String content){
		String result=null;
		try {
		    logger.debug("POST地址：" + url);
		    logger.debug("POST内容：" + content);
		    HttpClient client = new HttpClient(); 
			PostMethod method = new PostMethod(url); 			
			client.getParams().setContentCharset("UTF-8");
			method.setRequestHeader("ContentType","application/json;charset=UTF-8");
			method.setRequestBody(content);
			client.executeMethod(method);	
			result = method.getResponseBodyAsString();
		    logger.debug("POST消息返回：" + result);
		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}
	
	public static String doHttpGet(String url){
		String result=null;
		try {
		    logger.debug("GET地址：" + url);
		    HttpClient client = new HttpClient(); 
			GetMethod method = new GetMethod(url); 			
			client.getParams().setContentCharset("UTF-8");
			method.setRequestHeader("ContentType","application/json;charset=UTF-8");
			client.executeMethod(method);	
			result = method.getResponseBodyAsString();
		    logger.debug("GET消息返回：" + result);
		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}
	
	public static String doHttpPostByVersion1_3(String url,String message){
		String result=null;
		try {		
		    logger.debug("POST地址：" + url);
		    logger.debug("POST内容：" + message);
		    String appkey = SystemInit.appkey;
			//1.消息体			
			String content=DesUtil.DES(message, appkey, "UTF-8");
			//2.亲情通appid
			String appid =SystemInit.appid;		
			//3.请求时间
			String time =formater.format(new Date());
			//4.加密版本
			String version="1.0";
			//5.身份认证码
			String authcode=Md5Utils.MD5(content+","+time+","+appkey);	
			
			logger.debug("POST加密内容：" + content);
		    
		    HttpClient client = new HttpClient(); 
			PostMethod method = new PostMethod(url); 			
			client.getParams().setContentCharset("UTF-8");
			method.setRequestHeader("ContentType","application/json;charset=UTF-8");
			NameValuePair[] param = { new NameValuePair("content",content),
		                new NameValuePair("appid",appid),
		                new NameValuePair("time",time),
		                new NameValuePair("version",version),
		                new NameValuePair("authcode",authcode) } ;
			method.addParameters(param);
			client.executeMethod(method);	
			result = method.getResponseBodyAsString();
		    logger.debug("POST消息返回：" + result);
		    
		    //6.解密消息体
			if(result!=null&&!"".equals(result)){
				result = DesUtil.UNDES(result,appkey, "UTF-8");
				logger.debug("POST消息返回解密后：" +result);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}

}
