package com.noodles.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @filename OsrDemo
 * @description Osr:运行时替换正在运行的函数/方法的栈帧的技术
 *  https://www.zhihu.com/question/45910849/answer/100636125
 * @author 巫威
 * @date 2019/10/9 18:00
 */
public class OsrDemo {
	public static void main(String[] args) {
		/**ArrayList插入1000w条数据之后*/
		List<Integer> list0 = new ArrayList<>();
		long start0 = System.currentTimeMillis();
		for(int i=0; i<10000000; i++){
			list0.add(i);
		}
		System.out.println(System.currentTimeMillis() - start0);

		List<Integer> list1 = new ArrayList<>();
		long start1 = System.currentTimeMillis();
		for(int i=10000000; i<20000000; i++){
			list1.add(i);
		}
		System.out.println(System.currentTimeMillis() - start1);

	}
}
