package sbtj.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.log4j.Logger;

import sbtj.init.SystemInit;

import com.framework.system.util.JsonUtil;

public class SendMessageUtil {
	private static Logger logger = Logger.getLogger(SendMessageUtil.class);

	public static int sendMsg(String phone, String content) {
		int result = 1;
		try {
			logger.debug(content);
			String urlstr = getSendMsgUrl(phone, content);

			logger.debug("短信发送url：" + urlstr);
			URL url = new URL(urlstr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.connect();

			DataOutputStream out = new DataOutputStream(connection.getOutputStream());

			out.flush();
			out.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer sb = new StringBuffer("");
			String lines;
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}

			String rep = sb.toString();
			logger.debug("短信发送远程返回：" + rep);
			// {"reason":"操作成功","result":{"sid":"1511181631107305","fee":1,"count":1},"error_code":0}

			if (urlstr.substring(0, "http://v.juhe.cn".length()).equals("http://v.juhe.cn")) { // 移动
				Map reqParams = JsonUtil.getMap4Json(rep);
				Integer error_code = (Integer) reqParams.get("error_code");
				if (error_code != null && error_code.intValue() == 0) {
					result = 0;
				}
			} else if (urlstr.substring(0, "http://m2m10010.net.cn".length()).equals("http://m2m10010.net.cn")) { // 联通
				if (rep.equals("SMS sent!")) {
					result = 0;
				}
			}

			reader.close();

			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 判断去掉 phone 中的 86 剩余位数 (声明为 final，禁止修改)
	 * 
	 * @param phone
	 * @return
	 */
	private static int lenOfPhone(final String phone) {
		int len = 0;
		String phone_temp = phone;
		if (phone_temp != null && phone_temp.length() > 0) {
			try {
				// 是否以 86 开头，是则去除
				if (isStartWith86(phone)) {
					phone_temp = phone_temp.substring(2);
				} else {
					phone_temp = phone;
				}
				if (phone_temp != null && phone_temp.length() > 0) {
					switch (phone_temp.length()) {
					case TypesOfPhone.MoblePhone11:
						len = TypesOfPhone.MoblePhone11;
						break;
					case TypesOfPhone.ChinaUnicom13:
						len = TypesOfPhone.ChinaUnicom13;
						break;
					case TypesOfPhone.ChinaUnicomIccid19:
						len = TypesOfPhone.ChinaUnicomIccid19;
						break;

					default:
						len = 0;
						break;
					}
				}
			} catch (Exception e) {
				logger.error(e);
			}
		}
		logger.debug("phonelen = " + len + "; " + "phone = " + phone);
		return len;
	}

	/**
	 * 获得将会被用来发送短信的url
	 * 
	 * @param phone
	 *            短信发送到达的目标(当有 86 时，则去除86)
	 * @param code
	 *            短信内容(声明为 final，禁止对内容进行修改)
	 * @return
	 */
	private static String getSendMsgUrl(String phone, String code) {
		String sendUrl = "";
		logger.debug("phonelen = " + phone.length() + "; " + "phone = " + phone);
		if (phone != null && phone.length() > 0) {
			try {
				if (isStartWith86(phone)) {
					phone = phone.substring(2);
				}
				if (phone != null && phone.length() > 0) {
					switch (lenOfPhone(phone)) {
					case TypesOfPhone.MoblePhone11:
						// http://v.juhe.cn/sms/send?mobile=手机号码&tpl_id=短信模板ID&tpl_value=%23code%23%3D654654&key=
						String code_temp = "#code#=" + code;
						code_temp = URLEncoder.encode(code_temp);
						sendUrl = "http://v.juhe.cn/sms/send?mobile=" + phone + "&tpl_id=6347&tpl_value=" + code_temp + "&key=" + SystemInit.smskey;
						break;
					case TypesOfPhone.ChinaUnicom13:
						if (code.startsWith("%3A")) {
							code = "设备配置:" + code.substring("%3A".length());
						}
						code_temp = URLEncoder.encode(code);
						sendUrl = "http://m2m10010.net.cn/icci/sendSMS.php?iccid=" + phone + "&smstext=" + code_temp;
						break;
					case TypesOfPhone.ChinaUnicomIccid19:
						if (code.startsWith("%3A")) {
							code = "设备配置:" + code.substring("%3A".length());
						}
						code_temp = URLEncoder.encode(code);
						sendUrl = "http://m2m10010.net.cn/icci/sendSMS.php?iccid=" + phone + "&smstext=" + code_temp;
						break;

					default:
						sendUrl = "";
						break;
					}
				}
			} catch (Exception e) {
				logger.error(e);
			}
		}
		return sendUrl;
	}

	/**
	 * 判断目标号码是否是以 86 开头
	 * 
	 * @param phone
	 *            短信发送到达的电话号码(声明为 final，禁止对内容进行修改)
	 * @return
	 */
	private static boolean isStartWith86(final String phone) {
		boolean bStartWith86 = false;
		String phone_temp = phone;
		String startWith86 = phone_temp.substring(0, 2);
		if (startWith86.equals("86")) {
			bStartWith86 = true;
		}
		return bStartWith86;
	}

	public static void main(String[] argv) {
		String str = "http://v.juhe.cn/sms/send?mobile=";
		String strsub = str.substring(0, "http://v.juhe.cn".length());
		System.out.println("strsub = " + " " + strsub);
		if (str.substring(0, "http://v.juhe.cn".length()).equals("http://v.juhe.cn")) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
