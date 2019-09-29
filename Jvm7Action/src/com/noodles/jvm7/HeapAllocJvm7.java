package com.noodles.jvm7;

/**
 * 文件名：HeapAlloc.java
 * 描述：学习堆的配置参数，说明最大堆、初始堆、以及系统可用内存的含义和彼此之间的关系
 * 使用如下参数执行程序： -Xmx20m -Xms5m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
 * 作者：KJ00019
 * 日期：2017年10月19日下午2:22:45
 */
public class HeapAllocJvm7 {
	public static void main(String args[]){
		
		/**打印基本的系统信息，包括最大可用内存，当前空闲内存，和当前总内存*/
		System.out.print("maxMemory = ");
		System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
		
		System.out.print("free mem = ");
		System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
		
		System.out.print("total mem = ");
		System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
		
		/**申请1M内存空间，在堆上分配*/
		byte[] b = new byte[1 * 1024 * 1024];
		System.out.print("分配了1M空间给数组");
		
		System.out.print("maxMemory = ");
		System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
		
		System.out.print("free mem = ");
		System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
		
		System.out.print("total mem = ");
		System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
		
		/**申请4M内存空间，在堆上分配*/
		b = new byte[4 * 1024 * 1024];
		System.out.print("分配了4M空间给数组");
		
		System.out.print("maxMemory = ");
		System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
		
		System.out.print("free mem = ");
		System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
		
		System.out.print("total mem = ");
		System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
	}
}
