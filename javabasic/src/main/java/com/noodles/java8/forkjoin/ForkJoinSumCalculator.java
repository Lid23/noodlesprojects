package com.noodles.java8.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @filename ForkJoinSumCalculator
 * @description 用分支合并框架执行并行求和
 * @author 巫威
 * @date 2019/9/17 9:50
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private final long[] numbers;

	private final int start;

	private final int end;

	public static final long THRESHOLD = 10_000;

	public ForkJoinSumCalculator(long[] numbers){
		this(numbers, 0, numbers.length);
	}

	public ForkJoinSumCalculator(long[] numbers, int start, int end){
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	/**
	 * 这个方法同时定义了将任务拆分成子任务的逻辑，以及无法再拆分或不方便再拆分时，
	 * 生成单个子任务结果的逻辑
	 * @param
	 * @return java.lang.Long
	 * @author 巫威
	 * @date 2019/9/17 9:51
	 */
	@Override
	protected Long compute() {
		int length = end - start;
		if(length <= THRESHOLD){
			/**如果大小小于或等于阈值，顺序计算结果*/
			return computeSequentially();
		}

		/**创建一个子任务来为数组的前一半求和*/
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
		/**利用另一个ForkJoinPool线程异步执行新创建的子任务*/
		leftTask.fork();
		/**创建一个子任务来为数组的后一半求和*/
		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
		/**同步执行第二个子任务，有可能允许进一步递归划分*/
		Long rightResult = rightTask.compute();

		/**读取第一个子任务的结果，如果尚未完成就等待*/
		Long leftResult = leftTask.join();

		/**该任务的结果是两个子任务结果的组合*/
		return leftResult + rightResult;
	}

	private long computeSequentially(){
		long sum = 0;
		for(int i=start; i<end; i++){
			sum += numbers[i];
		}
		return sum;
	}

	public static long forkJoinSum(long n){
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}
}
