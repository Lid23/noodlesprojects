package com.noodles.java8;

import java.util.Arrays;
import java.util.List;

import com.noodles.java8.bean.Apple;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @filename ListDemo
 * @description java8集合例子
 * @author 巫威
 * @date 2019/8/29 10:58
 */
public class ListDemo {

	static List<Apple> appleList = Arrays
			.asList(new Apple(100, "red"), new Apple(50, "green"), new Apple(200, "red"), new Apple(300, "blue"));

	public static void main(String[] args) {
		/**给苹果list进行排序，比较苹果的重量*/
		appleList.sort(comparing(Apple::getWeight));
		System.out.println(appleList);

		/**筛选重量大于100的苹果*/
		System.out.println(appleList.stream().filter(apple -> apple.getWeight() > 100).collect(toList()));
		/**筛选红色的苹果*/
		System.out.println(appleList.stream().filter(apple -> "red".equals(apple.getColor())).collect(toList()));
	}

}
