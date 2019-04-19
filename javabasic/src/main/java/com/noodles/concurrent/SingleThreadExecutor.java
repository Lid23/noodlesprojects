package com.noodles.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 文件名：SingleThreadExecutor.java
 * 描述：SingleThreadExecutor像是线程数量为1的FixedThreadPool,如果向SingleThreadExecutor提交了多个任务，那么这些任务将排队
 * 作者：KJ00019
 * 日期：2017年11月1日上午9:15:43
 */
public class SingleThreadExecutor {
	public static void main(String args[]){
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		
		exec.shutdown();
	}
}
