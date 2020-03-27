package com.noodles.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @filename FutureTaskDemo
 * @description 获取线程结果
 * @author 巫威
 * @date 2020/3/27 15:49
 */
public class FutureTaskDemo {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				String result = "Future";
				TimeUnit.SECONDS.sleep(10);
				return result;
			}
		});
		futureTask.run();
		System.out.println(futureTask.get());
	}
}
