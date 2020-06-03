package com.noodles.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @filename WaitNotifyExample
 * @description wait和notify实例
 * @author 巫威
 * @date 2020/6/2 8:57
 */
public class WaitNotifyExample {

	public synchronized void before(){
		notify();
		System.out.println("before");
	}

	public synchronized void after(){
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after");
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		WaitNotifyExample example = new WaitNotifyExample();
		executorService.execute(() -> example.after());
		executorService.execute(() -> example.before());
	}
}
