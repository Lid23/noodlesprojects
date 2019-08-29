package com.noodles.java8;

import java.io.File;

/**
 * @filename FileDemo
 * @description 文件例子
 * @author 巫威
 * @date 2019/8/29 11:15
 */
public class FileDemo {

	public static void main(String[] args) {
		/**过滤隐藏文件*/
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
	}
}
