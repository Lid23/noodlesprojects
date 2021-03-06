package com.noodles.jvm;

/**
 * 文件名：SimpleArgs.java
 * 描述：打印传递给main方法的参数和系统可用的最大堆内存
 * 作者：KJ00019
 * 日期：2017年10月13日下午2:54:03
 */
public class SimpleArgs {
	public static void main(String args[]){
		for(int i = 0; i < args.length; i++){
			System.out.println("参数" + (i + 1) + ":" + args[i]);
		}

		/**获取最大堆内存*/
		System.out.println("-Xmx" + Runtime.getRuntime().maxMemory() / 1000 /1000 + "M");
	}
}
