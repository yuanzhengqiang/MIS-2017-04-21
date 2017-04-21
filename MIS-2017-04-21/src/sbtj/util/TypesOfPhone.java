package sbtj.util;

public class TypesOfPhone {
	/**
	 * 移动/联通 11 号码
	 * */
	public static final int MoblePhone11 = 11;

	/**
	 * 联通 13 位号码
	 * */
	public static final int ChinaUnicom13 = 13;

	/**
	 * 联通 19 位 iccid
	 */
	public static final int ChinaUnicomIccid19 = 19;

	public static int getMoblephone11() {
		return MoblePhone11;
	}

	public static int getChinaunicom13() {
		return ChinaUnicom13;
	}

	public static int getChinaunicomiccid19() {
		return ChinaUnicomIccid19;
	}
}
