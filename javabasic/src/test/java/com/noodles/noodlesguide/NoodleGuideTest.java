package com.noodles.noodlesguide;

import java.io.File;
import java.nio.file.StandardCopyOption;
import java.util.function.Consumer;
import java.util.function.Function;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import com.noodles.date.utils.DateUtils;
import com.noodles.file.utils.FileNioUtil;
import com.noodles.file.utils.FileUtil;
import com.noodles.random.utils.RandomUtils;

/**
 * @filename FileTest
 * @description 测试文件读写工具类
 * @author 巫威
 * @date 2020/12/24 14:54
 */
public class NoodleGuideTest {

	/**
	 * 将笔记的图片复制到对应image目录下
	 * @param
	 * @return void
	 * @author 巫威
	 * @date 2020/12/28 16:45
	 */
	@Test
	public void mvImageToGuideTest() {
		String imageSrcPath = "C:/Users/KJ00019/Desktop/Github/CS-Notes/notes/pics/";
		String notePath = "E:/NoodlesGuide/3-数据库/6-Redis/";
		String file = "Redis-CSNOTE.md";
		String imagePath = "image/";
		Consumer<String> consumer = (line) -> {
			if (line.contains("<img")) {
				System.out.println("before change:" + line);
				Document doc = Jsoup.parseBodyFragment(line);
				String filePath = doc.select("img").first().attr("src");
				String fileNameOld = filePath.substring(filePath.lastIndexOf("/") + 1);

				System.out.println(fileNameOld);

				FileNioUtil.copyFile(imageSrcPath.concat(fileNameOld), notePath.concat(imagePath).concat(fileNameOld),
						StandardCopyOption.REPLACE_EXISTING);
			}

		};

		FileUtil.readLineHandler(notePath + file, consumer);
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
		String path = "E:/NoodlesGuide/3-数据库/6-Redis/";
		String file = "Redis-CSNOTE.md";
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


