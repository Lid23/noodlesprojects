package com.noodles.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import com.noodles.gson.JsonUtil;

/**
 * @filename TwoSum
 * @description 给定数组和目标，查找数组中两个数的和等于目标值，返回数组索引，数组中的值只能用一次
 * @author 巫威
 * @date 2020/1/3 14:06
 */
public class TwoSum {

	static int[] array = {2, 5, 7, 9};
	static int target = 9;

	public static void main(String[] args) {
		System.out.println(JsonUtil.toJson(twoSum1(array, 9)));
		System.out.println(JsonUtil.toJson(twoSum2(array, 9)));
		System.out.println(JsonUtil.toJson(twoSum3(array, 9)));
	}

	/**
	 * 简单思路，两层循环，O(n²)
	 * @param array
	 * @param target
	 * @return int[]
	 * @author 巫威
	 * @date 2020/1/3 14:09
	 */
	static int[] twoSum1(int[] array, int target){
		for(int i=0; i<array.length; i++){
			for(int j=i+1; j<array.length; j++){
				if(array[j] == target - array[i]){
					return new int[]{i, j};
				}
			}
		}
		throw new IllegalArgumentException("no two sum solution");
	}

	/**
	 * 使用Map存储数组的值，一层循环两次，O(n)
	 * @param array
	 * @param target
	 * @return int[]
	 * @author 巫威
	 * @date 2020/1/3 14:14
	 */
	static int[] twoSum2(int[] array, int target){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<array.length; i++){
			map.put(array[i], i);
		}
		for(int i=0; i<array.length; i++){
			int term = target - array[i];
			if(map.containsKey(term) && i != map.get(term)){
				return new int[]{i, map.get(term)};
			}
		}
		throw new IllegalArgumentException("no two sum solution");
	}

	/**
	 * 在迭代并将元素插入Map中的同时，回头检查Map中是否已存在当前元素的补码,循环一次,O{n}
	 * @param array
	 * @param target
	 * @return int[]
	 * @author 巫威
	 * @date 2020/1/3 14:17
	 */
	static int[] twoSum3(int[] array, int target){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<array.length; i++){
			int term = target - array[i];
			if(map.containsKey(term)){
				return new int[]{map.get(term), i};
			}

			map.put(array[i], i);
		}
		throw new IllegalArgumentException("no two sum solution");
	}
}
