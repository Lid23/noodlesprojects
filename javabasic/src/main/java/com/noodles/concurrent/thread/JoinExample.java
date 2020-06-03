package com.noodles.concurrent.thread;

/**
 * @filename JoinExample
 * @description 线程协作实例
 * @author 巫威
 * @date 2020/6/1 9:03
 */
public class JoinExample {

	private class A extends Thread {
		@Override
		public void run() {
			System.out.println("A");
		}
	}

	private class B extends Thread {

		private A a;

		public B(A a) {
			this.a = a;
		}

		@Override
		public void run() {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("B");
		}
	}

	public void test(){
		A a = new A();
		B b = new B(a);
		b.start();
		a.start();
	}

	public static void main(String[] args) {
		JoinExample joinExample = new JoinExample();
		joinExample.test();
	}

}
