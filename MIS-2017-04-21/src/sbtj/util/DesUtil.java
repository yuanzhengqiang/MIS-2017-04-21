package sbtj.util;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 加密工具
 * 
 */

public class DesUtil {
	private static Logger logger = Logger.getLogger(DesUtil.class);

	// 加密的密钥
	public static final String KEY = "5b5972315cf0662f670068d27684FF08B5271DDE2693590F";

	public static String getKey() {
		return KEY;
	}

	// 解密1
	public static String UNDES(String args, String inputKey,String CHARSET) {
		try {
			return new String(DES3Decode(inputKey, base64Decode(args)),CHARSET);
		} catch (Exception e) {
			logger.debug("解密时出现异常！");
			return "";
		}
	}

	// 加密1
	public static String DES(String args, String inputKey) {
		try {
			byte[] bb = DES3Encode(inputKey, args.getBytes());
			return base64Encode(bb);
		} catch (Exception e) {
			logger.debug("加密时出现异常！");
			return "";
		}
	}

	// 加密3
	public static String DES(String args, String inputKey,String charSet) {
		try {
			byte[] bb = DES3Encode(inputKey, args.getBytes(charSet));
			return base64Encode(bb);
		} catch (Exception e) {
			logger.debug("加密时出现异常！");
			return "";
		}
	}

	// 解密2
	public static String UNDES(String args) {
		try {
			return new String(DES3Decode(KEY, base64Decode(args)));
		} catch (Exception e) {
			logger.debug("解密时出现异常！");
			return "";
		}
	}

	// 加密2
	public static String DES(String args) {
		try {
			return encryptRoamUserToken1(args);
		} catch (Exception e) {
			logger.debug("加密时出现异常！");
			return "";
		}
	}

	private static byte[] DES3Decode(String key, byte[] source) {
		try {
			SecretKey deskey = new SecretKeySpec(Hex2Bin(key), "DESede");
			Cipher c3des = Cipher.getInstance("DESede");
			c3des.init(Cipher.DECRYPT_MODE, deskey);
			return c3des.doFinal(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] base64Decode(String str) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(str);
	}

	private static String encryptRoamUserToken1(String str) throws Exception {

		byte[] bb = DES3Encode(KEY, str.getBytes());
		return base64Encode(bb);
	}

	protected static byte[] Hex2Bin(String hex) throws IllegalArgumentException {
		if (hex.length() % 2 != 0) {
			throw new IllegalArgumentException();
		}
		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length() / 2];
		for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap, 16) & 0xFF;
			b[j] = new Integer(byteint).byteValue();
		}
		return b;
	}

	private static byte[] DES3Encode(String key, byte[] source) {
		try {
			Security.addProvider(new com.sun.crypto.provider.SunJCE());
			SecretKey deskey = new SecretKeySpec(Hex2Bin(key), "DESede");
			Cipher c3des = Cipher.getInstance("DESede");
			c3des.init(Cipher.ENCRYPT_MODE, deskey);
			return c3des.doFinal(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String base64Encode(byte[] bt) throws Exception {
		return Base64.encode(bt);
	}

}
