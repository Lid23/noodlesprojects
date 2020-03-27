package com.noodles.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @filename FutureDemo
 * @description 获取线程结果
 * @author 巫威
 * @date 2020/3/27 15:49
 */
public class FutureDemo {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 100, 60, TimeUnit.SECONDS, queue);

		Future<String> future = threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				String result = "Future";
				TimeUnit.SECONDS.sleep(10);
				return result;
			}
		});

		String result = future.get();
		System.out.println("线程返回结果:" + result);
	}
}
