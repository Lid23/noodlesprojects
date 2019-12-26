package com.noodles.file;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * 文件名：FileNioUtil.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年11月30日下午4:02:53
 */
public class FileUtil1 {

	/**
	 * 私有构造方法
	 * @author 巫威
	 * @date 2019/12/23 17:31
	 */
	private FileUtil1(){

	}

	/**
	 * 传入条件过滤文件，并根据修改时间倒序排序
	 * @param fileList 文件列表
	 * @param predicate 过滤文件的条件
	 * @return java.util.List<java.io.File> 返回排序后的文件
	 * @author 巫威
	 * @date 2019/12/23 17:31
	 */
	public static List<File> getLastModifyFile(List<File> fileList, Predicate<File> predicate) {
		if (CollectionUtils.isEmpty(fileList)) {
			return null;
		}
		List<File> fileFilterList = fileList.stream().filter(predicate).collect(Collectors.toList());
		fileFilterList.sort(Comparator.comparing(File::lastModified).reversed());

		return fileFilterList;
	}

	/**
	 * 获取路径下的所有文件
	 * @param path 文件目录
	 * @return java.util.List<java.io.File> 文件列表
	 * @author 巫威
	 * @date 2019/12/23 17:32
	 */
	public static List<File> lsFiles(String path) {
		if (StringUtils.isBlank(path)) {
			return null;
		}
		File file = new File(path);
		if (file.isDirectory()) {
			return Arrays.asList(file.listFiles());
		}
		throw new RuntimeException(path + "is not directory");
	}

	/**
	 * 追写文件，编码为UTF8
	 * @param list 写入文件的列表数据
	 * @param file 写入的文件
	 * @return java.io.File 返回写入后的文件
	 * @author 巫威
	 * @date 2019/12/23 17:33
	 */
	public static <T> File appendUtf8Lines(Collection<T> list, File file) throws RuntimeException {
		return writeLines(list, file, Charsets.UTF_8, true);
	}

	/**
	 * 写文件，编码为UTF8
	 * @param list 写入文件的列表数据
	 * @param file 写入的文件
	 * @return java.io.File 返回写入后的文件
	 * @author 巫威
	 * @date 2019/12/23 17:34
	 */
	public static <T> File writeUtf8Lines(Collection<T> list, File file) throws RuntimeException {
		return writeLines(list, file, Charsets.UTF_8, false);
	}

	/**
	 * 写/追加文件
	 * @param list 写入文件的数据
	 * @param file 写入的文件
	 * @param charset 编码
	 * @param isAppend 是否追加
	 * @return java.io.File 返回写入数据后的文件
	 * @author 巫威
	 * @date 2019/12/23 17:34
	 */
	public static <T> File writeLines(Collection<T> list, File file, Charset charset, boolean isAppend)
			throws RuntimeException {
		try (PrintWriter writer = getPrintWriter(file, charset, isAppend)) {
			for (T t : list) {
				if (t != null) {
					writer.print(t.toString());
					writer.println();
					writer.flush();
				}
			}
		}
		return file;
	}

	/**
	 * 根据条件获取写入文件的PrintWriter
	 * @param file 写入的文件
	 * @param charset 编码
	 * @param isAppend 是否追加写入
	 * @return java.io.PrintWriter 返回写入文件的PrintWriter
	 * @author 巫威
	 * @date 2019/12/23 17:35
	 */
	public static PrintWriter getPrintWriter(File file, Charset charset, boolean isAppend) throws RuntimeException {
		try {
			return new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(touch(file), isAppend), charset)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 创建文件及其父目录，如果这个文件存在，直接返回这个文件
	 * @param file 需要创建的文件
	 * @return java.io.File 创建的文件
	 * @author 巫威
	 * @date 2019/12/23 17:36
	 */
	public static File touch(File file) throws RuntimeException {
		if (file == null) {
			return null;
		}
		if (!file.exists()) {
			mkParentDirs(file);
			try {
				file.createNewFile();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return file;
	}

	/**
	 * 创建文件父目录
	 * @param file 文件
	 * @return java.io.File 返回创建父目录后的文件
	 * @author 巫威
	 * @date 2019/12/23 17:37
	 */
	public static File mkParentDirs(File file) {
		final File parentFile = file.getParentFile();
		if (parentFile != null && !parentFile.exists()) {
			parentFile.mkdirs();
		}
		return parentFile;
	}

	/**
	 * 删除文件及子文件或目录
	 * @param file
	 * @return boolean
	 * @author 巫威
	 * @date 2019/12/23 17:38
	 */
	public static boolean del(File file) throws RuntimeException {
		if (file == null || false == file.exists()) {
			/**如果文件不存在或已被删除，此处返回true表示删除成功*/
			return true;
		}

		if (file.isDirectory()) {
			/**清空目录下所有文件和目录*/
			boolean isOk = clean(file);
			if (!isOk) {
				return false;
			}
		}

		/**删除文件或清空后的目录*/
		return file.delete();
	}


	/**
	 * 情况目录下的所有文件
	 * @param directory 需要清空的目录
	 * @return boolean 结果
	 * @author 巫威
	 * @date 2019/12/23 17:39
	 */
	public static boolean clean(File directory) throws RuntimeException {
		if (directory == null || directory.exists() == false || false == directory.isDirectory()) {
			return true;
		}

		final File[] files = directory.listFiles();
		if (null != files) {
			boolean isOk;
			for (File childFile : files) {
				isOk = del(childFile);
				if (isOk == false) {
					/**删除一个出错则本次删除任务失败*/
					return false;
				}
			}
		}
		return true;
	}

	public static String readUtf8String(File file) throws RuntimeException {
		return new String(readBytes(file), Charsets.UTF_8);
	}

	public static byte[] readBytes(File file) throws RuntimeException {
		long len = file.length();
		if (len >= Integer.MAX_VALUE) {
			throw new RuntimeException("File is larger then max array size");
		}

		byte[] bytes = new byte[(int) len];
		FileInputStream in = null;
		int readLength;
		try {
			in = new FileInputStream(file);
			readLength = in.read(bytes);
			if(readLength < len){
				throw new IOException("File length is " + len + " but read " + readLength +"!" );
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			close(in);
		}

		return bytes;
	}

	public static File writeUtf8String(String content, File file) throws RuntimeException {
		return write(file, content, false, Charsets.UTF_8);
	}

	public static File write(File file, String content, boolean isAppend, Charset charset) throws RuntimeException {
		BufferedWriter writer = null;
		try {
			writer = getWriter(file, isAppend, charset);
			writer.write(content);
			writer.flush();
		}catch(IOException e){
			throw new RuntimeException(e);
		}finally {
			close(writer);
		}
		return file;
	}

	public static BufferedWriter getWriter(File file, boolean isAppend, Charset charset) throws RuntimeException {
		try {
			return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(touch(file), isAppend), charset));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}



	public static void close(Closeable closeable) {
		if (null != closeable) {
			try {
				closeable.close();
			} catch (Exception e) {
			}
		}
	}

}