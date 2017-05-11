package weixin.servlet;

import org.apache.log4j.Logger;

import sbtj.init.SystemInit;
import weixin.tools.SignUtil;

public class pushMessage {
	private static Logger logger = Logger.getLogger(pushMessage.class);

	/**
	 * 体检时间通知
	 * 
	 * @param openId
	 *            微信openId
	 * @param personName
	 *            体检人姓名
	 * @param hospitalName
	 *            医院名称
	 * @param time
	 *            时间，精确到日
	 * @return
	 */
	public static String examinationTimeNotice(String openId,
			String personName, String hospitalName, String time) {
		String weixinmsgpush = SystemInit.weixinmsgpush;
		if (!"formal".equals(weixinmsgpush)) {
			return null;
		}
		String access_token = SystemInit.access_token;
		if (!"".equals(access_token) && access_token != null) {
			String jsonStr = "{\"touser\":\"" + openId + "\",";
			jsonStr += "\"template_id\":\""
					+ "jcCp3qguXJEUAAHBnH0T_OstdMCjuxWN4GFac5hJXmI" + "\",";
			jsonStr += "\"topcolor\":\"" + "#000" + "\",";
			jsonStr += "\"data\":{";
			jsonStr += "\"first\":{";
			jsonStr += "\"value\":\"您好，您的体检时间已经预约成功，请准时参与！\\n" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword1\":{";
			jsonStr += "\"value\":\"" + personName + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword2\":{";
			jsonStr += "\"value\":\"" + hospitalName + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword3\":{";
			jsonStr += "\"value\":\"" + time + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"remark\":{";
			jsonStr += "\"value\":\"\\n\\n如有疑问，请拨打客服电话XXXXXX!\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "}";
			jsonStr += "}";
			jsonStr += "}";
			logger.debug("体检时间通知  消息推送=   " + jsonStr);
			return SignUtil.doHttpPost_weixin(
					"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
							+ access_token, jsonStr);
		} else {
			return null;
		}
	}

	/**
	 * 体检完成通知
	 * 
	 * @param openId
	 *            微信openId
	 * @param personName
	 *            体检人姓名
	 * @return
	 */
	public static String physicalExaminationNotice(String openId,
			String personName) {
		String weixinmsgpush = SystemInit.weixinmsgpush;
		if (!"formal".equals(weixinmsgpush)) {
			return null;
		}
		String access_token = SystemInit.access_token;
		if (!"".equals(access_token) && access_token != null) {
			String jsonStr = "{\"touser\":\"" + openId + "\",";
			jsonStr += "\"template_id\":\""
					+ "soygN8ZXe6Ld-Ul-h5pa5kFgOcrjWsPmhbakoQedXkk" + "\",";
			jsonStr += "\"topcolor\":\"" + "#000" + "\",";
			jsonStr += "\"data\":{";
			jsonStr += "\"first\":{";
			jsonStr += "\"value\":\"您好，您预约" + personName + "的体检订单\\n" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword1\":{";
			jsonStr += "\"value\":\"" + "已完成" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword2\":{";
			jsonStr += "\"value\":\"" + "XXXXXX" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"remark\":{";
			jsonStr += "\"value\":\"\\n\\n体检报告预计8-10天内可以查阅，如有疑问，请联系客服XXXXXX\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "}";
			jsonStr += "}";
			jsonStr += "}";
			logger.debug("体检完成通知  消息推送=   " + jsonStr);
			return SignUtil.doHttpPost_weixin(
					"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
							+ access_token, jsonStr);
		} else {
			return null;
		}
	}

	/**
	 * 体检报告完成通知
	 * 
	 * @param openId
	 *            微信openId
	 * @param personName
	 *            体检人姓名
	 * @param orderNumber
	 *            订单编号
	 * @param physicalExaminationDate
	 *            体检日期
	 * @param hospitalName
	 *            医院名称
	 * @return
	 */
	public static String physicalExaminationReport(String openId,
			String personName, String orderNumber,
			String physicalExaminationDate, String hospitalName) {
		String weixinmsgpush = SystemInit.weixinmsgpush;
		if (!"formal".equals(weixinmsgpush)) {
			return null;
		}
		String access_token = SystemInit.access_token;
		if (!"".equals(access_token) && access_token != null) {
			String jsonStr = "{\"touser\":\"" + openId + "\",";
			jsonStr += "\"template_id\":\""
					+ "uNj2BPc7LhWBUuOoBk5eYkIL1v-QAxDBVjXmRJ-3zmI" + "\",";
			jsonStr += "\"topcolor\":\"" + "#000" + "\",";
			jsonStr += "\"data\":{";
			jsonStr += "\"first\":{";
			jsonStr += "\"value\":\"您好，您的体检报告已经可以查阅。\\n" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword1\":{";
			jsonStr += "\"value\":\"" + personName + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword2\":{";
			jsonStr += "\"value\":\"" + orderNumber + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword3\":{";
			jsonStr += "\"value\":\"" + physicalExaminationDate + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword4\":{";
			jsonStr += "\"value\":\"" + hospitalName + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"remark\":{";
			jsonStr += "\"value\":\"\\n\\n点击此处付款并查阅体检报告。\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "}";
			jsonStr += "}";
			jsonStr += "}";
			logger.debug("体检报告完成通知  消息推送=   " + jsonStr);
			return SignUtil.doHttpPost_weixin(
					"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
							+ access_token, jsonStr);
		} else {
			return null;
		}
	}

	/**
	 * 体检报告寄出通知
	 * 
	 * @param openId
	 *            微信openId
	 * @param personName
	 *            体检人姓名
	 * @param express
	 *            快递公司
	 * @param courierNumber
	 *            快递单号
	 * @return
	 */
	public static String medicalReportSentNotice(String openId,
			String personName, String express, String courierNumber) {
		String weixinmsgpush = SystemInit.weixinmsgpush;
		if (!"formal".equals(weixinmsgpush)) {
			return null;
		}
		String access_token = SystemInit.access_token;
		if (!"".equals(access_token) && access_token != null) {
			String jsonStr = "{\"touser\":\"" + openId + "\",";
			jsonStr += "\"template_id\":\""
					+ "WmXxxUhKhjGLfIsh6akOKm3tlmrjs8LvL0Tn0FlCrnk" + "\",";
			jsonStr += "\"topcolor\":\"" + "#000" + "\",";
			jsonStr += "\"data\":{";
			jsonStr += "\"first\":{";
			jsonStr += "\"value\":\"您好，" + personName + "的体检报告以及相关资料已经寄出。\\n"
					+ "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword1\":{";
			jsonStr += "\"value\":\"" + express + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword2\":{";
			jsonStr += "\"value\":\"" + courierNumber + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"remark\":{";
			jsonStr += "\"value\":\"\\n\\n如有疑问，请拨打客服电话XXXXX。\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "}";
			jsonStr += "}";
			jsonStr += "}";
			logger.debug("体检报告寄出通知  消息推送=   " + jsonStr);
			return SignUtil.doHttpPost_weixin(
					"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
							+ access_token, jsonStr);
		} else {
			return null;
		}
	}
}
