package com.noodles.java8;

import java.util.Comparator;

import com.noodles.java8.bean.Apple;

/**
 * @filename LambdaDemo
 * @description Lambda表达式
 * @author 巫威
 * @date 2019/8/29 14:46
 */
public class LambdaDemo {

	/**Comparator*/
	Comparator<Apple> appleWeightComparator = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

	Runnable runnable = () -> System.out.println();
}
