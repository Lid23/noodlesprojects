package com.noodles.concurrent.forkjoin;


/**
 * 文件名：Fib.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月31日下午6:04:20
 */
public class Fib {
	
	public static int seqFib(int n){
		if(n <= 1){
			return n;
		}else {
			return seqFib(n - 1) + seqFib(n - 2);
		}
	}
	
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		
		int result = seqFib(45);
		System.out.println("Answer: " + result);
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
	}

}
