package com.noodles.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.noodles.gson.JsonUtil;
import com.noodles.java8.bean.Dish;
import static java.util.stream.Collectors.toList;

/**
 * @filename StreamDemo
 * @description 流处理
 * @author 巫威
 * @date 2019/9/4 11:04
 */
public class StreamDemo {

	static List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

	static List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");

	public static void main(String[] args) {
		/**选择热量高的三道菜的菜名，谓词筛选和截短*/
		List<String> threeHignCaloricDishNames = Dish.menu.stream().filter(dish -> dish.getCalories() > 300)
				.map(Dish::getName).limit(3).collect(toList());
		System.out.println(threeHignCaloricDishNames);

		/**筛选各异的元素*/
		System.out.println(numbers.stream().filter(i -> i % 2 == 0).distinct().collect(toList()));

		/**跳过元素，与limit对应*/
		List<String> skipHignCaloricDishNames = Dish.menu.stream().filter(dish -> dish.getCalories() > 300)
				.map(Dish::getName).skip(2).collect(toList());
		System.out.println(skipHignCaloricDishNames);

		/**映射，接受一个函数作为参数，这个函数会被应用到每个元素上，并将其映射成一个新的元素*/
		List<String> menuNames = Dish.menu.stream().map(Dish::getName).collect(toList());
		System.out.println(menuNames);

		/**获取每个单词的长度*/
		List<Integer> wordsLength = words.stream().map(String::length).collect(toList());
		System.out.println(wordsLength);

		/**流的扁平化，将每个元素生成一个流并合并*/
		List<String> distinctChar = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(toList());
		System.out.println(distinctChar);

		/**给定两个数字列表，返回所有的数对*/
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<Integer[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new Integer[] { i, j }))
				.collect(toList());
		System.out.println(JsonUtil.toJson(pairs));

		/**只需要总和是否能被3整除的数对*/
		List<Integer[]> pairs1 = numbers1.stream()
				.flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new Integer[] { i, j }))
				.collect(toList());
		System.out.println(JsonUtil.toJson(pairs1));

		/**anyMatch检查菜单中是否有素食可以选择*/
		if (Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("存在至少一种素食");
		}

		/**检查所有的菜品是否健康，低于 1000卡路里*/
		if (Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
			System.out.println("所有的菜品都健康");
		}

		if (Dish.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000)) {
			/**没有任何菜的卡路里大于等于1000*/
			System.out.println("所有的菜品都健康");
		}

		/**查找元素*/
		Optional<Dish> dishAny = Dish.menu.stream().findAny();
		dishAny.ifPresent(d -> System.out.println(d.getName()));

		Optional<Dish> dishFirst = Dish.menu.stream().findAny();
		dishFirst.ifPresent(d -> System.out.println(d.getName()));

		/**归约 reduce*/
		/**元素求和*/
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		int sum1 = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum1);
		Optional<Integer> sumOptioal = numbers.stream().reduce(Integer::sum);
		System.out.println(sumOptioal.get());

		/**最大值*/
		Integer max = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println(max);

		Optional<Integer> maxOptional = numbers.stream().reduce(Integer::max);
		System.out.println(maxOptional.get());

		Optional<Integer> minOptional = numbers.stream().reduce(Integer::min);
		System.out.println(minOptional.get());

		Optional<Integer> dishCount = Dish.menu.stream().map(d -> 1).reduce(Integer::sum);
		System.out.println(dishCount.get());

	}

}
