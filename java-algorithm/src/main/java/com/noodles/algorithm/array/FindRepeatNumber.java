package com.noodles.algorithm.array;

import java.util.Arrays;

/**
 * @filename FindRepeatNumber
 * @description 查找数组中重复的数字
 * @author 巫威
 * @date 2020/3/26 9:52
 */
public class FindRepeatNumber {

	final static int[] arr = { 2, 3, 1, 0, 2, 5 }; //输出 2

	static int[] duplication = new int[5];

	public static void main(String[] args) {
		/*if (duplicate(arr, arr.length, duplication)) {
			System.out.println(duplication[0]);
		} else {
			System.out.println("没有重复数字");
		}*/


		if (duplicate1(arr, arr.length, duplication)) {
			System.out.println(duplication[0]);
		} else {
			System.out.println("没有重复数字");
		}
	}

	/**
	 * 将输入数组排序，再判断相邻位置是否存在相同数字，
	 * 如果存在，对 duplication 赋值返回，否则继续比较
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @param length
	 * @param duplication
	 * @return boolean
	 * @author 巫威
	 * @date 2020/3/26 10:06
	 */
	public static boolean duplicate(int[] nums, int length, int[] duplication) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		Arrays.sort(nums);
		for (int i = 0; i < length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				duplication[0] = nums[i];
				return true;
			}
		}

		return false;
	}

	/**
	 * 对于这种数组元素在 [0, n-1] 范围内的问题，
	 * 可以将值为 i 的元素调整到第 i 个位置上进行求解。
	 * 本题要求找出重复的数字，因此在调整过程中，
	 * 如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复
	 * 复杂度：
	 *     时间复杂度：O(n)
	 *     空间复杂度：O(1)
	 * @param nums
	 * @param length
	 * @param duplication
	 * @return boolean
	 * @author 巫威
	 * @date 2020/3/26 10:17
	 */
	public static boolean duplicate1(int[] nums, int length, int[] duplication) {
		if (nums == null || nums.length == 0) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			while (i != nums[i]) {
				if(nums[nums[i]] == nums[i]){
					duplication[0] = nums[i];
					return true;
				}
				swap(nums, i, nums[i]);
			}
		}
		return false;
	}

	static void swap(int[] nums, int i, int j) {
		int term = nums[i];
		nums[i] = nums[j];
		nums[j] = term;
	}
}
