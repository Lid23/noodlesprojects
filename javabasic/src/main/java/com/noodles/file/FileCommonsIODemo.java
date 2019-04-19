package com.noodles.file;

import org.apache.commons.codec.Charsets;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 文件名：FileCommonsIODemo.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年11月27日上午10:05:32
 */
public class FileCommonsIODemo {
	public static void main(String args[]){
		
		String bigpath = "E:/桌面工作/16-短信平台/msg_create_20171225.sql";
		String smallpath = "d:/1.txt";
		
		try {
			//内存中读取，文件的所有行都被存放在内存中，文件足够大时，很快就会导致程序抛出OutOfMemoryError异常
			List<String> fileStr = FileUtils.readLines(new File(bigpath));
			
			List<String> fileStr1 = Files.readAllLines(Paths.get(smallpath), Charsets.UTF_8);
			
			for(String str : fileStr){
				System.out.println(str.toLowerCase());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
