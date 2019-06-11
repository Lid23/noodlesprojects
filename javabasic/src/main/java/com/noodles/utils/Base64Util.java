package com.noodles.utils;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * 文件名：Base64Utils.java
 * 描述：base64编码解密工具包
 * 作者：王承
 * 日期：2016年4月6日下午3:21:11
 */
public class Base64Util {

	/**
	 * 将 s 进行 BASE64 编码
	 * @param s
	 * @return
	 * 作者：王承
	 * 日期：2016年4月6日下午3:21:37
	 */
	public static String encode(byte[] s) {
		if (s == null){
			return null;
		}

		return Base64.encodeBase64String(s);
	}

	/**
	 * 将 s 进行 BASE64 编码
	 * @param s
	 * @return
	 * 作者：王承
	 * 日期：2016年4月6日下午3:22:01
	 */
	public static String encode(String s) {

		if (s == null){
			return null;
		}
		return encode(s.getBytes());
	}

	/**
	 * 将 BASE64 编码的字符串 s 进行解码
	 * @param s
	 * @return
	 * 作者：王承
	 * 日期：2016年4月6日下午3:22:08
	 */
	public static byte[] decode(String s) {
		if (s == null){
			return null;
		}
		try {
			return Base64.decodeBase64(s);
		} catch (Exception e) {
			return null;
		}
	}

}