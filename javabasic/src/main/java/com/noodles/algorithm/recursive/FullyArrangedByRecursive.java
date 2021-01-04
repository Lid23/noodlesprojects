package com.noodles.algorithm.recursive;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.noodles.json.utils.JsonUtils;

/**
 * @filename FullyArrangedByRecursive
 * @description 递归实现全排列
 * @author 巫威
 * @date 2019/7/30 10:40
 */
public class FullyArrangedByRecursive {

	public static void main(String[] args) {

		char[] arr = {'a', 'b', 'c'};
		List<String> result = fullyArranged(arr, 0);
		System.out.println(JsonUtils.toJson(result));

	}

	/**
	 * 全排列递归实现
	 * @param cs
	 * @param current
	 * @return List<String>
	 * @author 巫威
	 * @date 2019/7/30 11:39
	 */
	private static List<String> fullyArranged(char[] cs, int current) {
		//结果
		List<String> result = new LinkedList<>();
		//当前指向数组最后一位时,将数组(全排列的一种)输出到结果集里
		if (current == cs.length - 1) {
			result.add(Arrays.toString(cs));
		} else {
			//循环改变数组的第一个位置的值,并求剩下的其他字符的全排列,并装入结果集.
			for (int i = current; i < cs.length; i++) {
				//交换当前字符与下一字符
				swap(cs, current, i);
				//这一块难理解,相当于,在A确定放在第一位的时候,求BC的全排列,并且加上A,形成ABC,ACB放入结果集.
				result.addAll(fullyArranged(cs, current + 1));
				//交换回来,方便下一次交换.
				swap(cs, current, i);
			}
		}
		return result;
	}

	/**
	 * 交换函数
	 * @param cs
	 * @param b
	 * @param e
	 * @return void
	 * @author 巫威
	 * @date 2019/7/30 11:39
	 */
	private static void swap(char[] cs, int b, int e) {
		char tmp = cs[b];
		cs[b] = cs[e];
		cs[e] = tmp;
	}
}
