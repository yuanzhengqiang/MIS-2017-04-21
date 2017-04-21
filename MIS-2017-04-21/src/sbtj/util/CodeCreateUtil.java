package sbtj.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeCreateUtil {
	private static SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
	//充值消费流水号:RESN+14位当前时间+5位随机数
	public static String creatrechargeNum(){
		String num = "RESN"+formater.format(new Date())+RandomUtil.generateNumString(5);
		return num;
	}
	//回访记录编号：HF+14位当前时间+5位随机数
	public static String creatreviewNum(){
		String num = "HF"+formater.format(new Date())+RandomUtil.generateNumString(5);
		return num;
	}
}
