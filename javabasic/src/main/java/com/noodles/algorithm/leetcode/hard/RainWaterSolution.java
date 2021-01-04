package com.noodles.algorithm.leetcode.hard;

import com.noodles.json.utils.JsonUtils;

/**
 * @filename RainWaterSolution
 * https://leetcode.com/problems/trapping-rain-water/description/
 * @description 雨水问题
 * @author 巫威
 * @date 2020/6/30 9:22
 */
public class RainWaterSolution {

	public static void main(String[] args) {
		Integer[] height = new Integer[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Integer rain = rainWaterSoluation(height);
		System.out.println("积水：" + rain);
	}

	/**
	 * 暴力循环求解思路：
	 * 1.下雨后的高度减去下雨前的高度*宽度，再求和
	 * 2.如何求下雨后的高度，位置左侧最大值和又测最大值的较小值
	 * 3.维护两个数组分别为左侧最大值和右侧最大值数组
	 * @param height
	 * @return java.lang.Integer
	 * @author 巫威
	 * @date 2020/6/30 9:45
	 */
	public static Integer rainWaterSoluation(Integer[] height) {
		Integer[] leftMax = new Integer[height.length];
		Integer[] rightMax = new Integer[height.length];
		Integer[] h = new Integer[height.length];

		Integer max = 0;
		for (int i = 0; i < height.length; i++) {
			leftMax[i] = max = Math.max(max, height[i]);
		}

		max = 0;
		for (int i = height.length-1; i >= 0; i--) {
			rightMax[i] = max = Math.max(max, height[i]);
		}

		Integer rain = 0;
		for (int i = 0; i < height.length; i++) {
			h[i] = Math.min(leftMax[i], rightMax[i]);
			rain += (Math.min(leftMax[i], rightMax[i]) - height[i]) * 1;
		}

		System.out.println(JsonUtils.toJson(h));
		return rain;
	}

}
