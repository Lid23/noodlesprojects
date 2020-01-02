package com.noodles.javabasis.classtest;

import java.lang.reflect.Field;

/**
 * @filename ClassTest
 * @description ClassTest
 * @author 巫威
 * @date 2020/1/2 15:59
 */
public class ClassTest {

	/**数组类型有一个魔法属性：length来获取数组长度*/
	private static int[] array = new int[3];
	private static int length = array.length;

	/**任何class定义的类，也有一个魔法属性:class,获取此类的Class类对象*/
	private static Class<One> one = One.class;
	private static Class<Another> another = Another.class;

	public static void main(String[] args) throws Exception {
		/**通过newInstance方法创建One和Another的类对象*/
		One oneObject = one.newInstance();
		oneObject.call();

		Another anotherObject = another.newInstance();
		anotherObject.speak();

		/**通过Class对象，获取私有成员属性对象Field*/
		Field privateFieldInOne = one.getDeclaredField("inner");
		/**设置私有对象可以访问和修改*/
		privateFieldInOne.setAccessible(true);
		privateFieldInOne.set(oneObject, "world changed");
		System.out.println(oneObject.getInner());
	}
}


class One {
	private String inner = "time files.";

	public void call(){
		System.out.println("hello world.");
	}

	public String getInner(){
		return inner;
	}
}

class Another{
	public void speak(){
		System.out.println("easy coding.");
	}
}
