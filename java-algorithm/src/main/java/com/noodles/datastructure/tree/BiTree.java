package com.noodles.datastructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import EDU.oswego.cs.dl.util.concurrent.LinkedQueue;

/**
 * @filename BiTree
 * @description 二叉树
 * @author 巫威
 * @date 2020-08-17 21:14
 */
public class BiTree<E> {

	public static void main(String[] args) {
		BiTreeNode<String> root = new BiTreeNode<>();
		root.setData("-");
		BiTreeNode<String> node1 = new BiTreeNode<>();
		node1.setData("*");
		BiTreeNode<String> node2 = new BiTreeNode<>();
		node2.setData("/");
		BiTreeNode<String> node3 = new BiTreeNode<>();
		node3.setData("+");
		BiTreeNode<String> node4 = new BiTreeNode<>();
		node4.setData("A");
		BiTreeNode<String> node5 = new BiTreeNode<>();
		node5.setData("B");
		BiTreeNode<String> node6 = new BiTreeNode<>();
		node6.setData("C");
		BiTreeNode<String> node7 = new BiTreeNode<>();
		node7.setData("D");
		BiTreeNode<String> node8 = new BiTreeNode<>();
		node8.setData("E");

		root.setlChild(node1);
		root.setrChild(node2);
		node1.setlChild(node3);
		node1.setrChild(node6);
		node3.setlChild(node4);
		node3.setrChild(node5);
		node2.setlChild(node7);
		node2.setrChild(node8);

		BiTree<String> biTree = new BiTree<>();
		biTree.setRoot(root);

		// 先序遍历
		biTree.preRootTraverse(root);
		System.out.println();
		biTree.preRootTraverse();

		System.out.println();
		// 中序遍历
		biTree.inRootTraverse(root);
		System.out.println();
		biTree.inRootTraverse();

		System.out.println();
		// 后序遍历
		biTree.postRootTraverse(root);
		System.out.println();
		biTree.postRootTraverse();

		// 层次遍历
		System.out.println();
		biTree.levelTRaverse();
	}

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
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {

	}

	/**用于记录preStr的索引值*/
	private static int index = 0;

	/**
	 * 由标明空子树的先序遍历序列创建一颗二叉树的算法
	 * @param preStr 
	 * @author 巫威  
	 * @date 2020-08-17 21:20 
	 */
	public BiTree(String preStr) {

	}

	/**
	 * 先序遍历二叉树基本操作的递归算法
	 * @param t 
	 * @author 巫威  
	 * @date 2020-08-17 21:23 
	 */
	public void preRootTraverse(BiTreeNode<E> t) {
		if (t != null) {
			// 访问根节点
			System.out.print(t.getData() + " ");
			// 先序遍历左子树
			preRootTraverse(t.getlChild());
			// 先序遍历右子树
			preRootTraverse(t.getrChild());
		}
	}

	/**
	 * 先序遍历二叉树基本操作的非递归算法
	 * 时间复杂度 O(n)
	 * @author 巫威  
	 * @date 2020-08-17 21:24 
	 */
	public void preRootTraverse() {
		Stack<BiTreeNode> stack = new Stack<>();
		if (root == null) {
			return;
		}
		stack.push(root);
		BiTreeNode<E> biTreeNode = null;
		while (!stack.isEmpty()) {
			biTreeNode = stack.pop();
			System.out.print(biTreeNode.getData() + " ");
			if (biTreeNode.getrChild() != null) {
				stack.push(biTreeNode.getrChild());
			}
			while ((biTreeNode = biTreeNode.getlChild()) != null) {
				System.out.print(biTreeNode.getData() + " ");
				BiTreeNode<E> rChild = biTreeNode.getrChild();
				if (rChild != null) {
					stack.push(rChild);
				}
			}
		}
	}

	/**
	 * 中序遍历二叉树基本操作的递归算法
	 * @param t 
	 * @author 巫威  
	 * @date 2020-08-17 21:23 
	 */
	public void inRootTraverse(BiTreeNode<E> t) {
		if (t != null) {
			// 中序遍历左子树
			inRootTraverse(t.getlChild());
			// 访问根节点
			System.out.print(t.getData() + " ");
			// 中序遍历右子树
			inRootTraverse(t.getrChild());
		}
	}

	/**
	 * 中序遍历二叉树基本操作的非递归算法
	 * 时间复杂度 O(n)
	 * @author 巫威  
	 * @date 2020-08-17 21:24 
	 */
	public void inRootTraverse() {
		BiTreeNode<E> biTreeNode = root;
		if (biTreeNode == null) {
			return;
		}
		Stack<BiTreeNode> stack = new Stack();
		stack.push(biTreeNode);
		while (!stack.isEmpty()) {
			while (stack.peek() != null) {
				stack.push(stack.peek().getlChild());
			}
			stack.pop();
			if (!stack.isEmpty()) {
				BiTreeNode<E> node = stack.pop();
				System.out.print(node.getData() + " ");
				stack.push(node.getrChild());
			}
		}
	}

	/**
	 * 后序遍历二叉树基本操作的递归算法
	 * @param t 
	 * @author 巫威  
	 * @date 2020-08-17 21:23 
	 */
	public void postRootTraverse(BiTreeNode<E> t) {
		if (t != null) {
			// 后序遍历左子树
			postRootTraverse(t.getlChild());
			// 后序遍历右子树
			postRootTraverse(t.getrChild());
			// 访问根节点
			System.out.print(t.getData() + " ");
		}
	}

	/**
	 * 后序遍历二叉树基本操作的非递归算法
	 * 时间复杂度 O(n)
	 * @author 巫威  
	 * @date 2020-08-17 21:24 
	 */
	public void postRootTraverse() {
		BiTreeNode<E> biTreeNode = root;
		if (biTreeNode == null) {
			return;
		}
		Stack<BiTreeNode> stack = new Stack<>();
		stack.push(biTreeNode);
		boolean flag;
		BiTreeNode<E> p = null;
		while (!stack.isEmpty()) {
			while (stack.peek() != null) {
				stack.push(stack.peek().getlChild());
			}
			stack.pop(); // 空节点退栈
			while (!stack.isEmpty()) {
				biTreeNode = stack.peek();
				if (biTreeNode.getrChild() == null || biTreeNode.getrChild() == p) {
					System.out.print(biTreeNode.getData() + " ");
					stack.pop();
					p = biTreeNode;
					flag = true;
				} else {
					stack.push(biTreeNode.getrChild());
					flag = false;
				}
				if(!flag){
					break;
				}

			}
		}
	}

	/**
	 * 层次遍历二叉树基本操作的算法（自左向右）
	 * @param  
	 * @author 巫威  
	 * @date 2020-08-17 21:26 
	 */
	public void levelTRaverse() {

		BiTreeNode<E> biTreeNode = root;
		if(biTreeNode == null){
			return;
		}
		Queue<BiTreeNode> queue = new LinkedList<>();
		queue.add(biTreeNode);
		while(!queue.isEmpty()){
			biTreeNode = queue.poll();
			System.out.print(biTreeNode.getData() + " ");
			if(biTreeNode.getlChild() != null){
				queue.add(biTreeNode.getlChild());
			}
			if(biTreeNode.getrChild() != null){
				queue.add(biTreeNode.getrChild());
			}
		}

	}

	public BiTreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode<E> root) {
		this.root = root;
	}
}
