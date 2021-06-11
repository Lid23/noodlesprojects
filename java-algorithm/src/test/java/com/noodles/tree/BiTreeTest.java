package com.noodles.tree;

import com.noodles.datastructure.tree.BiTree;
import com.noodles.datastructure.tree.BiTreeNode;
import com.noodles.json.utils.JsonUtils;

/**
 * @filename BiTree
 * @description 二叉树
 * @author 巫威
 * @date 2020-08-17 21:14
 */
public class BiTreeTest<E> {

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

		System.out.println();
		BiTreeNode<String> searchNode = biTree.searchNode(root, "+");
		System.out.println(JsonUtils.toJson(searchNode));

		System.out.println("递归遍历树的结点数量：" + biTree.countNode(root));
		System.out.println("层次遍历树的结点数量：" + biTree.countNode1(root));
		System.out.println("树的深度：" + biTree.getDepth(root));

		System.out.println("根据先序和中序序列建立一颗二叉树");
		String[] preOrder = new String[] { "A", "B", "D", "E", "G", "C", "F", "H" };
		String[] inOrder = new String[] { "D", "B", "G", "E", "A", "F", "H", "C" };
		BiTree<String> biTree1 = new BiTree<>(preOrder, inOrder, 0, 0, preOrder.length);
		System.out.println(JsonUtils.toJson(biTree1));
		System.out.print("建立的二叉树的后序遍历为：");
		biTree1.postRootTraverse();
	}

}
