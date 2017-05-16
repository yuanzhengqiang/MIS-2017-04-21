package weixin.tools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import sbtj.init.SystemInit;
import sbtj.thread.GetAccessTokenThread;

import com.framework.system.util.JsonUtil;

/**
 * 请求校验工具类
 * 
 */
public class SignUtil {
	private static Logger logger = Logger.getLogger(SignUtil.class);
	
	// 与接口配置信息中的Token要一致
	public static String token = "tjptoken";
	public static String yumingdizhi = "wxt.ibyside.com";
	public static String handlerurl = "http://wxt.ibyside.com";
	public static String APPID = "wxf132c41c6af14e16";//正式
	public static String SECRET = "bde07ad33f07edd1f3435a8ea199b19a";//正式
	public static String PARTNER_KEY = "0213dc10d71111c90ef816e630d9afe8";//商户号对应的密钥
	public static String PARTNER = "1468642902";//财付通商户号
	public static String payNotifyUrl = "http://wxt.ibyside.com/wechatYuE.do?mpayNotify&weixin=weixin";//支付回调页
	//public static String weChatPhotoUrl = "http://wxt.ibyside.com/wechatOlder.do?mainAdd&flag=longActingInsuranceAgent&wechatId=";//拍照所需url参数

	/**
	 * 验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		String[] arr = new String[] { token, timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		// 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}

	/**
	 * 获取ACCESS_TOKEN，调用大部分微信接口所需参数，单日请求上限2000次
	 * 
	 * @param
	 * @return access_token
	 */
	public static String getAccess_token() {

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + SECRET;

		String accessToken = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();

			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			// logger.debug("微信获取access_token    " + message);

			Map demoJson = JsonUtil.getMap4Json(message);
			accessToken = (String) demoJson.get("access_token");

			// System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("微信-获取ACCESS_TOKEN失败=" + e);
			return "failure";
		}
		return accessToken;
	}

	/**
	 * 获取ACCESS_TOKEN,如果无值则打开线程,并且一直到有值后才跳出方法
	 * 
	 * @param
	 * @return
	 * @return access_token
	 */
	public static void getAccess_tokenByThread() {
		if (SystemInit.access_token == null || "".equals(SystemInit.access_token)) {
			logger.debug("系统重启后首次开启定时获取微信access_token线程.....");
			GetAccessTokenThread getAccessTokenThread = new GetAccessTokenThread();
			getAccessTokenThread.start();
			while (true) {
				if (SystemInit.access_token != null && SystemInit.access_token != "") {
					break;
				} else {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 获取jsapi_ticket，调用微信接口JS-SDK注入权限验证所需参数,单日请求上限2000
	 * 
	 * @param access_token
	 * @return jsapi_ticket
	 */
	public static String getTicket(String access_token) {
		String ticket = null;
		String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";// 这个url链接和参数不能变
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			JSONObject demoJson = JSONObject.fromObject(message);
			System.out.println("JSON字符串：" + demoJson);
			ticket = demoJson.getString("ticket");
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("微信-获取jsapi_ticket失败=" + e);
			return "failure";
		}
		return ticket;
	}

	/**
	 * 获取当前登陆微信用户openid
	 * 
	 * @param code
	 * @return openid
	 */
	public static String getopenid(String code) {
		String openid = "";
		try {
			String message = SignUtil.getUrl("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + SignUtil.APPID + "&secret=" + SignUtil.SECRET
			        + "&code=" + code + "&grant_type=authorization_code");
			if (message != null) {
				Map demoJson = JsonUtil.getMap4Json(message);
				if (demoJson != null) {
					openid = (String) demoJson.get("openid");
				}
			}
		} catch (Exception e) {
			logger.debug("微信-获取当前登陆微信用户openid失败=" + e);
		}
		return openid;
	}

	// get请求通用方法
	public static String getUrl(String url) {

		String message = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			message = new String(jsonBytes, "UTF-8");

			// System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	// 将图片数据转为base64编码
	public static String getPhoto(String url) {
		String photo64 = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
			System.setProperty("sun.net.client.defaultReadTimeout", "30000");
			http.connect();
			InputStream is = http.getInputStream();// 通过输入流获得图片数据
			byte[] byteImg = readInputStream(is);// 得到图片的二进制数据
			photo64 = new String(Base64.encodeBase64(byteImg));// 转为base64
		} catch (Exception e) {
			e.printStackTrace();
		}
		return photo64;
	}

	public static String doHttpPost(String url, String reqmsg) {
		String result = null;
		try {
			logger.debug("POST地址：" + url);
			logger.debug("POST内容：" + reqmsg);
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(url);
			client.getParams().setContentCharset("UTF-8");
			method.setRequestHeader("ContentType", "application/json;charset=UTF-8");
			NameValuePair[] param = { new NameValuePair("reqmsg", reqmsg), new NameValuePair("weixin", "weixin") };
			method.addParameters(param);
			client.executeMethod(method);
			result = method.getResponseBodyAsString();
			logger.debug("POST消息返回：" + result);
		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}

	// 转为图片的二进制数据
	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}

	public static String doHttpPost_weixin(String url_weixin, String reqmsg) {
		logger.debug("POST地址：" + url_weixin);
		logger.debug("POST内容：" + reqmsg);
		byte[] xmlData = reqmsg.getBytes();
		InputStream instr = null;
		java.io.ByteArrayOutputStream out = null;
		try {
			URL url = new URL(url_weixin);
			URLConnection urlCon = url.openConnection();
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
			urlCon.setUseCaches(false);
			urlCon.setRequestProperty("Content-Type", "text/xml");
			urlCon.setRequestProperty("Content-length", String.valueOf(xmlData.length));
			System.out.println(String.valueOf(xmlData.length));
			DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());
			printout.write(xmlData);
			printout.flush();
			printout.close();
			instr = urlCon.getInputStream();
			byte[] bis = IOUtils.toByteArray(instr);
			String ResponseString = new String(bis, "UTF-8");
			if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
				System.out.println("返回空");
			}
			System.out.println("weixin返回数据为:" + ResponseString);
			return ResponseString;

		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	/**
	 * 发送HttpPost请求获取微信公众号素材
	 * 
	 * @param strURL
	 *            服务地址
	 * @param params
	 *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
	 * @return 成功:返回json字符串<br/>
	 */
	public static String postForMaterial(String strURL, String params) {
		System.out.println(strURL);
		System.out.println(params);
		try {
			URL url = new URL(strURL);// 创建连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // 设置请求方式
			connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
			connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.append(params);
			out.flush();
			out.close();
			// 读取响应
			int length = (int) connection.getContentLength();// 获取长度
			InputStream is = connection.getInputStream();
			if (length != -1) {
				byte[] data = new byte[length];
				byte[] temp = new byte[512];
				int readLen = 0;
				int destPos = 0;
				while ((readLen = is.read(temp)) > 0) {
					System.arraycopy(temp, 0, data, destPos, readLen);
					destPos += readLen;
				}
				String result = new String(data, "UTF-8"); // utf-8编码
				System.out.println(result);
				return result;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "error"; // 自定义错误信息
	}

}
