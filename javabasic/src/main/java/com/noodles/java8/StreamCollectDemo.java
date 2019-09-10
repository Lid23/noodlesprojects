package com.noodles.java8;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.noodles.java8.bean.Dish;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

/**
 * @filename StreamCollectDemo
 * @description 用流收集数据
 * @author 巫威
 * @date 2019/9/10 10:56
 */
public class StreamCollectDemo {

	public static void main(String[] args) {

		/**收集器归约和汇总*/
		long howManyDishes = Dish.menu.stream().collect(counting());
		long howManyDishes1 = Dish.menu.stream().count();
		System.out.println(howManyDishes);
		System.out.println(howManyDishes1);

		/**查找流中热量最高的菜*/
		Optional<Dish> mostCalorieDish = Dish.menu.stream().max(comparing(Dish::getCalories));
		Optional<Dish> mostCalorieDish1 = Dish.menu.stream().collect(maxBy(comparing(Dish::getCalories)));
		System.out.println(mostCalorieDish.get());
		System.out.println(mostCalorieDish1.get());

		/**汇总:菜单列表总热量*/
		int totalCalories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
		int totalCalories1 = Dish.menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
		System.out.println(totalCalories1);

		/**平均*/
		double avgCalories = Dish.menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println(avgCalories);

		/**汇总信息summarizingInt*/
		IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);

		/**连接字符串*/
		String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(shortMenu);

		/**广义的归约汇总*/
		int totalCalories2 = Dish.menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
		int totalCalories3 = Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
		System.out.println(totalCalories2);
		System.out.println(totalCalories3);

		Optional<Dish> mostCalorieDish2 = Dish.menu.stream()
				.collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalorieDish2.get());

		/**分组*/
		Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);

		/**根据Lambda分组*/
		Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream().collect(groupingBy(dish -> {
			if (dish.getCalories() <= 400) {
				return Dish.CaloricLevel.DIET;
			} else if (dish.getCalories() <= 700) {
				return Dish.CaloricLevel.NORMAL;
			} else {
				return Dish.CaloricLevel.FAT;
			}
		}));
		System.out.println(dishesByCaloricLevel);

		/**多级分组，根据菜类分组，再根据卡路里分组*/
		Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishedByTypeCaloricLevel = Dish.menu.stream()
				.collect(groupingBy(Dish::getType, groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return Dish.CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return Dish.CaloricLevel.NORMAL;
					} else {
						return Dish.CaloricLevel.FAT;
					}
				})));
		System.out.println(dishedByTypeCaloricLevel);

		/**按子组收集数据*/
		Map<Dish.Type, Long> dishTypeCount = Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(dishTypeCount);

		/**查找每种菜类中最高卡路里的菜*/
		Map<Dish.Type, Optional<Dish>> dishTypeMostCaloric = Dish.menu.stream()
				.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
		System.out.println(dishTypeMostCaloric);

		/**把收集器的结果，转换为另一种类型*/
	}
}
