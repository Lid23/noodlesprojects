package com.noodles.algorithm.common.fullyarranged;

import java.util.ArrayList;
import java.util.List;

/**
 * @filename FullyArrangedByDictionayOrder
 * @description 根据字典排序进行全排列
 * @author 巫威
 * @date 2019/7/30 14:09
 */
public class FullyArrangedByDictionayOrder {

	/**
	 * 思路：
	 * 1.对初始队列进行排序，找到所有排列中最小的一个排列Pmin。
	 * 2.找到刚刚好比Pmin大比其它都小的排列P(min+1)。
	 * 3.循环执行第二步,直到找到一个最大的排列,算法结束。
	 * 如排列12345，这是所有排列中最小的一个排列，刚好比12345大的排列是：12354
	 * */

	//参考 https://blog.csdn.net/qq_29210929/article/details/79617256
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		System.out.println(permuteUnique(arr));
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		// write your code here
		List<List<Integer>> list=new ArrayList<>();
		if(nums==null | nums.length == 0){
			list.add(new ArrayList<Integer>());
			return list;
		}
		//排序
		insertionSort(nums);
		List<Integer> array= new ArrayList<Integer>();
		for (int t : nums){
			array.add(t);
		}
		list.add(array);
		int i;
		while((i=hasNext(nums))>0) {
			int a=nums[i-1];
			int b=nums[i];
			int k=i;
			int j=i;
			while(j<nums.length) {
				if(nums[j]>a & nums[j]<=b) {
					b=nums[j];
					k=j;
				}
				j++;
			}
			swap(nums,i-1,k);
			//反转
			reverse(nums,i,nums.length-1);
			List<Integer> arr= new ArrayList<Integer>();
			for (int t : nums) {
				arr.add(t);
			}
			list.add(arr);
		}
		return list;
	}

	public static int hasNext(int[] nums) {
		for(int i=nums.length-1;i>0;i--) {
			if(nums[i]>nums[i-1]) {
				return i;
			}
		}
		return 0;
	}

	public static void reverse(int[] nums,int i,int j) {
		while(i<j) {
			swap(nums,i++,j--);
		}
	}
	public static void swap(int[] nums,int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
		return ;
	}

	public static void insertionSort(int[] arr) {
		int len = arr.length;
		int preIndex, current;
		for (int i = 1; i < len; i++) {
			preIndex = i - 1;
			current = arr[i];
			while(preIndex >= 0 && arr[preIndex] > current) {
				arr[preIndex+1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex+1] = current;
		}
	}
}
