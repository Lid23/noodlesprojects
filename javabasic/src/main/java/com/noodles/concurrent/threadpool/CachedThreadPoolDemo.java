package com.noodles.concurrent.threadpool;

import com.noodles.concurrent.threadpool.runners.RunnerDemo;
import com.noodles.concurrent.threadpool.service.RunnerService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class CachedThreadPoolDemo {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		System.out.println("ExecutePool启动");
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= 3; j++) {
				RunnerService runnerService = new RunnerService();
				pool.submit(new RunnerDemo(runnerService, String.valueOf(i)));
			}
			Thread.sleep(5000);
		}

		pool.shutdown();

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + "秒");
	}
}
