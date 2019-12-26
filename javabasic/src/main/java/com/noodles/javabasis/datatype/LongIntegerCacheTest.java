package com.noodles.javabasis.datatype;

/**
 * @filename LongIntegerCacheTest
 * @description 验证基本数据类型包装类的区间数据缓存
 * @author 巫威
 * @date 2019/12/26 16:04
 */
public class LongIntegerCacheTest {

	public static void main(String[] args) {
		/**JKD9中直接把new的构造方法过时，推荐使用valueOf(),合理利用缓存，提升程序性能*/
		Long a = 127L;
		Long b = 127L;
		System.out.println("Long max cached value is 127, and the result is :" + (a == b));

		Long a1 = 128L;
		Long b1 = 128L;
		System.out.println("Long = 128 cache is:" + (a1 == b1));

		Long c = -128L;
		Long d = -128L;
		System.out.println("Long min cached value is -128, and the result is:" + (c == d));

		Long c1 = -129L;
		Long d1 = -129L;
		System.out.println("Long = -129 cache is:" + (c1 == d1));

		/**
		 * VM options加入参数 -XX:AutoBoxCacheMax=7777，即可设置最大缓存值为7777
		 * JVM AutoBoxCacheMax只对Integer对象有效*/
		Integer x = 1001;
		Integer y = 1001;
		System.out.println("Integer=1001 is:" + (x == y));

	}
}
