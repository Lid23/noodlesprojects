package com.noodles.algorithm.leetcode;

import java.util.concurrent.ThreadLocalRandom;

import com.noodles.utils.ArrayUtils;

/**
 * @filename MaxSubArraySolution
 * @description 求最大和子数组
 * @author 巫威
 * @date 2019/10/22 17:25
 */
public class MaxSubArraySolution {

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int[] nums1 = ArrayUtils.getArray(1000000, -10, 10);

		long start1 = System.currentTimeMillis();
		System.out.println(maxSubSum1(nums1));
		System.out.println("maxSubSum1使用时间:" + (System.currentTimeMillis() - start1));

		long start2 = System.currentTimeMillis();
		System.out.println(maxSubSum2(nums1));
		System.out.println("maxSubSum2使用时间:" + (System.currentTimeMillis() - start2));

		long start3 = System.currentTimeMillis();
		System.out.println(maxSubSum3(nums1));
		System.out.println("maxSubSum3使用时间:" + (System.currentTimeMillis() - start3));

		long start4 = System.currentTimeMillis();
		System.out.println(maxSubSum4(nums1));
		System.out.println("maxSubSum4使用时间:" + (System.currentTimeMillis() - start4));

	}

	/**
	 * 穷举式，遍历所有的可能 O(n³)
	 * @param nums
	 * @return int
	 * @author 巫威
	 * @date 2019/10/23 9:43
	 */
	public static int maxSubSum1(int[] nums) {
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int thisSum = 0;
				for (int k = i; k < j; k++) {
					thisSum += nums[k];
					if (thisSum > maxSum) {
						maxSum = thisSum;
					}
				}
			}
		}
		return maxSum;
	}

	/**
	 * 穷举法改进，O(n²)， 基于第三个循环，sum(A{i->j}) = sum(A{i->j-1}) + A(j)
	 * @param nums
	 * @return int
	 * @author 巫威
	 * @date 2019/10/23 10:30
	 */
	public static int maxSubSum2(int[] nums) {
		int maxSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int thisSum = 0;
			for (int j = i; j < nums.length; j++) {
				thisSum += nums[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

	/**
	 * 递归分治法，O(N * logN)
	 * 将数组分成两部分，最大和子序列是左半部分的最大和子序列或者右半部分的最大和子序列或者
	 * 左半部分包含最后一个元素的最大和子序列加上右半部分包含右边第一个元素的最大和子序列
	 * @param nums
	 * @return int
	 * @author 巫威
	 * @date 2019/10/23 11:09
	 */
	public static int maxSubSum3(int[] nums) {
		return maxSubSumRec(nums, 0, nums.length - 1);
	}

	public static int maxSubSumRec(int[] nums, int left, int right) {
		if (left == right) {
			if (nums[left] > 0) {
				return nums[left];
			} else {
				return 0;
			}
		}

		int center = (right + left) / 2;
		int leftMaxSubSum = maxSubSumRec(nums, left, center);
		int rightMaxSubSum = maxSubSumRec(nums, center + 1, right);

		int leftMaxSubSumWithLast = 0;
		int rightMaxSubSumWithFirst = 0;
		int leftThisSum = 0;
		int rightThisSum = 0;
		for(int i=center; i>=left; i--){
			leftThisSum += nums[i];
			if(leftThisSum > leftMaxSubSumWithLast){
				leftMaxSubSumWithLast = leftThisSum;
			}
		}

		for(int i = center + 1; i<=right; i++){
			rightThisSum += nums[i];
			if(rightThisSum > rightMaxSubSumWithFirst){
				rightMaxSubSumWithFirst = rightThisSum;
			}
		}

		return max3(leftMaxSubSum, rightMaxSubSum, leftMaxSubSumWithLast + rightMaxSubSumWithFirst);
	}

	public static int max3(int num1, int num2, int num3){
		int term = num1 > num2 ? num1 : num2;
		return term > num3 ? term : num3;
	}

	/**
	 * 动态规划 O(n)
	 * @param nums
	 * @return int
	 * @author 巫威
	 * @date 2019/10/23 11:26
	 */
	public static int maxSubSum4(int[] nums) {
		int maxSum = 0;
		int thisSum = 0;

		for (int i = 0; i < nums.length; i++) {
			thisSum += nums[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			} else if (thisSum < 0) {
				thisSum = 0;
			}
		}

		return maxSum;
	}

}
