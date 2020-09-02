package com.noodles.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @文件名：IOUtil.java
 * @描述： IO流处理工具类
 * @作者：sz05383_MACOS
 * @日期：2016年7月21日上午8:47:24
 */
public class IoUtils {


	public static void main(String[] args) {
		//createTestFile();

		testInputStreamWithOutClose();

		//System.out.println(10000 % 10000);
	}


	public static void createTestFile() {
		try {
			for (int i = 0; i < 10000; i++) {
				FileOutputStream fos = new FileOutputStream(new File("d:/test/Test" + i));
				fos.write(i);
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void testInputStreamWithOutClose() {
		try {
			for (int i = 0; i < 100000; i++) {
				FileInputStream fis = new FileInputStream(
						new File("d:/test/Test" + i%10000));
				System.out.println(fis.toString() + " " + (i%10000));
				// fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		/**
		 * 获取输入流的字节数组
		 * @param inputStream
		 * @return
		 * @throws Exception
		 * @作者：sz05383_MACOS
		 * @日期：2016年7月21日上午8:51:49
		 */
	public static byte[] getBytes(InputStream inputStream) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024 * 4];
		int n = 0;
		while ((n = inputStream.read(buffer)) != -1) {
			out.write(buffer, 0, n);
		}
		return out.toByteArray();
	}

	public static byte[] getBytes1(InputStream inputStream) throws Exception {
		ByteArrayOutputStream out = null;
		try {
			out = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024 * 4];
			int n = 0;
			while ((n = inputStream.read(buffer)) != -1) {
				out.write(buffer, 0, n);
			}
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 获取本地文件的字节数组
	 * @param file 本地文件路径
	 * @return
	 * @throws Exception
	 * @作者：sz05383_MACOS
	 * @日期：2016年7月21日上午8:51:49
	 */
	public static byte[] getFileBytes(String file) throws Exception {
		InputStream inputStream = getFileInputStream(file);
		return getBytes(inputStream);
	}

	public static byte[] getFileBytes1(String file) throws Exception {
		InputStream inputStream = getFileInputStream(file);
		return getBytes1(inputStream);
	}

	/**
	 * 获取网络文件的字节数组
	 * @param url 网络文件地址
	 * @return
	 * @throws Exception
	 * @作者：sz05383_MACOS
	 * @日期：2016年7月21日上午8:51:49
	 */
	public static byte[] getURLBytes(String url) throws Exception {
		InputStream inputStream = getURLInputStream(url);
		return getBytes(inputStream);
	}

	/**
	 * 获取网络文件的输入流
	 * @param url 网络文件地址
	 * @return
	 * @throws Exception
	 * @作者：sz05383_MACOS
	 * @日期：2016年7月21日上午8:52:03
	 */
	public static InputStream getURLInputStream(String url) throws Exception {
		return new URL(url).openConnection().getInputStream();
	}

	/**
	 * 获取本地文件的输入流
	 * @param file 本地文件路径
	 * @return
	 * @throws Exception
	 * @作者：sz05383_MACOS
	 * @日期：2016年7月21日上午8:54:39
	 */
	public static InputStream getFileInputStream(String file) throws Exception {
		return new FileInputStream(file);
	}

	/**
	 * 获取本地文件的文本内容
	 * @param file 本地文件路径
	 * @return
	 * @throws Exception
	 * @作者：sz05383_MACOS
	 * @日期：2016年7月21日上午8:51:29
	 */
	public static String getFileText(String file) throws Exception {
		return new String(getBytes(getFileInputStream(file)));
	}

	/**
	 * 获取网络文件的文本内容
	 * @param url 网络文件地址
	 * @return
	 * @throws Exception
	 * @作者：sz05383_MACOS
	 * @日期：2016年7月21日上午8:51:29
	 */
	public static String getURLText(String url) throws Exception {
		return new String(getBytes(getURLInputStream(url)), "UTF-8");
	}

	/**
	 * 写数据到文件
	 * @param data
	 * @param file
	 * @throws Exception
	 * @作者：sz05383_MACOS
	 * @日期：2016年7月21日下午1:56:03
	 */
	public static void wirteDataToFile(byte[] data, String file) throws Exception {
		File f = new File(file);

		if (!f.exists()) {
			new File(f.getParent()).mkdirs();
			f.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(data);
		fos.flush();
		fos.close();
	}

}
