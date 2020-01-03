package com.noodles.algorithm.leetcode.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @filename PrintInOrder
 * @description Foo的相同实例将传递给三个不同的线程。 线程A将调用first（），
 * 线程B将调用second（），线程C将调用Third（）。
 * 设计一种机制并修改程序，以确保second（）在first（）之后执行，third（）在second（）之后执行
 * @author 巫威
 * @date 2020/1/3 16:25
 */
public class PrintInOrder {

	public static void main(String[] args) throws Exception{
		Foo foo = new PrintInOrder().new Foo();


		ExecutorService pool = Executors.newCachedThreadPool();
		pool.submit(() -> {
			try {
				foo.third(()->{
					System.out.println("third");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		pool.submit(() -> {
			try {
				foo.first(()->{
					System.out.println("first");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		pool.submit(() -> {
			try {
				foo.second(()->{
					System.out.println("second");
					try {
						Thread.sleep(6000L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

	}

	class Foo {
		CountDownLatch countDownLatch1 = new CountDownLatch(1);
		CountDownLatch countDownLatch2 = new CountDownLatch(1);

		public Foo() {

		}

		public void first(Runnable printFirst) throws InterruptedException {

			// printFirst.run() outputs "first". Do not change or remove this line.
			printFirst.run();
			countDownLatch1.countDown();
		}

		public void second(Runnable printSecond) throws InterruptedException {

			// printSecond.run() outputs "second". Do not change or remove this line.
			countDownLatch1.await();
			printSecond.run();
			countDownLatch2.countDown();
		}

		public void third(Runnable printThird) throws InterruptedException {
			countDownLatch2.await();
			// printThird.run() outputs "third". Do not change or remove this line.
			printThird.run();
		}
	}
}
