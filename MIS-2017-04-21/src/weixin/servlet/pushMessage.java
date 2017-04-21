package weixin.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import sbtj.init.SystemInit;
import weixin.tools.SignUtil;

public class pushMessage {
	private static Logger logger = Logger.getLogger(pushMessage.class);

	/**
	 * 设备报警
	 * @param openid微信openId
	 * @param nickname微信昵称
	 * @param olderId老人ID
	 * @param olderName老人姓名
	 * @param devNumber设备编号
	 * @param devType设备类型
	 * @param alarmContent报警内容
	 * @param alarmTime报警时间
	 * @param alarmAddress报警地址
	 * @return
	 */
	public static String sendDevAlarm(String openid, String nickname,
			Integer olderId, String olderName, String devNumber,
			Integer devType, String alarmContent, String alarmTime,
			String alarmAddress) {
		String weixinmsgpush = SystemInit.weixinmsgpush;
		if(!"formal".equals(weixinmsgpush)){
			return null;
		}
		String access_token = SystemInit.access_token;
		if (!"".equals(access_token) && access_token != null) {
			String jsonStr = "{\"touser\":\"" + openid + "\",";
			jsonStr += "\"template_id\":\""
					+ "cTeSt-81c3VRM4VShNglY9QpMjER_FyV4Ps-QK2hWdI" + "\",";
			if (!"".equals(olderId) && olderId != null) {
				jsonStr += "\"url\":\"" + "http://" + SignUtil.yumingdizhi
						+ "/wechatOlder.do?mainXQ&weixin=weixin&olderId="
						+ olderId + "\",";
			}
			jsonStr += "\"topcolor\":\"" + "#000" + "\",";
			jsonStr += "\"data\":{";
			jsonStr += "\"first\":{";
			jsonStr += "\"value\":\"亲爱的" + nickname + ":您绑定的老人"
					+ getDevName(devType) + "触发了报警！\\n" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword1\":{";
			jsonStr += "\"value\":\"" + olderName + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword2\":{";
			jsonStr += "\"value\":\"" + alarmAddress + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword3\":{";
			jsonStr += "\"value\":\"" + alarmContent + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword4\":{";
			jsonStr += "\"value\":\"" + devNumber + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"remark\":{";
			jsonStr += "\"value\":\"\\n\\n请立即联系佩戴设备的亲属！\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "}";
			jsonStr += "}";
			jsonStr += "}";
			logger.debug("微信报警消息推送   " + jsonStr);
			return SignUtil.doHttpPost_weixin(
					"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
							+ access_token, jsonStr);
		} else {
			return null;
		}
	}

	/**
	 * 用药提醒
	 * @param openid微信openId
	 * @param nickname微信昵称
	 * @param olderId老人ID
	 * @param olderName老人姓名
	 * @param remindContent提醒内容
	 * @return
	 */
	public static String sendMedicationReminders(String openid,
			String nickname, Integer olderId, String olderName,
			String remindContent) {
		String weixinmsgpush = SystemInit.weixinmsgpush;
		if(!"formal".equals(weixinmsgpush)){
			return null;
		}
		String access_token = SystemInit.access_token;
		if (!"".equals(access_token) && access_token != null) {
			String jsonStr = "{\"touser\":\"" + openid + "\",";
			jsonStr += "\"template_id\":\""
					+ "-4MZYWjY6qkqGgcG73h6I7RMnxUWYn0YP6gjw0I-EMQ" + "\",";
			if (!"".equals(olderId) && olderId != null) {
				jsonStr += "\"url\":\"" + "http://" + SignUtil.yumingdizhi
						+ "/wechatOlder.do?mainXQ&weixin=weixin&olderId="
						+ olderId + "\",";
			}
			jsonStr += "\"topcolor\":\"" + "#000" + "\",";
			jsonStr += "\"data\":{";
			jsonStr += "\"first\":{";
			jsonStr += "\"value\":\"" + olderName + "您好，又到了该吃药的时间了\\n" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword1\":{";
			jsonStr += "\"value\":\"" + olderName + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword2\":{";
			jsonStr += "\"value\":\"" + remindContent + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"remark\":{";
			jsonStr += "\"value\":\"\\n\\n请务必按医嘱用药\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "}";
			jsonStr += "}";
			jsonStr += "}";
			logger.debug("微信用药提醒推送==" + jsonStr);
			return SignUtil.doHttpPost_weixin(
					"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
							+ access_token, jsonStr);
		} else {
			return null;
		}
	}

	// 健康咨询
	public static String sendHealthConsultation(String openid, String nickname,
			Integer olderId, String olderName, Integer speakType,
			String speakName, String speakContent) {
		/*
		 * String weixinmsgpush = SystemInit.weixinmsgpush;
		 * if(weixinmsgpush != "formal"){
		 *	return null;
		 * }
		 * nickname = URLDecoder.decode(nickname); olderName =
		 * URLDecoder.decode(olderName); remindContent =
		 * URLDecoder.decode(remindContent); String access_token =
		 * SystemInit.access_token; if (!"".equals(access_token) &&
		 * access_token != null) { String jsonStr = "{\"touser\":\"" + openid +
		 * "\","; jsonStr += "\"template_id\":\"" + "" + "\","; if
		 * (!"".equals(olderId) && olderId != null) { jsonStr += "\"url\":\"" +
		 * "http://" + SignUtil.yumingdizhi +
		 * "/wechatOlder.do?mainXQ&weixin=weixin&olderId=" + olderId + "\","; }
		 * jsonStr += "\"topcolor\":\"" + "#000" + "\","; jsonStr +=
		 * "\"data\":{"; jsonStr += "\"first\":{"; jsonStr += "\"value\":\"亲爱的"
		 * + nickname + ":您关注的老人" + olderName + "发生报警\\n" + "\","; jsonStr +=
		 * "\"color\":\"" + "#000" + "\""; jsonStr += "},"; jsonStr +=
		 * "\"keyword1\":{"; jsonStr += "\"value\":\"" + alarmContent + "\",";
		 * jsonStr += "\"color\":\"" + "#000" + "\""; jsonStr += "},"; jsonStr
		 * += "\"keyword2\":{"; jsonStr += "\"value\":\"紧急处理\","; jsonStr +=
		 * "\"color\":\"" + "#000" + "\""; jsonStr += "},"; jsonStr +=
		 * "\"remark\":{"; jsonStr += "\"value\":\"\\n\\n如有疑问请拨打热线电话\",";
		 * jsonStr += "\"color\":\"" + "#000" + "\""; jsonStr += "}"; jsonStr +=
		 * "}"; jsonStr += "}";
		 * 
		 * return SignUtil.doHttpPost_weixin(
		 * "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
		 * + access_token, jsonStr); } else { return null; }
		 */
		// 待添加
		return null;
	}

	/**
	 * 工单状态
	 * @param openid微信openId
	 * @param nickname微信昵称
	 * @param olderId老人ID
	 * @param olderName老人姓名
	 * @param serviceTaskId工单ID
	 * @param serviceTaskNumber服务工单编号
	 * @param serviceProject服务项目
	 * @param serviceTaskState工单状态
	 * @return
	 */
	public static String sendSingleState(String openid, String nickname,
			Integer olderId, String olderName, Integer serviceTaskId,
			String serviceTaskNumber, String serviceProject,
			Integer serviceTaskState) {
		String weixinmsgpush = SystemInit.weixinmsgpush;
		if(!"formal".equals(weixinmsgpush)){
			return null;
		}
		String access_token = SystemInit.access_token;
		if (!"".equals(access_token) && access_token != null) {
			String jsonStr = "{\"touser\":\"" + openid + "\",";
			jsonStr += "\"template_id\":\""
					+ "_Gw-998qvZh9HRNWof-HPw9UN58xQxTUsCGnhMxtXJc" + "\",";
			if (!"".equals(olderId) && olderId != null) {
				jsonStr += "\"url\":\"" + "http://" + SignUtil.yumingdizhi
						+ "/wechatOlder.do?mainXQ&weixin=weixin&olderId="
						+ olderId + "\",";
			}
			jsonStr += "\"topcolor\":\"" + "#000" + "\",";
			jsonStr += "\"data\":{";
			jsonStr += "\"first\":{";
			jsonStr += "\"value\":\"您好，您的订单状态发生变化，请持续关注！\\n" + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword1\":{";
			jsonStr += "\"value\":\"" + serviceTaskNumber + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword2\":{";
			jsonStr += "\"value\":\"" + serviceProject + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			jsonStr += "\"keyword3\":{";
			jsonStr += "\"value\":\"" + getServiceName(serviceTaskState)+ "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			
			//下面多出的keyword4只在丽家模板使用，福寿康使用去除
			jsonStr += "\"keyword4\":{";
			jsonStr += "\"value\":\"" + NowString() + "\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "},";
			
			
			jsonStr += "\"remark\":{";
			jsonStr += "\"value\":\"\\n\\n如有疑问请拨打热线电话\",";
			jsonStr += "\"color\":\"" + "#000" + "\"";
			jsonStr += "}";
			jsonStr += "}";
			jsonStr += "}";

			return SignUtil.doHttpPost_weixin(
					"https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
							+ access_token, jsonStr);
		} else {
			return null;
		}
	}

	/**
	 * 获取设备类型
	 * 
	 * @return 名称
	 */
	public static String getDevName(Integer id) {
		String name = "未知";
		if (id == null || id == 0) {
			return name;
		}
		switch (id) {
		case 1:
			name = "老人定位器";
			break;
		case 2:
			name = "安护宝";
			break;
		default:
			name = "未知";
			break;
		}
		return name;
	}

	/**
	 * 获取设备类型
	 * 
	 * @return 名称
	 */
	public static String getServiceName(Integer serviceState) {
		String name = "未知";
		if (serviceState == null || serviceState == 0) {
			return name;
		}
		switch (serviceState) {
		case 1:
			name = "取消";
			break;

		case 2:
			name = "待排班";
			break;

		case 3:
			name = "待审核";
			break;

		case 4:
			name = "审核通过";
			break;

		case 5:
			name = "服务开始";
			break;

		case 6:
			name = "服务结束";
			break;

		case 7:
			name = "回访结束";
			break;

		case 8:
			name = "已下单";
			break;

		default:
			name = "未知";
			break;
		}
		return name;
	}
	
	//获取当前时间
	public static String NowString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}

}
