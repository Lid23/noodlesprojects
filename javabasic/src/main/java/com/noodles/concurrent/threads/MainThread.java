package com.noodles.concurrent.threads;

/**
 * 文件名：MainThread.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月31日下午4:08:20
 */
public class MainThread {
	public static void main(String args[]){
		/**main线程直接调用run方法*/
		/*LiftOff liftOff = new LiftOff();
		liftOff.run();*/
		
		/**线程驱动*/
		/*Thread thread = new Thread(new LiftOff());
		thread.start();
		System.out.println("Waiting for LiftOff");*/
		
		for(int i = 0; i < 5; i++){
			new Thread(new LiftOff()).start();
		}
		
		System.out.println("Waiting for LiftOff");
	}
}
