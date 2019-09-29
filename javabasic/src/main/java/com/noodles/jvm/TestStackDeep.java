package com.noodles.jvm;

/**
 * 文件名：TestStackDeep.java
 * 描述：通过递归调用测试栈最大深度，Java虚拟机通过 -Xss来指定线程的最大栈空间
 * 作者：KJ00019
 * 日期：2017年10月16日上午9:19:39
 */
public class TestStackDeep {
	
	private static int count = 0;
	
	
	/**
	 * 递归函数
	 * 作者：KJ00019
	 * 日期：2017年10月16日下午5:14:37
	 */
	public static void recursion(){
		count++ ;
		recursion();
	}
	
	/**
	 * 递归函数，包含局部变量
	 * 作者：KJ00019
	 * 日期：2017年10月16日下午5:15:07
	 */
	public static void recursionWithParams(long a, long b, long c){
		long e = 1, f = 2, g = 3, h = 4, i = 5, k = 6, q = 7, x = 8, y = 9 , z = 10;
		count++;
		recursionWithParams(a, b, c);
	}


	/**
	 * 局部变量a和b都作用到了函数的末尾，故java栈中b无法复用a所在的位置
	 * @param
	 * @return void
	 * @author 巫威
	 * @date 2019/9/18 17:03
	 */
	public void localvar1(){
		int a = 0;
		System.out.println(a);
		int b = 0;
	}

	/**
	 * 说明栈帧中局部变量表中的存储槽位是可以重用的，jclasslib查看
	 * 局部变量a在大括号外不再有效，故局部变量b可以复用a的槽位
	 * @param
	 * @return void
	 * @author 巫威
	 * @date 2019/9/18 17:02
	 */
	public void localvar2(){
		{
			int a = 0;
			System.out.println(a);
		}
		int b = 0;
	}
	
	public static void main(String args[]){
		try{
			 //recursion();
			recursionWithParams(0L, 0L, 0L);
		}catch(Throwable e){
			System.out.println("deep of calling:" + count);
			e.printStackTrace();
		}
	}
	
}
