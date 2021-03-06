package mis.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomNum {

	public static final String HEXALLCHAR = "0123456789ABCDEF";
	
	public static final String HEXALLCHAR_2 = "01234aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ56789";

	/**
	 * 返回一个定长的16进制随机字符串(只包含大小写字母、数字)
	 * 
	 * @param length
	 *            随机字符串长度
	 * @return 随机字符串
	 */
	public static String generateHexString(int length) {
		Random random_HEXALLCHAR = new Random();
		Random random_BASESTR = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String baseStr = sdf.format(date);
		int iSub_BASESTR = 0;
		int iSub_HEXALLCHAR = 0;
		String part_one = "";
		String part_two = "";
		for (int i = 0; i < length; i++) {
			iSub_BASESTR = random_BASESTR.nextInt(baseStr.length());
			iSub_HEXALLCHAR = random_HEXALLCHAR.nextInt(HEXALLCHAR.length());
			part_two = baseStr.substring(iSub_BASESTR, baseStr.length());
			part_one = baseStr.substring(0, iSub_BASESTR)
					+ HEXALLCHAR.charAt(iSub_HEXALLCHAR);
			baseStr = part_one + part_two;
		}
		System.out.println("baseStr.lenth = " + baseStr.length());
		System.out.println("part_one = " + part_one + " ;part_two = "
				+ part_two);
		System.out.println(baseStr);
		return baseStr;
	}

	public static String generate4HexString() {
		Random random_HEXALLCHAR = new Random();
		int iSub_HEXALLCHAR = 0;
		String code = "";
		for (int i = 0; i < 4; i++) {
			iSub_HEXALLCHAR = random_HEXALLCHAR.nextInt(HEXALLCHAR_2.length());
			code += HEXALLCHAR_2.charAt(iSub_HEXALLCHAR);
		}
		return code;
	}

	/**
	 * @param argv
	 */
	public static void main(String[] argv) {
		System.out.println(generateHexString(2));
//		for (int i = 0; i < 100; i++)
//			System.out.println(RandomNum.generate4HexString());
	}
}
