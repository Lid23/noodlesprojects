package com.noodles.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.noodles.concurrent.threadpool.threadfactory.CustomThreadFactory;

/**
 * 文件名：FixedThreadPoolDemo.java
 * 描述：FixedThreadPoolDemo,预先执行代价高昂的线程分配，因而也就可以限制线程的数量了，可以节省时间，因为不用为每个任务付出固定的线程创建的开销
 * 作者：KJ00019
 * 日期：2017年10月31日下午4:45:14
 */
public class FixedThreadPoolDemo {
	public static void main(String args[]) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10, new CustomThreadFactory("线程-"));

		for (int i = 0; i < 100; i++) {
			fixedThreadPool.execute(() -> {
				Thread thread = Thread.currentThread();
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程名称：" + thread.getName() + ",线程优先级：" + thread.getPriority());
			});
		}

		fixedThreadPool.shutdown();
	}
}
