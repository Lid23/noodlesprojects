package com.noodles.algorithm.find;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.noodles.json.utils.JsonUtils;
import com.noodles.utils.ArrayUtils;

/**
 * @filename HaftSearchSolution
 * @description 折半查找
 * @author 巫威
 * @date 2019/10/24 9:32
 */
public class HaftSearchSolution {

	public static void main(String[] args) {
		Integer[] array = ArrayUtils.getArrayInteger(10, -10, 10);
		System.out.println(JsonUtils.toJson(array));
		List<Integer> list = Arrays.asList(array);
		Collections.sort(list);
		System.out.println(JsonUtils.toJson(list.toArray(array)));

		System.out.println(binarySearch(list.toArray(array), 2));

	}

	/**
	 * 折半查找，前提条件是数组有序
	 * @param array
	 * @param x
	 * @return int
	 * @author 巫威
	 * @date 2019/10/24 9:38
	 */
	public static int binarySearch(Integer[] array, Integer x){
		int low = 0;
		int high = array.length - 1;
		while(low <= high){
			int mid = (low + high) / 2;
			if(array[mid].compareTo(x) < 0 ){
				low = mid + 1;
			} else if(array[mid].compareTo(x) > 0){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}
