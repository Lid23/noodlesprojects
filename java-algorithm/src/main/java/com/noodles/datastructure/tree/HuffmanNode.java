package com.noodles.datastructure.tree;

/**
 * @filename HuffmanNode
 * @description 哈夫曼树节点
 * @author 巫威
 * @date 2020/9/11 14:58
 */
public class HuffmanNode {

	/**结点的权值*/
	private int weight;

	/**结点是否加入哈夫曼树的标志*/
	private int flag;

	/**父结点，左孩子结点，右孩子结点*/
	private HuffmanNode parent, lchild, rchild;

	public HuffmanNode(int weight) {
		this.weight = weight;
		flag = 0;
		parent = lchild = rchild = null;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public HuffmanNode getParent() {
		return parent;
	}

	public void setParent(HuffmanNode parent) {
		this.parent = parent;
	}

	public HuffmanNode getLchild() {
		return lchild;
	}

	public void setLchild(HuffmanNode lchild) {
		this.lchild = lchild;
	}

	public HuffmanNode getRchild() {
		return rchild;
	}

	public void setRchild(HuffmanNode rchild) {
		this.rchild = rchild;
	}
}
