package com.noodles.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 文件名：FixedThreadPool.java
 * 描述：FixedThreadPool,预先执行代价高昂的线程分配，因而也就可以限制线程的数量了，可以节省时间，因为不用为每个任务付出固定的线程创建的开销
 * 作者：KJ00019
 * 日期：2017年10月31日下午4:45:14
 */
public class FixedThreadPool {
	public static void main(String args[]){
		ExecutorService exec = Executors.newFixedThreadPool(5);
		

		exec.shutdown();
	}
}
