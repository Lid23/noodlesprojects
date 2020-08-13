package com.noodles.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

import com.noodles.datastructure.LinkedList.LinkNode;

/**
 * @filename PrintListFromTailToHead
 * @description 从尾到头打印链表
 * @link https://cyc2018.github.io/CS-Notes/#/notes/6.%20从尾到头打印链表
 * @author 巫威
 * @date 2020/8/13 11:13
 */
public class PrintListFromTailToHead {

	public static void main(String[] args) {

		LinkNode<Integer> linkNode = new LinkNode<>();
	}

	/**
	 * 递归实现 TODO 复杂度 O(2ⁿ)
	 * LinkedList做链表
	 * @param linkNode
	 * @author 巫威
	 * @date 2020/8/13 11:27
	 */
	public static ArrayList<Integer> printListFromTailToHead(LinkNode<Integer> linkNode){
		ArrayList<Integer> ret = new ArrayList<>();
		if (linkNode != null) {
			ret.addAll(printListFromTailToHead(linkNode.next));
			ret.add(linkNode.item);
		}
		return ret;
	}
}
