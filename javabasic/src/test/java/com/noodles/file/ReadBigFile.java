package com.noodles.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * 如何在不重复读取与不耗尽内存的情况下处理大文件——这为大文件的处理提供了一个有用的解决办法
 * 文件名：ReadBigFile.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年11月27日下午3:01:08
 */
public class ReadBigFile {
	
	public static void main(String args[]){
		
		String filePath = "C:/Users/KJ00019/Desktop/日志/nls-web/nls-web.log";
		String outPath = "D:/20171124-1.sql";
		try {
			long start = System.currentTimeMillis();
			readBigFileByScanner(filePath);     // 30秒 	文件大小  3.39g
			//readBigFileByCommonsIo(filePath); // 28秒   	文件大小  3.39g
			//readBigFileByNewNio(filePath);       // 28秒   	文件大小  3.39g
			
			/*String srcPath = "D:/NioTest/1.txt";
			String targetPath = "D:/NioTest/1-2.txt";
			fileContentFilter(filePath, outPath);*/
			
			long end = System.currentTimeMillis();
			System.out.println("耗时：" + (end - start));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用java.util.Scanner类扫描文件的内容，一行一行连续地读取
	 * @param filePath
	 * 作者：KJ00019
	 * 日期：2017年11月27日下午3:03:14
	 * @throws IOException 
	 */
	public static void readBigFileByScanner(String filePath) throws IOException{
		FileInputStream inputStream = null;
		Scanner sc = null;
		try{
			inputStream = new FileInputStream(filePath);
			sc = new Scanner(inputStream, "UTF-8");
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				//if(line.contains("扣款回调接口请求信息:")){
				if(line.contains("申请结果回调参数：{")){
		        	String str = line.substring(line.indexOf("申请结果回调参数：") + "申请结果回调参数：".length());
		        	System.out.println(str);
		        	
		        }
			}
			
			if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
	}
	
	/**
	 * 使用Commons IO库实现，利用该库提供的自定义LineIterator
	 * @param filePath
	 * @throws IOException
	 * 作者：KJ00019
	 * 日期：2017年11月27日下午3:31:08
	 */
	public static void readBigFileByCommonsIo(String filePath) throws IOException{
		LineIterator it = null;
		try {
			it = FileUtils.lineIterator(new File(filePath), "UTF-8");
			int i = 0;
		    while (it.hasNext()) {
		        String line = it.nextLine();
		        
		        /*if(!line.contains("INSERT INTO `XXL_JOB_QRTZ_TRIGGER_LOG`")){
		        	System.out.println(line);
		        }*/
		    }
		} finally {
			if(it != null){
				LineIterator.closeQuietly(it);
			}
		}
	}
	
	/**
	 * warning：编码异常
	 * @param filePath
	 * @throws IOException
	 * 作者：KJ00019
	 * 日期：2017年11月27日下午4:21:24
	 */
	public static void readBigFileByNewNio(String filePath) throws IOException{
		Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8).lines().forEach(line -> {
			System.out.println(line);
		});
	}
	
	
	/**
	 * 对读取的文件内容进行过滤，生成新的文件
	 * @param srcPath
	 * @param targetPath
	 * @throws IOException
	 * 作者：KJ00019
	 * 日期：2017年11月27日下午4:22:22
	 */
	public static void fileContentFilter(String srcPath, String targetPath) throws IOException{
		FileInputStream inputStream = null;
		Scanner sc = null;
		BufferedWriter writer = null;
		String turnLineStr = "\n";
		try{
			inputStream = new FileInputStream(srcPath);
			sc = new Scanner(inputStream, "UTF-8");
			
			Path targetFile = Paths.get(targetPath);
			if(!Files.exists(targetFile)){
				Files.createFile(targetFile);
			}
			
			writer = Files.newBufferedWriter(targetFile, StandardCharsets.UTF_8
			        ,StandardOpenOption.APPEND);
			int i = 0;
			while(sc.hasNextLine()){
				System.out.println(i++);
				String line = sc.nextLine();
				if(!line.contains("INSERT INTO `XXL_JOB_QRTZ_TRIGGER_LOG`")){
					writer.write(line+turnLineStr);
		        }
			}
			
			if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		    if (writer != null) {
		    	writer.close();
		    }
		}
	}
	
}
