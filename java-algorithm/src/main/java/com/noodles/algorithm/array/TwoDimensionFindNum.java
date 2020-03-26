package com.noodles.algorithm.array;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中
 * @filename TwoDimensionFindNum
 * @description 二维数组查找
 * @author 巫威
 * @date 2020/3/26 10:24
 */
public class TwoDimensionFindNum {

	static int array[][] = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
			{ 18, 21, 23, 26, 30 } };

	public static void main(String[] args) {
		System.out.println(find(30, array));
	}


	/**
	 * 该二维数组中的一个数，小于它的数一定在其左边，
	 * 大于它的数一定在其下边。因此，从右上角开始查找，
	 * 就可以根据 target 和当前元素的大小关系来缩小查找区间，
	 * 当前元素的查找区间为左下角的所有元素。
	 * 时间复杂度 O(M + N)，空间复杂度 O(1)
	 * @param target
	 * @param array
	 * @return boolean
	 * @author 巫威
	 * @date 2020/3/26 10:41
	 */
	public static boolean find(int target, int[][] array) {

		int row = 0;
		int col = array[0].length-1;

		while(row < array.length && col>=0){
			if(array[row][col] == target){
				System.out.println(row + ", " + col);
				return true;
			}

			if(array[row][col] > target){
				col--;
			}else{
				row++;
			}
		}

		return false;
	}
}
