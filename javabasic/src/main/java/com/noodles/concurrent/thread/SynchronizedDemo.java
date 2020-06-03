package com.noodles.concurrent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @filename SynchronizedDemo
 * @description synchronized示例
 * @author 巫威
 * @date 2020/5/25 9:13
 */
public class SynchronizedDemo {

	/**
	 * 代码块同步，作用于同一对象
	 * @author 巫威
	 * @date 2020/5/26 15:43
	 */
	public void func1(){
		synchronized (this){
			for (int i=0; i<10; i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(i + ",");
			}
		}
	}

	/**
	 * 方法同步，作用于同一对象
	 * @author 巫威
	 * @date 2020/5/26 15:45
	 */
	public synchronized void func2(){
		for (int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i + ",");
		}
	}


	/**
	 * 类同步，作用于整个类
	 * @author 巫威
	 * @date 2020/5/26 15:47
	 */
	public void func3(){
		synchronized (SynchronizedDemo.class){
			for (int i=0; i<10; i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print(i + ",");
			}
		}
	}

	/**
	 * 静态方法同步，作用于整个类
	 * @author 巫威
	 * @date 2020/5/26 15:51
	 */
	public synchronized static void func4(){
		for (int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i + ",");
		}
	}



	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		SynchronizedDemo synchronizedDemo1 = new SynchronizedDemo();
		SynchronizedDemo synchronizedDemo2 = new SynchronizedDemo();


		/*executorService.execute(() -> synchronizedDemo1.func1());
		executorService.execute(() -> synchronizedDemo1.func1());
		executorService.execute(() -> synchronizedDemo2.func1());*/

		/*executorService.execute(() -> synchronizedDemo1.func2());
		executorService.execute(() -> synchronizedDemo1.func2());
		executorService.execute(() -> synchronizedDemo2.func2());*/

		/*executorService.execute(() -> synchronizedDemo1.func3());
		executorService.execute(() -> synchronizedDemo2.func3());*/
		executorService.execute(() -> SynchronizedDemo.func4());
		executorService.execute(() -> SynchronizedDemo.func4());
	}
}
