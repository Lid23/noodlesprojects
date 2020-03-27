package com.noodles.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.noodles.concurrent.threadpool.threadfactory.CustomThreadFactory;

/**
 * 文件名：SingleThreadPoolDemo.java
 * 描述：SingleThreadExecutor像是线程数量为1的FixedThreadPool,
 * 如果向SingleThreadExecutor提交了多个任务，那么这些任务将排队，
 * 任务的执行顺序和添加顺序一致
 * 作者：KJ00019
 * 日期：2017年11月1日上午9:15:43
 */
public class SingleThreadPoolDemo {
	public static void main(String args[]) {
		ExecutorService singleThreadPool = Executors.newSingleThreadExecutor(new CustomThreadFactory("线程-"));
		singleThreadPool.execute(() -> {
			Thread thread = Thread.currentThread();
			System.out.println("第一个任务添加...");
			System.out.println("线程名称：" + thread.getName());
			System.out.println("第一个任务执行完毕...");
		});
		singleThreadPool.execute(() -> {
			Thread thread = Thread.currentThread();
			System.out.println("第二个任务添加...");
			System.out.println("线程名称：" + thread.getName());
			System.out.println("第二个任务执行完毕...");
		});

		singleThreadPool.shutdown();
	}
}
