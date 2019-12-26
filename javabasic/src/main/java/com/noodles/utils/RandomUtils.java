package com.noodles.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @filename RandomUtils
 * @description 随机工具类
 * @author 巫威
 * @date 2019/10/24 9:27
 */
public class RandomUtils {

	/**
	 * 某个范围内的随机整数
	 * @param min
	 * @param max
	 * @return int
	 * @author 巫威
	 * @date 2019/10/24 9:27
	 */
	public static int randomInt(int min, int max) {
		return getRandom().nextInt(min, max);
	}

	/**
	 * ThreadLocalRandom
	 * @return
	 * @author 巫威
	 * @date 2019/10/24 9:28
	 */
	public static ThreadLocalRandom getRandom() {
		return ThreadLocalRandom.current();
	}
}
