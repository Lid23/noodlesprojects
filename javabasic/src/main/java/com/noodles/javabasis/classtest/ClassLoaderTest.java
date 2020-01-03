package com.noodles.javabasis.classtest;

import java.net.URL;

/**
 * @filename ClassLoaderTest
 * @description 查看本地类加载器
 * @author 巫威
 * @date 2020/1/2 16:39
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		/**jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d*/
		ClassLoader c = ClassLoaderTest.class.getClassLoader();
		/**jdk.internal.loader.ClassLoaders$PlatformClassLoader@68de145*/
		ClassLoader c1 = c.getParent();
		/**PlatformClassLoader的Parent为Bootstrap，是通过C/C++实现的，并不存在于JVM体系类
		 * ，所以输出为null*/
		ClassLoader c2 = c1.getParent();

		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);

	}
}
