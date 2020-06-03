package com.noodles.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @filename AwaitSignalExample
 * @description await和signal方法实例
 * @author 巫威
 * @date 2020/6/2 9:02
 */
public class AwaitSignalExample {

	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void before(){
		lock.lock();
		try{
			System.out.println("before");
			condition.signal();
		}finally {
			lock.unlock();
		}
	}

	public void after(){
		lock.lock();
		try{
			condition.await();
			System.out.println("after");
		}catch (InterruptedException e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		AwaitSignalExample example = new AwaitSignalExample();
		executorService.execute(() -> example.after());
		executorService.execute(() -> example.before());
	}
}
