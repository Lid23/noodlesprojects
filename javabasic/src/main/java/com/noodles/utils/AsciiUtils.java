package com.noodles.utils;

import java.io.UnsupportedEncodingException;


/**
 * 文件名：AsciiUtils.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年8月11日下午5:32:05
 */
public class AsciiUtils {

	/**
	 * 计算字符串ascii长度
	 * @param value
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年8月11日下午5:33:25
	 */
	public static String strAsciiLength(String value) {
		int length = 0;
		try {
			length = value.getBytes("gbk").length;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String str = length + "";
		for (int j = str.length(); j < 6; j++) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * Ascii转字符串
	 * @param value
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年8月11日下午5:33:45
	 */
	public static String asciiToString(String value) {
		StringBuffer sbu = new StringBuffer();
		String[] chars = value.split(",");
		for (int i = 0; i < chars.length; i++) {
			sbu.append((char) Integer.parseInt(chars[i]));
		}
		return sbu.toString();
	}

	/**
	 * 字节数组转十六进制字符串
	 * @param src
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年8月11日下午5:33:58
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 十六进制字符串转换为字符串 
	 * @param s
	 * @param format
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年8月11日下午5:34:07
	 */
	public static String hexStringToString(String s, String format) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, format);
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

}
