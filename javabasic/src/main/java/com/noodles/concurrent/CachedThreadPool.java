package com.noodles.concurrent;

import com.noodles.concurrent.threads.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件名：CachedThreadPool.java
 * 描述：CachedThreadPool在程序执行过程中创建任务需要的线程，然后再它回收旧线程时，停止创建新线程
 * 作者：KJ00019
 * 日期：2017年10月31日下午4:42:07
 */
public class CachedThreadPool {
	public static void main(String args[]){
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i=0; i<5; i++){
			exec.execute(new LiftOff());
		}
		
		exec.shutdown();
	}
}
