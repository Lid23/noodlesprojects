package com.noodles.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.noodles.concurrent.threadpool.runners.RunnerDemo;
import com.noodles.concurrent.threadpool.service.RunnerService;
import com.noodles.concurrent.threadpool.threadfactory.CustomThreadFactory;

/**
 * CachedThreadPool：一个任务一个线程
 * 注意：使用Executors来创建线程池，失去了线程池的灵活性，而且存在一定的隐患，
 * 根据阿里巴巴规范插件的提示，使用Executors来创建线程池存在资源耗尽的可能，
 * 因为使用Executors来创建线程池默认的最大容量是Integer.Max，
 * 也就是Integer的最大值作为线程池的最大容量，这样在程序中可能出现错误，
 * 导致创建了Integer.Max个线程，存在内存溢出的风险
 * @filename CachedThreadPoolDemo
 * @author 巫威
 * @date 2020/3/27 13:58
 */
public class CachedThreadPoolDemo1 {

	public static void main(String[] args) throws Exception {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool(new CustomThreadFactory("线程-"));

		for (int i = 1; i <= 1000; i++) {
			final int index = i;
			cachedThreadPool.execute(() -> {
				Thread thread = Thread.currentThread();
				System.out.println("线程名称：" + thread.getName() + "，执行第" + index + "个任务");
			});
		}
		cachedThreadPool.shutdown();
	}
}
