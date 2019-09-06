package com.noodles.java8;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.noodles.java8.bean.Apple;
import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

/**
 * @filename LambdaDemo
 * @description Lambda表达式
 * @author 巫威
 * @date 2019/8/29 14:46
 */
public class LambdaDemo {

	static List<Apple> appleList = asList(new Apple(100, "red"), new Apple(50, "green"), new Apple(200, "red"), new Apple(300, "blue"));

	public static void main(String[] args) {

		/**给苹果list进行排序，比较苹果的重量*/
		appleList.sort(comparing(Apple::getWeight));

		/**Comparator*/
		Comparator<Apple> appleWeightComparator = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

		Runnable runnable = () -> System.out.println();

		/**同样的Lambda，不同的函数式接口*/
		Callable<Integer> callable = () -> 42;
		PrivilegedAction<Integer> privilegedAction = () -> 42;

		/**Predicate返回了一个boolean*/
		Predicate<String> p = s -> new ArrayList().add(s);
		/**void兼容：Consumer返回了一个void*/
		Consumer<String> b = s -> new ArrayList().add(s);

		/**构造函数引用*/
		Supplier<Apple> appleSupplier = Apple::new;
		Apple apple = appleSupplier.get();

		BiFunction<Integer, String, Apple> appleBiFunction = Apple::new;
		System.out.println(appleBiFunction.apply(100, "red"));
	}


}
