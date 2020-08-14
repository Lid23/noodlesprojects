package com.noodles.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @filename ReConstructBinaryTree
 * @description 重建二叉树 ： 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * @link https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 * @author 巫威
 * @date 2020/8/14 11:31
 */
public class ReConstructBinaryTree {
	public static void main(String[] args) {
		int[] pre = new int[]{};
		int[] in = new int[]{};

		ReConstructBinaryTree re = new ReConstructBinaryTree();
		re.reConstructBinaryTree(pre, in);
	}

	// 缓存中序遍历数组每个值对应的索引
	private Map<Integer, Integer> indexForInOrders = new HashMap<>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		for (int i = 0; i < in.length; i++){
			indexForInOrders.put(in[i], i);
		}
		return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
	}

	private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
		if (preL > preR) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode(pre[preL]);
		int inIndex = indexForInOrders.get(root.item);
		int leftTreeSize = inIndex - inL;
		root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
		root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
		return root;
	}

	public static class TreeNode<E> {
		E item;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E item){
			this.item = item;
		}
	}
}
