package com.noodles.concurrent.threadpool.threads;

/**
 * 实现Runnable接口，定义线程任务
 * 文件名：LiftOff.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月31日下午4:04:20
 */
public class LiftOff implements Runnable{
	
	protected int countDown = 10;
	
	private static int taskCount = 0;
	
	private final int id = taskCount++;
	
	public LiftOff(){
		
	}
	
	public LiftOff(int countDown){
		this.countDown = countDown;
	} 
	
	public String status(){
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + "),";
	}
	
	public void run(){
		while(countDown-- > 0){
			System.out.print(status());
			Thread.yield();
		}
		System.out.println();
	}
}