package com.noodles.java8;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import com.noodles.java8.bean.Dish;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

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

		/**把收集器的结果，转换为另一种类型，查找每个子组中热量最高的Dish*/
		Map<Dish.Type, Dish> mostCaloricByType = Dish.menu.stream().collect(
				groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricByType);

		/**与groupingBy联合使用的其他收集器的例子*/

		/**菜类热量总和*/
		Map<Dish.Type, Integer> totalCaloriesByType = Dish.menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
		System.out.println(totalCaloriesByType);


		/**对于每种类型的菜单中有哪些CaloricLevel*/
		Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType = Dish.menu.stream().collect(groupingBy(
				Dish::getType, mapping(dish -> {
					if (dish.getCalories() <= 400) {
						return Dish.CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return Dish.CaloricLevel.NORMAL;
					} else {
						return Dish.CaloricLevel.FAT;
					}
				}, toSet())
		));
		System.out.println(caloricLevelsByType);

		Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType1 = Dish.menu.stream().collect(groupingBy(
				Dish::getType, mapping(dish -> {
					if (dish.getCalories() <= 400) {
						return Dish.CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return Dish.CaloricLevel.NORMAL;
					} else {
						return Dish.CaloricLevel.FAT;
					}
				}, toCollection(HashSet::new))
		));
		System.out.println(caloricLevelsByType1);

		/**分区*/
		/**菜单按照素食和非素食分开*/
		Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(partitionedMenu);

		/**对素食和非素食再进行菜单分组*/
		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Dish.menu.stream().collect(partitioningBy(
				Dish::isVegetarian, groupingBy(Dish::getType)
		));
		System.out.println(vegetarianDishesByType);

		/**素食和非素食中热量最高的菜*/
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream().collect(partitioningBy(
				Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)
		));
		System.out.println(mostCaloricPartitionedByVegetarian);

		/**将数组按质数和非质数分区*/
		System.out.println(partitionPrimes(100));

	}

	/**
	 * 判断是否质数
	 * @param candidate
	 * @return boolean
	 * @author 巫威
	 * @date 2019/9/11 14:30
	 */
	public static boolean isPrime(int candidate){
		return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
	}

	/**
	 * 对质数和非质数进行分区
	 * @param n
	 * @return java.util.Map<java.lang.Boolean,java.util.List<java.lang.Integer>>
	 * @author 巫威
	 * @date 2019/9/11 14:32
	 */
	public static Map<Boolean, List<Integer>> partitionPrimes(int n){
		return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(candidate -> isPrime(candidate)));
	}
}
