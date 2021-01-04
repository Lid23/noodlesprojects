package com.noodles.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.noodles.java8.bean.Dish;
import com.noodles.java8.bean.Trader;
import com.noodles.java8.bean.Transaction;
import com.noodles.json.utils.JsonUtils;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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
		System.out.println(JsonUtils.toJson(pairs));

		/**只需要总和是否能被3整除的数对*/
		List<Integer[]> pairs1 = numbers1.stream()
				.flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new Integer[] { i, j }))
				.collect(toList());
		System.out.println(JsonUtils.toJson(pairs1));

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

		/**交易员和交易*/
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays
				.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
						new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710),
						new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		/**1.查找2011年发生的所有交易，并按交易额排序，从低到高*/
		List<Transaction> transactions2011 = transactions.stream().filter(transaction -> 2011 == transaction.getYear())
				.sorted(comparing(Transaction::getValue)).collect(toList());
		System.out.println(transactions2011);

		/**求和*/
		int sum3 = transactions.stream().map(d -> Integer.valueOf(d.getValue())).reduce(Integer::sum).get();
		System.out.println("sum3=" + sum3);


		/**2.交易员在哪些不同的城市工作过*/
		List<String> tradeCitys = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct()
				.collect(toList());
		System.out.println(tradeCitys);
		/**2.交易员在哪些不同的城市工作过,流转为Set*/
		Set<String> tradeCitySet = transactions.stream().map(transaction -> transaction.getTrader().getCity())
				.collect(toSet());
		System.out.println(tradeCitySet);

		/**3.查找所有来自于剑桥的交易员，并按姓名排序*/
		List<Trader> cambridgeTraders = transactions.stream().map(Transaction::getTrader)
				.filter(trader -> "Cambridge".equals(trader.getCity())).distinct().sorted(comparing(Trader::getName))
				.collect(toList());
		System.out.println(cambridgeTraders);

		/**4.返回所有交易员的姓名字符串，按字母顺序排序*/
		List<String> traderSet = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct()
				.sorted().collect(toList());
		System.out.println(traderSet);

		/**5.有没有交易员是在米兰工作的*/
		if (transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()))) {
			System.out.println("有交易员在米兰工作");
		}

		/**6.打印生活在剑桥的交易员的所有交易额*/
		transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
				.map(Transaction::getValue).forEach(System.out::println);

		/**7.查找最高交易额*/
		Optional<Integer> optionalMax = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(optionalMax.get());

		/**8.找到交易额最小的交易*/
		Optional<Transaction> optionalMin = transactions.stream().min(comparing(Transaction::getValue));
		System.out.println(optionalMin.get());

		/**原始类型流特化,mapToInt返回一个IntStream*/
		int calories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(calories);

		/**如果没有最大值的话，显式处理OptionalInt去定义个默认值*/
		OptionalInt maxCalories = Dish.menu.stream().mapToInt(Dish::getCalories).max();
		System.out.println(maxCalories.orElse(1));

		/**数值流一个从1到100的偶数流*/
		IntStream evenNumers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
		evenNumers.forEach(System.out::println);

		/**不包含结束值*/
		IntStream evenNumers1 = IntStream.range(1, 100).filter(n -> n % 2 == 0);
		evenNumers1.forEach(System.out::println);

		/**勾股数，三元组表示int[]（3， 4， 5）*/
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed().flatMap(
				a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));
		pythagoreanTriples.limit(50).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));

		/**勾股数，上面的方法不是最优的，需要求两次平方根，让代码更紧凑的一种可能的方法是，先生成所有的三元数组
		 * 再筛选符合条件的*/
		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed().flatMap(
				a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) })
						.filter(t -> t[2] % 1 == 0));
		pythagoreanTriples2.limit(50).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));

		/**由值创建流,将字符串转换为大写*/
		Stream<String> strStream = Stream.of("Java 8", "Lambdas ", "In ", "Action");
		strStream.map(String::toUpperCase).forEach(System.out::println);
		/**可以使用empty得到一个空流*/
		Stream<String> emptyStream = Stream.empty();

		/**数组创建流*/
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		System.out.println(Arrays.stream(numbers).sum());

		/**文件生成流，计算一个文件中有多少各不相同的词*/
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(Paths.get("d:/data.txt"), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("uniqueWords=" + uniqueWords);

		/**由函数生成流，创建无限流*/
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
		Stream.generate(Math::random).limit(10).forEach(System.out::println);

		/**斐波那契数*/
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0])
				.forEach(System.out::println);
	}

}
