package com.noodles.algorithm.common.eightqueen;

/**
 * @filename EightQueenByBackTracking
 * @description 八皇后问题回溯法
 * @author 巫威
 * @date 2019/7/30 15:55
 */
public class EightQueenByBackTracking {

	public static int ARRAY_NUM = 4;

	/**模拟棋盘*/
	public static int[][] array = new int[ARRAY_NUM][ARRAY_NUM];

	/**存储方案结果数量*/
	public static int count = 0;

	public static void main(String[] args) {
		System.out.println("八皇后问题");
		findQueen(0);
		System.out.println("共有:" + count + "种可能");
	}

	/**
	 * 寻找皇后节点
	 * @param i 行数
	 * @return void
	 * @author 巫威
	 * @date 2019/7/30 16:01
	 */
	private static void findQueen(int i){
		if(i >= ARRAY_NUM){
			//八皇后的解
			count++;
			print();
			return;
		}

		for(int m=0; m<ARRAY_NUM; m++){
			//深度回溯,递归算法
			if(checkQueen(i,m)){
				//检查皇后摆放是否合适
				array[i][m]=1;
				findQueen(i+1);
				array[i][m]=0;//清零，以免回溯的时候出现脏数据
			}
		}
	}

	/**
	 * 判断节点是否合适
	 * @param
	 * @return boolean
	 * @author 巫威
	 * @date 2019/7/30 16:04
	 */
	private static boolean checkQueen(int k, int j) {
		for(int i=0;i<ARRAY_NUM;i++){
			//检查行列冲突
			if(array[i][j] == 1){
				return false;
			}
		}
		for(int i=k-1,m=j-1; i>=0 && m>=0; i--,m--){
			//检查左对角线
			if(array[i][m]==1){
				return false;
			}
		}
		for(int i=k-1,m=j+1; i>=0 && m<=ARRAY_NUM - 1; i--,m++){
			//检查右对角线
			if(array[i][m]==1){
				return false;
			}
		}
		return true;
	}

	/**
	 * 打印结果
	 * @param
	 * @return void
	 * @author 巫威
	 * @date 2019/7/30 16:08
	 */
	public static void print(){
		//打印结果
		System.out.print("方案" + count + ":" + "\n");
		for(int i=0; i<ARRAY_NUM; i++){
			for(int m=0; m<ARRAY_NUM; m++){
				if(array[i][m]==1){
					System.out.print("o ");
				}
				else{
					System.out.print("+ ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
