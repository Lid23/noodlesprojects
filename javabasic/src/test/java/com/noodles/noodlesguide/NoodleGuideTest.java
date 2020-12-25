package com.noodles.noodlesguide;

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
import com.noodles.file.FileNioUtil;
import com.noodles.file.FileUtil;
import com.noodles.random.utils.RandomUtils;

/**
 * @filename FileTest
 * @description 测试文件读写工具类
 * @author 巫威
 * @date 2020/12/24 14:54
 */
public class NoodleGuideTest {



	@Test
	public void test(){
		System.out.println("test");
	}

	/**
	 * 更新文件里的图片名字，拷贝图片到指定目录并重新命名
	 * @param
	 * @return void
	 * @author 巫威
	 * @date 2020/12/24 17:55
	 */
	@Test
	public void replaceTxtByStrTest() {
		String path = "E:/NoodlesGuide/3-数据库/1-数据库系统原理/";
		String file = "数据库系统原理.md";
		String imagePath = "image/";
		Function<String, String> function = (line) -> {
			if (line.contains("<img")) {
				System.out.println("before change:" + line);
				Document doc = Jsoup.parseBodyFragment(line);
				String filePath = doc.select("img").first().attr("src");
				String fileNameOld = filePath.substring(filePath.lastIndexOf("/") + 1);
				String fileNameNew = RandomUtils.getSerialNo(DateUtils.DATE_DEFAULT_LONG_FORMAT, RandomUtils.NUMBERS, 4)
						.concat(fileNameOld.substring(fileNameOld.lastIndexOf(".")));

				System.out.println(fileNameOld);
				System.out.println(fileNameNew);

				/**重命名文件*/
				File file1 = new File(path.concat(imagePath).concat(fileNameOld));
				file1.renameTo(new File(path.concat(imagePath).concat(fileNameNew)));

				line = line.replace(fileNameOld, fileNameNew)
						.replace("https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com", "image")
						.replace("https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com", "image");
				System.out.println("after change:" + line);
			}

			return line;
		};
		FileUtil.replaceTxtByStr(path + file, function);
	}

}


