package com.noodles.concurrent;

import com.noodles.concurrent.threads.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 文件名：SleepingTask.java
 * 描述：sleep方法将使任务中止给定的时间
 * 作者：KJ00019
 * 日期：2017年11月7日上午9:05:44
 */
public class SleepingTask extends LiftOff {

	@Override
	public void run(){
		try {
			while(countDown-- >0){
				System.out.print(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++){
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
