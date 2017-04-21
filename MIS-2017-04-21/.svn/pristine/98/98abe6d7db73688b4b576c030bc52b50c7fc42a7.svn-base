package com.framework.system.common.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 * @author WongYong
 */
public class Datetools {
	
	/** 反格式化时间串--不足位补0 */
	public static final int Fill_Zero = 0;
	
	/** 反格式化时间串--不足位补9 */
	public static final int Fill_Nine = 1;

	/**
	 * 获取当前时间
	 * @return 当前时间yyyyMMddhhmmss
	 */
	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	/**
	 * 获取当前日期
	 * @return 当前日期YYYYMMDD
	 */
	public static String getCurrentDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
	
	/**
	 * 格式化日期字符串
	 * @param dateString yyyyMMddhhmmss 或 yyyyMMdd
	 * @return yyyy-MM-dd hh:mm:ss 或 yyyy-MM-dd
	 */
	public static String formateDate(String dateString) {
		String result = "";
		
		if (dateString != null) {
			if (dateString.length() == 14 || dateString.length() == 8) {
				result = dateString.substring(0, 4) + "-" + dateString.substring(4, 6) + "-" + dateString.substring(6, 8);
				if (dateString.length() == 14) {
					result += " " + dateString.substring(8, 10) + ":" + dateString.substring(10, 12) + ":" + dateString.substring(12, 14);
				}
			} else {
				result = dateString;
			}
		}
		
		return result;
	}
	
	/**
	 * 计算现在距离指定的时间过去了多久
	 * @param dateString 时间格式yyyyMMddhhmmss
	 * @return
	 */
	public static String timePast(String dateString) {
		String timepast = dateString;
		if (dateString.matches("\\d{14}")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				Date thedate = sdf.parse(dateString);
				if (thedate != null) {
					long millSec = new Date().getTime() - thedate.getTime();
					if (millSec >= 0) {  //时间没有颠倒
						long seconds = millSec / 1000;
						if (seconds <= 10) {  //秒
							timepast = "刚刚";
						} else if (seconds > 60) {  //分钟级别
							int minutes = (int) seconds / 60;
							if (minutes < 60) {
								timepast = minutes + "分钟前";
							} else {
								int hours = minutes / 60;
								if (hours < 24) {  //小时级别
									timepast = hours + "小时前";
								} else {
									int day = hours / 24;
									if (day < 30) {  //天级别
										timepast = day + "天前";
									} else {
										timepast = "一个月以上";
									}
								}
							}
						} else {
							timepast = (int) (seconds / 10) + "0秒前";
						}
					}
				}
			} catch (ParseException e) {
			}
		}
		
		return timepast;
	}
	
	/**
	 * 将已经格式化的日期转成原本的日期形式YYYYMMDDHHmmSS
	 * @param formattedDate 已格式化的数据，支持 “年年年年/月月/日日”，“年年年年/月月/日日/时时/分分"，分隔符可为任意
	 * @param type 1-不足位数补9, 默认补0 参照Datetools类中的静态字段
	 * @return YYYYMMDDHHmmSS
	 */
	public static String reFormateDate(String formattedDate, int type) {
		String result = "";
		
		if (formattedDate != null) {
			if (formattedDate.matches("\\d{4}.\\d{2}.\\d{2}")) {
				result = formattedDate.substring(0, 4) + formattedDate.substring(5, 7) + formattedDate.substring(8, 10);
				if (type == Fill_Nine) {
					result += "999999";
				} else {
					result += "000000";
				}
			} else if (formattedDate.matches("\\d{4}.\\d{2}.\\d{2}.\\d{2}.\\d{2}")) {
				result = formattedDate.substring(0, 4) + formattedDate.substring(5, 7) + formattedDate.substring(8, 10) + formattedDate.substring(11, 13) + formattedDate.substring(14, 16);
				if (type == 1) {
					result += "99";
				} else {
					result += "00";
				}
			}
		}
		
		return result;
	}
}
