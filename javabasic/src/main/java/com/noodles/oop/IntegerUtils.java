package com.noodles.oop;

/**
 * 文件名：IntegerUtils.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年10月9日上午8:46:00
 */
public class IntegerUtils {
	public static void main(String[] args) {
		/*【强制】所有的相同类型的包装类对象之间值的比较，全部使用 equals 方法比较。
		说明： 对于 Integer var = ? 在-128 至 127 范围内的赋值， Integer 对象是在
		IntegerCache.cache 产生，会复用已有对象，这个区间内的 Integer 值可以直接使用==进行
		判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，
		推荐使用 equals 方法进行判断*/

		Integer var1 = 100;
		Integer var2 = 100;
		System.out.println(var1 == var2);
		
		Integer var3 = 128;
		Integer var4 = 128;
		System.out.println(var3 == var4);
		
		System.out.println(var3.equals(var4));
		
		////////////////////////////////////////////////////////
		
		getAcctGroup(130);
		
	}
	
	static String getAcctGroup(Integer sumFirstPassdueDays) {

		if (sumFirstPassdueDays != null) {
			if (sumFirstPassdueDays > 0 && sumFirstPassdueDays <= 15) {
				return "01";
			}

			if (sumFirstPassdueDays >= 16 && sumFirstPassdueDays <= 30) {
				return "02";
			}

			Integer days = 31;
			if (sumFirstPassdueDays >= 1024) {
				return "03";
			}
		}

		return "98";

	}

}
