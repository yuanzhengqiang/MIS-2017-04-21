package sbtj.enums;

public class OlderAddress {
	/**
	 * 居住地址
	 * */
	public static final int LiveAddr = 0;

	/**
	 * 户籍地址
	 * */
	public static final int HouseAddr = 1;
	
	/**
	 * 收信地址
	 */
	public static final int LetterAddr = 2;

	
	public static int getLiveAddr() {
		return LiveAddr;
	}

	public static int getHouseAddr() {
		return HouseAddr;
	}

	public static int getLetterAddr() {
		return LetterAddr;
	}
}
