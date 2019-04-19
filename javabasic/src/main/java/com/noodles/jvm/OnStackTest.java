package com.noodles.jvm;

/**
 * 简单示例显示对非逃逸对象的栈上分配,无法重现，
 * 不显式设置逃逸分析和标量替换参数执行，User对象的分配过程也被优化
 * 文件名：OnStackTest.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月17日下午1:56:39
 */
public class OnStackTest {
	
	public static class User{
		public int id = 0;
		public String name = "";
	}
	
	public static void alloc(){
		User user = new User();
		user.id = 5;
		user.name = "Eric";
	}
	
	public static void main(String args[]) throws InterruptedException{
		long b = System.currentTimeMillis();
		for(int i=0; i<100000000; i++){
			alloc();
		}
		long e = System.currentTimeMillis();
		System.out.println(e - b);
	}
	
}
