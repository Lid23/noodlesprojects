package com.noodles.datastructure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import EDU.oswego.cs.dl.util.concurrent.LinkedQueue;
import com.noodles.gson.JsonUtil;

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
	 * @param preOrder 整棵树的先序遍历序列
	 * @param inOrder 整棵树的后序遍历序列
	 * @param preIndex 先序遍历序列在preOrder中的开始位置
	 * @param inIndex 中序遍历序列在inOrder中的开始位置
	 * @param count  树中节点的个数
	 * @author 巫威  
	 * @date 2020-08-17 21:17 
	 */
	public BiTree(E[] preOrder, E[] inOrder, int preIndex, int inIndex, int count) {
		if (count <= 0) {
			return;
		}
		E node = preOrder[preIndex];
		int i = 0;
		for (; i < count; i++) {
			if (node.equals(inOrder[i+inIndex])) {
				break;
			}
		}
		root = new BiTreeNode(node);
		root.setlChild(new BiTree<E>(preOrder, inOrder, preIndex + 1, inIndex, i).root);
		root.setrChild(new BiTree<E>(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root);
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

	public BiTreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode<E> root) {
		this.root = root;
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
				if (!flag) {
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
		if (biTreeNode == null) {
			return;
		}
		Queue<BiTreeNode> queue = new LinkedList<>();
		queue.add(biTreeNode);
		while (!queue.isEmpty()) {
			biTreeNode = queue.poll();
			System.out.print(biTreeNode.getData() + " ");
			if (biTreeNode.getlChild() != null) {
				queue.add(biTreeNode.getlChild());
			}
			if (biTreeNode.getrChild() != null) {
				queue.add(biTreeNode.getrChild());
			}
		}

	}

	/**
	 * 根据节点值查找二叉树节点
	 * @param t
	 * @param x
	 * @return com.noodles.datastructure.tree.BiTreeNode<E>
	 * @author 巫威
	 * @date 2020/9/7 10:18
	 */
	public BiTreeNode<E> searchNode(BiTreeNode<E> t, E x) {
		if (t == null) {
			return null;
		}
		if (t.getData().equals(x)) {
			return t;
		} else {
			BiTreeNode<E> lResult = searchNode(t.getlChild(), x);
			return lResult == null ? searchNode(t.getrChild(), x) : lResult;
		}
	}

	/**
	 * 先序递归遍历统计二叉树节点个数
	 * @param t
	 * @return int
	 * @author 巫威
	 * @date 2020/9/7 10:26
	 */
	public int countNode(BiTreeNode<E> t) {
		int count = 0;
		if (t != null) {
			++count;
			count += countNode(t.getlChild());
			count += countNode(t.getrChild());
		}
		return count;
	}

	/**
	 * 层次遍历统计二叉树节点个数
	 * @param t
	 * @return int
	 * @author 巫威
	 * @date 2020/9/10 9:23
	 */
	public int countNode1(BiTreeNode<E> t) {
		int count = 0;
		BiTreeNode<E> biTreeNode = root;
		if (biTreeNode == null) {
			return count;
		}
		Queue<BiTreeNode> queue = new LinkedList<>();
		queue.add(biTreeNode);
		while (!queue.isEmpty()) {
			biTreeNode = queue.poll();
			++count;
			if (biTreeNode.getlChild() != null) {
				queue.add(biTreeNode.getlChild());
			}
			if (biTreeNode.getrChild() != null) {
				queue.add(biTreeNode.getrChild());
			}
		}

		return count;
	}

	/**
	 * 递归求二叉树深度
	 * @param t
	 * @return int
	 * @author 巫威
	 * @date 2020/9/10 9:29
	 */
	public int getDepth(BiTreeNode<E> t) {
		if (t == null) {
			return 0;
		}
		int lDepth = getDepth(t.getlChild());
		int rDepth = getDepth(t.getrChild());
		return (lDepth > rDepth ? lDepth : rDepth) + 1;
	}

	/**
	 * 判断两棵二叉树是否相等
	 * @param t1
	 * @param t2
	 * @return boolean
	 * @author 巫威
	 * @date 2020/9/10 9:51
	 */
	public boolean isEqual(BiTreeNode<E> t1, BiTreeNode<E> t2) {
		if (t1 == null && t2 == null) {
			return true;
		}

		if (t1 != null && t2 != null) {
			if (t1.getData().equals(t2.getData())) {
				if (isEqual(t1.getlChild(), t2.getlChild()) && isEqual(t1.getrChild(), t2.getrChild())) {
					return true;
				}
			}
		}
		return false;
	}

}
