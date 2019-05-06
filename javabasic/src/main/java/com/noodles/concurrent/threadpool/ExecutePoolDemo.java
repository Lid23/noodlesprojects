package com.noodles.concurrent.threadpool;

import com.noodles.concurrent.threadpool.runners.RunnerDemo;
import com.noodles.concurrent.threadpool.service.RunnerService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件名：ExecutePoolDemo.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年7月17日下午4:42:38
 */
public class ExecutePoolDemo {
	
	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();
		System.out.println("ExecutePool启动");
		
		ExecutorService pool = Executors.newCachedThreadPool();
        for(int i = 1 ; i <= 15 ; i++){
        	RunnerService runnerService = new RunnerService();
            pool.submit(new RunnerDemo(runnerService, String.valueOf(i)));
        }
        pool.shutdown();		
		
        long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000 + "秒");
	}
}
