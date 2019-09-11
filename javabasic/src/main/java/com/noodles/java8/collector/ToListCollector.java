package com.noodles.java8.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * @filename ToListCollector
 * @description 收集器接口实现简单例子
 * @author 巫威
 * @date 2019/9/11 14:50
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

	/**interface Collector<T, A, R>
	 * T 是流中要收集的项目的泛型
	 * A 是累加器的类型，累加器是在收集过程中用于累积部分结果的对象
	 * R 是收集操作得到的对象(通常但并不一定是集合)的类型
	 *
	 * ToListCollector<T> 将Stream<T>中的所有元素收集到一个List<T>里，
	 * */

	/**
	 * 1、建立新的结果容器: supplier方法
	 * @param
	 * @return java.util.function.Supplier<java.util.List < T>>
	 * @author 巫威
	 * @date 2019/9/11 15:15
	 */
	@Override
	public Supplier<List<T>> supplier() {
		return ArrayList::new;
	}

	/**
	 * 2.将元素添加到结果容器，accumulator方法会返回执行归约操作的函数
	 * 当遍历到流中第n个元素时，这个函数执行时会有两个参数，保存归约结果的
	 * 累加器(已收集了流中的n-1个项目)，还有第n个元素本身
	 *
	 * @param
	 * @return java.util.function.BiConsumer<java.util.List < T>,T>
	 * @author 巫威
	 * @date 2019/9/11 15:16
	 */
	@Override
	public BiConsumer<List<T>, T> accumulator() {
		//return (list, t) -> list.add(t);
		return List::add;
	}

	/**
	 * 3、对结果容器应用最终转换: 遍历完流后，finisher方法必须返回在累积过程的最后要调用的一个函数
	 * 以便将累加器对象转换为这个集合操作的最终结果
	 * @param
	 * @return java.util.function.Function<java.util.List < T>,java.util.List<T>>
	 * @author 巫威
	 * @date 2019/9/11 15:23
	 */
	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity();
	}

	/**
	 * 4、合并两个结果容器，combiner方法会返回一个供归约操作使用的函数，定义了
	 * 对流的各个子部分进行并行处理时，各个子部分归约所得的累加器要如何合并
	 * @param
	 * @return java.util.function.BinaryOperator<java.util.List < T>>
	 * @author 巫威
	 * @date 2019/9/11 16:13
	 */
	@Override
	public BinaryOperator<List<T>> combiner() {
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}

	/**
	 * characteristics 方法会返回一个不可变的Characteristics集合，它定义了
	 * 收集器的行为，尤其是关于流是否可以并行归约，以及可以使用哪些优化的提示
	 * Characteristics 是一个包含三个项目的枚举
	 * 1.UNORDERED : 归约结果不受流中项目的遍历和累积顺序的影响
	 * 2.CONCURRENT : accumulator函数可以从多个线程同时调用，且该收集器可以并行归约流，如果
	 * 收集器没有标识为UNORDERED，那它仅在用于无序数据源时才可以并行归约
	 * 3.IDENTITY-FINISH : 这表明完成器方法返回的函数是一个恒等函数，可以跳过，这种情况下，
	 * 累加器对象将会直接用作归约过程的最终结果
	 * @param
	 * @return java.util.Set<java.util.stream.Collector.Characteristics>
	 * @author 巫威
	 * @date 2019/9/11 16:17
	 */
	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
	}
}
