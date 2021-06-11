package com.noodles.concurrent.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @filename CountDownLatchExample
 * @description 并发线程计数器:用来控制一个线程或者多个线程等待多个线程
 * 维护了一个计数器cnt，每次调用countDown()方法会让计数器的值减1，减到0的时候，
 * 那些因为调用await()方法而在等待的线程就会被唤醒
 * @author 巫威
 * @date 2020/6/5 9:09
 */
public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException {
		final int totalThread = 10;
		CountDownLatch countDownLatch = new CountDownLatch(totalThread);
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < totalThread; i++) {
			executorService.execute(() -> {
				System.out.println(Thread.currentThread().getName() + "...run...");
				countDownLatch.countDown();
			});
		}

		countDownLatch.await();
		System.out.println("end");
		executorService.shutdown();
	}

}
