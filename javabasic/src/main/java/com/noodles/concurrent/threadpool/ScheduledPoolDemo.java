package com.noodles.concurrent.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.noodles.concurrent.threadpool.threadfactory.CustomThreadFactory;

/**
 * @filename ScheduledPoolDemo
 * @description 定时线程池
 * @author 巫威
 * @date 2020/3/27 15:28
 */
public class ScheduledPoolDemo {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(10, new CustomThreadFactory("线程-"));

		Runnable task = new Runnable() {
			@Override
			public void run() {
				String pattern;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				System.out.println(format.format(new Date()));
			}
		};

		scheduledPool.scheduleWithFixedDelay(task, 10, 5, TimeUnit.SECONDS);

	}
}
