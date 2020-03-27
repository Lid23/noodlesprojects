package com.noodles.concurrent.threadpool.threads;

/**
 * 文件名：RunnableDemo1.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月31日下午4:19:15
 */
public class RunnableDemo1 implements Runnable{

	protected int n = 10;
	
	private static int taskCount = 0;
	
	private final int id = taskCount++;
	
	public RunnableDemo1(){
		
	}
	
	public RunnableDemo1(int n){
		this.n = n;
	} 
	
	public int fibonacci(int n){
        if(n<=2){
            return 1;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
	
	public void printFibonacci(int n){
		for(int i=1; i<n; i++){
			System.out.print(fibonacci(i) + ",");
		}
	}

	@Override
	public void run(){
		printFibonacci(n);
	}
	
	public static void main(String args[]){
		for(int i=1; i<3; i++){
			new Thread(new RunnableDemo1(10)).start();
		}
	}

}
