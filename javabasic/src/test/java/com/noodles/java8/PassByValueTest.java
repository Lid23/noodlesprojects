package com.noodles.java8;

/**
 * @filename PassByValueTest
 * @description 值传递
 * @author 巫威
 * @date 2020/4/28 9:40
 */
public class PassByValueTest {

	public static void main(String[] args) {
		int num = 10;
		PassByValueTest passByValueTest = new PassByValueTest();
		passByValueTest.foo(num); //num不会被改变
		System.out.println(num);

		String str = "eric";
		passByValueTest.foo(str);
		System.out.println(str); // str也没有被改变
	}

	/**
	 * 基本类型
	 * @param value
	 * @author 巫威
	 * @date 2020/4/28 9:48
	 */
	void foo(int value){
		value = 100;
	}

	/**
	 * 没有提供改变自身方法的引用类型
	 * @param text
	 * @author 巫威
	 * @date 2020/4/28 9:48
	 */
	void foo(String text){
		text = "hello";
	}

	/**
	 * 没有提供改变自身方法的引用类型
	 * 会改变
	 * @param builder
	 * @author 巫威
	 * @date 2020/4/28 9:48
	 */
	void foo(StringBuilder builder){
		builder.append(" world");
	}

	/**
	 * 提供了改变自身方法的引用类型，但是不使用，而是使用赋值运算符
	 * @param builder
	 * @author 巫威
	 * @date 2020/4/28 9:48
	 */
	void foo1(StringBuilder builder){
		builder = new StringBuilder(" world");
	}
}
