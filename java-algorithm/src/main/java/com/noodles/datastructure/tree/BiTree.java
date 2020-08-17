package com.noodles.datastructure.tree;

/**
 * @filename BiTree
 * @description 二叉树
 * @author 巫威
 * @date 2020-08-17 21:14
 */
public class BiTree<E> {

	private BiTreeNode<E> root;

	public BiTree() {
	}


	/**
	 * 由先序序列和中序序列创建一颗二叉树的算法
	 * @param preOrder
	 * @param inOrder
	 * @param inIndex
	 * @param count 
	 * @return  
	 * @author 巫威 
	 * @date 2020-08-17 21:17 
	 */
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count){

	}

	/**用于记录preStr的索引值*/
	private static int index = 0;

	/**
	 * 由标明空子树的先序遍历序列创建一颗二叉树的算法
	 * @param preStr 
	 * @return  
	 * @author 巫威 
	 * @date 2020-08-17 21:20 
	 */
	public BiTree(String preStr) {

	}

	/**
	 * 先序遍历二叉树基本操作的递归算法
	 * @param t 
	 * @return void 
	 * @author 巫威 
	 * @date 2020-08-17 21:23 
	 */
	public void preRootTraverse(BiTreeNode<E> t) {

	}

	/**
	 * 先序遍历二叉树基本操作的非递归算法
	 * @param  
	 * @return void 
	 * @author 巫威 
	 * @date 2020-08-17 21:24 
	 */
	public void preRootTraverse(){

	}

	/**
	 * 中序遍历二叉树基本操作的递归算法
	 * @param t 
	 * @return void 
	 * @author 巫威 
	 * @date 2020-08-17 21:23 
	 */
	public void inRootTraverse(BiTreeNode<E> t) {

	}

	/**
	 * 中序遍历二叉树基本操作的非递归算法
	 * @param  
	 * @return void 
	 * @author 巫威 
	 * @date 2020-08-17 21:24 
	 */
	public void inRootTraverse(){

	}

	/**
	 * 后序遍历二叉树基本操作的递归算法
	 * @param t 
	 * @return void 
	 * @author 巫威 
	 * @date 2020-08-17 21:23 
	 */
	public void postRootTraverse(BiTreeNode<E> t) {

	}

	/**
	 * 后序遍历二叉树基本操作的非递归算法
	 * @param  
	 * @return void 
	 * @author 巫威 
	 * @date 2020-08-17 21:24 
	 */
	public void postRootTraverse(){

	}

	/**
	 * 层次遍历二叉树基本操作的算法（自左向右）
	 * @param  
	 * @return void 
	 * @author 巫威 
	 * @date 2020-08-17 21:26 
	 */
	public void levelTRaverse(){

	}

	public BiTreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode<E> root) {
		this.root = root;
	}
}
