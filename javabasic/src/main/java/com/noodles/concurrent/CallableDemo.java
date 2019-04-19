package com.noodles.concurrent;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 文件名：CallableDemo.java
 * 描述：从任务中产生返回值，实现Callable接口
 * 作者：KJ00019
 * 日期：2017年11月7日上午8:49:02
 */
public class CallableDemo {
	public static void main(String args[]){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i=0; i<10; i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		
		for(Future<String> fs : results){
			try {
				System.out.println(fs.get());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally{
				exec.shutdown();
			}
		}
		
	}
}

class TaskWithResult implements Callable<String>{
	
	private int id;
	
	public TaskWithResult(int id){
		this.id = id;
	}
	
	public String call(){
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "result of TaskWithResult " + id;
	}
	
}
