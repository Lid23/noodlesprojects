package com.noodles.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.codec.Charsets;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import com.noodles.date.utils.DateUtils;
import com.noodles.random.utils.RandomUtils;

/**
 * @filename FileTest
 * @description 测试文件读写工具类
 * @author 巫威
 * @date 2020/12/24 14:54
 */
public class FileTest {



	@Test
	public void test(){
		System.out.println("test");
	}

	/**
	 * 拷贝文件测试
	 * @param
	 * @author 巫威
	 * @date 2020/12/24 17:57
	 */
	@Test
	public void copyFileTest() {
		String srcPath = "F:/usr/local/nlp/1/数据库系统原理-5.png";
		String targetPath = "F:/usr/local/nlp/2/数据库系统原理-5.png";

		FileNioUtil.copyFile(srcPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * 测试读取大文件
	 * @param
	 * @return void
	 * @author 巫威
	 * @date 2020/12/24 14:57
	 */
	@Test
	public void readBigFileTest() {
		String bigpath = "E:/桌面工作/16-短信平台/msg_create_20171225.sql";
		String smallpath = "d:/1.txt";

		try {
			//内存中读取，文件的所有行都被存放在内存中，文件足够大时，很快就会导致程序抛出OutOfMemoryError异常
			List<String> fileStr = FileUtils.readLines(new File(bigpath));

			List<String> fileStr1 = Files.readAllLines(Paths.get(smallpath), Charsets.UTF_8);

			for (String str : fileStr) {
				System.out.println(str.toLowerCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


