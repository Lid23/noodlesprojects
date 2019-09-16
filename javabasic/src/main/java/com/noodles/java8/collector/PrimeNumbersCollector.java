package com.noodles.java8.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @filename PrimeNumbersCollector
 * @description 自定义优化质数分区收集器
 * @author 巫威
 * @date 2019/9/16 9:12
 */
public class PrimeNumbersCollector
		implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
	@Override
	public Supplier<Map<Boolean, List<Integer>>> supplier() {
		return () -> new HashMap<Boolean, List<Integer>>(){{
			put(true, new ArrayList<Integer>());
			put(false, new ArrayList<Integer>());
		}};
	}

	/**
	 * 实现归约过程
	 * @param
	 * @return java.util.function.BiConsumer<java.util.Map<java.lang.Boolean,java.util.List<java.lang.Integer>>,java.lang.Integer>
	 * @author 巫威
	 * @date 2019/9/16 9:29
	 */
	@Override
	public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
		return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
			acc.get(isPrime(acc.get(true), candidate)).add(candidate);
		};
	}

	@Override
	public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
		return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
			map1.get(true).addAll(map2.get(true));
			map1.get(false).addAll(map2.get(false));
			return map1;
		};
	}

	@Override
	public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
	}

	/**
	 * 给定一个排序列表和一个谓词，返回元素满足谓词的最长前缀
	 * @param list
	 * @param p
	 * @return java.util.List<A>
	 * @author 巫威
	 * @date 2019/9/16 9:18
	 */
	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
		int i = 0;
		for (A term : list) {
			if (!p.test(term)) {
				return list.subList(0, i);
			}
			i++;
		}
		return list;
	}

	/**
	 * 仅用小于被求数平方跟的质数做被除数来判断被求数是否质数
	 * @param primes
	 * @param candidate
	 * @return boolean
	 * @author 巫威
	 * @date 2019/9/16 9:15
	 */
	public static boolean isPrime(List<Integer> primes, int candidate) {
		int candidateRoot = (int) Math.sqrt((double) candidate);
		return takeWhile(primes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
	}
}
