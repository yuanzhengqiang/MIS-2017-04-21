package com.framework.system.common.tools;

import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

/**
 * JSON转码工具类
 * @author Yang
 */
public class JsonEncoding {

	/**
	 * 将JSON内容由utf8转码为iso-8859-1
	 * @param content2encode
	 * @return
	 */
	public static String encode(String content2encode) {
		if (content2encode == null) {
			content2encode = "";
		}
		String result = content2encode;
		try {
			result = new String(result.getBytes("utf-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {

		}
		return result;
	}
	
	/**
	 * 将处理结果对象转换成iso-8859-1编码的JSON
	 * @param object 要转换的对象
	 * @return
	 */
	public static String encode(Object object) {
		JSONObject jso;
		if (object != null) {
			jso = JSONObject.fromObject(object);
		} else {
			jso = new JSONObject();
		}
		return encode(jso.toString());
	}
	
}
