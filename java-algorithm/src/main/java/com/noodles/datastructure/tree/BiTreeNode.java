package com.noodles.datastructure.tree;

/**
 * @filename BiTreeNode
 * @description 二叉树链式存储结构
 * @author 巫威
 * @date 2020-08-17 21:11
 */
public class BiTreeNode<E> {

	private E data;

	private BiTreeNode<E> lChild, rChild;

	public BiTreeNode() {
	}

	public BiTreeNode(E data) {
		this.data = data;
	}

	public BiTreeNode(E data, BiTreeNode<E> lChild, BiTreeNode<E> rChild) {
		this.data = data;
		this.lChild = lChild;
		this.rChild = rChild;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BiTreeNode<E> getlChild() {
		return lChild;
	}

	public void setlChild(BiTreeNode<E> lChild) {
		this.lChild = lChild;
	}

	public BiTreeNode<E> getrChild() {
		return rChild;
	}

	public void setrChild(BiTreeNode<E> rChild) {
		this.rChild = rChild;
	}
}
