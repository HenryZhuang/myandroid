package com.zhb.myandroid.framework.utils;


import java.io.UnsupportedEncodingException;

public class StringUtils {

	private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

	/**
	 * String转ASCII码
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public final static String string2Ascii(String str)
			throws UnsupportedEncodingException {
		return ba2HexString(str.getBytes("ASCII"));
	}

	public final static String ba2HexString(byte[] ba) {
		return ba2HexString(ba, 0, ba.length);
	}

	public final static String ba2HexString(byte[] ba, int offset, int length) {
		char[] buf = new char[length << 1];
		for (int i = 0, j = 0, k; i < length;) {
			k = ba[offset + i++];
			buf[j++] = HEX_DIGITS[(k >>> 4) & 0x0F];
			buf[j++] = HEX_DIGITS[k & 0x0F];
		}
		return new String(buf);
	}

	/**
	 * ASCII转String
	 * 
	 * @param str
	 * @return
	 */
	public final static String ascii2String(String str) {
		return new String(hexString2Ba(str));
	}

	/**
	 * 16进制字符串转字节数组
	 * 
	 * @param s
	 *            16进制字符串
	 * @return 字节数组
	 */
	public final static byte[] hexString2Ba(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		int limit = s.length();
		byte[] result = new byte[((limit + 1) / 2)];
		int i = 0, j = 0;
		if ((limit % 2) == 1) {
			result[j++] = (byte) char2Byte(s.charAt(i++));
		}
		while (i < limit) {
			result[j] = (byte) (char2Byte(s.charAt(i++)) << 4);
			result[j++] |= (byte) char2Byte(s.charAt(i++));
		}
		return result;
	}

	private static byte char2Byte(char c) {
		if (c >= '0' && c <= '9') {
			return (byte) (c - '0');
		} else if (c >= 'A' && c <= 'F') {
			return (byte) (c - 'A' + 10);
		} else if (c >= 'a' && c <= 'f') {
			return (byte) (c - 'a' + 10);
		} else {
			throw new IllegalArgumentException("Invalid hexadecimal digit: " + c);
		}
	}
}
