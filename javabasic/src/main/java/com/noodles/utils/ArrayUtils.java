package com.noodles.utils;

import org.apache.commons.lang.math.RandomUtils;

/**
 * @filename ArrayUtils
 * @description 数组工具类
 * @author 巫威
 * @date 2019/10/24 9:29
 */
public class ArrayUtils {

	/**
	 * 初始化随机整数数组
	 * @param n 数组长度
	 * @param min 数组取值范围下界
	 * @param max 数组取值范围上界
	 * @return int[]
	 * @author 巫威
	 * @date 2019/10/24 9:30
	 */
	public static int[] getArray(int n, int min, int max) {
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = RandomUtils.nextInt();
		}
		return array;
	}

	public static Integer[] getArrayInteger(int n, int min, int max) {
		Integer[] array = new Integer[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.valueOf(RandomUtils.nextInt());
		}
		return array;
	}
}
