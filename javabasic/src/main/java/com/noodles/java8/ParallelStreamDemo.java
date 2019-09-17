package com.noodles.java8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.noodles.java8.forkjoin.ForkJoinSumCalculator;

/**
 * @filename ParallelStreamDemo
 * @description 并行流
 * @author 巫威
 * @date 2019/9/17 9:06
 */
public class ParallelStreamDemo {

	public static void main(String[] args) {
		/**105ms*/
		System.out.println("通过生成无限流来对数字求和:" + measureSumPerf(ParallelStreamDemo::sequentialSum, 10_000_000));

		/**410ms*/
		System.out.println("将顺序流转换为并行流求和:" + measureSumPerf(ParallelStreamDemo::parallelSum, 10_000_000));

		/**4ms*/
		System.out.println("传统java迭代求和:" + measureSumPerf(ParallelStreamDemo::iterativeSum, 10_000_000));

		/**
		 * 1.iterate生成的是装箱的对象，必须拆箱成数字才能求和，会影响性能
		 * 2.传统迭代更为底层，效率高
		 * 3.iterate流并行化最慢是因为，iterate很难分割成能够独立执行的小块，
		 * 因为每次应用这个函数都要依赖前一次应用的结果，把流标记成并行，其实是给顺序处理增加了开销
		 * 它还要把每次求和操作分到一个不同的线程上
		 * 4.以上测试说明，并行编程可能很复杂，有时候甚至有点违反直觉，如果用的不对(比如才用了一个不易并行化的操作，如iterator)，
		 * 它甚至可能让程序的整体性能更差，所以在调用parallel进行并行化时，需要了解背后到底发生了什么是很有必要的
		 * */

		/**4ms，因为避免了非针对性流那些没必要的自动装箱和拆箱操作，效率和传统底层迭代求和接近*/
		System.out.println("采用原始类型流求和:" + measureSumPerf(ParallelStreamDemo::rangeSum, 10_000_000));

		/**1ms，使用了正确的数据结构然后使其并行工作能够保证最佳的性能*/
		System.out.println("原始类型流并行化求和:" + measureSumPerf(ParallelStreamDemo::parallelRangeSum, 10_000_000));

		/**
		 * 并行化并不是没有代价的，并行化过程本身需要对流做递归划分，把每个子流的归纳操作分配给不同的线程
		 * 然后把这些操作的结果合并成一个值，但在多个内核之间移动数据的代价也可能比想象的要大
		 * */

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**正确使用并行流，如使用含有数据竞争的累加器方法进行求和，会得到错误的不同结果，那性能也无关紧要了*/
		System.out.println("使用累加器并行化求和:" + measureSumPerf(ParallelStreamDemo::sideEffectParallelSum, 10_000_000));

		/**forkJoin*/
		System.out.println("分支合并框架对自然数求和:" + measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000));


	}

	/**
	 * 测量对前n个自然数求和方法的性能,取10次最快时间
	 * @param adder
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:15
	 */
	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fatest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fatest) {
				fatest = duration;
			}
		}
		return fatest;
	}

	/**
	 * 通过生成无限流来对数字求和
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:08
	 */
	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}

	/**
	 * 将顺序流转换为并行流求和
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:11
	 */
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}

	/**
	 * 传统java迭代求和
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:10
	 */
	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; i++) {
			result += i;
		}
		return result;
	}

	/**
	 * 采用原始类型流求和
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:28
	 */
	public static long rangeSum(long n){
		return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
	}

	/**
	 * 原始类型流并行化求和
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:31
	 */
	public static long parallelRangeSum(long n){
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}

	/**
	 * 初始化累加器，一个个遍历列表中的元素，把它们和累加器相加
	 * 这样的代码每次访问total都会出现数据竞争，如果使用同步，那就完全失去了并行
	 * 的意义了
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:42
	 */
	public static long sideEffectSum(long n){
		Accumulator accumulator = new ParallelStreamDemo().new Accumulator();
		LongStream.rangeClosed(1, n).forEach(accumulator::add);
		return accumulator.total;
	}

	/**
	 * 累加器尝试并行化
	 * 会得到错误结果
	 * @param n
	 * @return long
	 * @author 巫威
	 * @date 2019/9/17 9:44
	 */
	public static long sideEffectParallelSum(long n){
		Accumulator accumulator = new ParallelStreamDemo().new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
		return accumulator.total;
	}

	/**
	 * 累加器
	 * @filename Accumulator
	 * @author 巫威
	 * @date 2019/9/17 9:40
	 */
	class Accumulator{

		public long total = 0;

		public void add(long value){
			total += value;
		}

	}
}
