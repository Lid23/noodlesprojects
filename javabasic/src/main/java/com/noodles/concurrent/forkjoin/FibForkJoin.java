package com.noodles.concurrent.forkjoin;

import EDU.oswego.cs.dl.util.concurrent.FJTask;
import EDU.oswego.cs.dl.util.concurrent.FJTaskRunnerGroup;

/**
 * 文件名：FibForkJoin.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月31日下午6:04:20
 */
public class FibForkJoin extends FJTask{
	
	static final int threshold = 15;
	volatile int number;
	
	FibForkJoin(int n){
		number = n;
	}
	
	int getAnswer(){
		if(!isDone()){
			throw new IllegalStateException();
		}
		return number;
	}
	
	int seqFib(int n){
		if(n <= 1){
			return n;
		}else {
			return seqFib(n - 1) + seqFib(n - 2);
		}
	}

	@Override
	public void run() {
		int n = number;
		if(n <= threshold){
			number = seqFib(n);
		}else {
			FibForkJoin f1 = new FibForkJoin(n - 1);
			FibForkJoin f2 = new FibForkJoin(n - 2);
			coInvoke(f1, f2);
			number = f1.number + f2.number;
		}
	}
	
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		
		try{
			int groupSize = 4;
			FJTaskRunnerGroup group = new FJTaskRunnerGroup(groupSize);
			FibForkJoin f = new FibForkJoin(45);
			group.invoke(f);
			int result = f.getAnswer();
			System.out.println("Answer: " + result);
		}catch (InterruptedException ex){
			ex.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
	}
	
}