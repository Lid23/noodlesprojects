package com.noodles.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.noodles.java8.bean.Apple;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @filename ComplexLambda
 * @description 复合Lambda
 * @author 巫威
 * @date 2019/9/4 9:44
 */
public class ComplexLambda {

	static List<Apple> appleList = Arrays
			.asList(new Apple(100, "red"), new Apple(151, "red"), new Apple(50, "green"), new Apple(100, "green"),
					new Apple(300, "blue"));

	public static void main(String[] args) {
		/**比较器复合，根据重量逆序排序，两个苹果一样重时，进一步按颜色排序*/
		appleList.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		System.out.println(appleList);

		/**谓词复合*/
		Predicate<Apple> redApple = apple -> "red".equals(apple.getColor());
		/**链接两个谓词来生成另一个Predicate对象，苹果既是红色又比较重*/
		Predicate<Apple> redAndHeavyApple = redApple.and(a -> a.getWeight() > 150);
		System.out.println(appleList.stream().filter(redAndHeavyApple).collect(toList()));

		/**红色且比较重的苹果或者绿苹果*/
		Predicate<Apple> redAndHeavyOrGreenApple = redApple.and(a -> a.getWeight() > 150)
				.or(a1 -> "green".equals(a1.getColor()));
		System.out.println(appleList.stream().filter(redAndHeavyOrGreenApple).collect(toList()));

		/**函数复合*/
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;

		/**andThen先对输入应用一个给定函数，再对输出应用另一个函数，可以理解为 g(f(x))*/
		Function<Integer, Integer> h = f.andThen(g);
		System.out.println(h.apply(1));

		/**compose 相当于f(g(x))*/
		Function<Integer, Integer> h1 = f.compose(g);
		System.out.println(h1.apply(1));
	}
}
