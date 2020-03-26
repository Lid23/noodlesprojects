package com.noodles.basic;

/**
 * @filename ImplicitConversion
 * @description 隐式转换
 * @author 巫威
 * @date 2020/3/19 9:17
 */
public class ImplicitConversion {

	public static void main(String[] args) {

		/**
		 * Java 不能隐式执行向下转型，因为这会使得精度降低
		 * 1.1 字面量属于 double 类型，不能直接将 1.1 直接赋值给 float 变量，因为这是向下转型
		 * */
		//float f = 1.1;
		float f = 1.1f;


		short s1 = 1;
		/**
		 * 1 是int，s1是short，不能向下转型
		 * */
		//s1 = s1 + 1;

		/**但是使用 += 或者 ++ 运算符会执行隐式类型转换*/
		s1 += 1;
		s1++;
	}
}
