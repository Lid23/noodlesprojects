package com.noodles.basic;

/**
 * @filename DoubleDemo
 * @description Double比较示例
 * @author 巫威
 * @date 2020/6/9 14:24
 */
public class DoubleDemo {

	public static void main(String[] args) {
		Double d1 = 100.0;
		Double d2 = 100.0;
		System.out.println(d1==d2);
		System.out.println(d1.compareTo(d2));

		Integer i1 = 12;
		Integer i2 = 12;
		System.out.println(i1 == i2);

		Integer i3 = 129;
		Integer i4 = 129;
		System.out.println(i3 == i4);
		System.out.println(i3.compareTo(i4));

		Integer i5 = 127;
		Integer i6 = 127;
		System.out.println(i5 == i6);
	}
}
