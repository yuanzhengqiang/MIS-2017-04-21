package weixin.tools;

import java.util.Random;

/**
 * 随机字符串，不长于32位。推荐随机数生成算法
 * @author zyx
 *
 */
public class WXUtil {
	
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "GBK");
	}

	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
}
