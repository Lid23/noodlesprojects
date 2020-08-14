package com.noodles.algorithm;

import java.util.ArrayList;
import java.util.Stack;

import com.noodles.gson.JsonUtil;

/**
 * @filename PrintListFromTailToHead
 * @description 从尾到头打印链表
 * @link https://cyc2018.github.io/CS-Notes/#/notes/6.%20从尾到头打印链表
 * @author 巫威
 * @date 2020/8/13 11:13
 */
public class PrintListFromTailToHead {

	public static void main(String[] args) {

		Node<Integer> node3 = new Node<>(3, null);
		Node<Integer> node2 = new Node<>(2, node3);
		Node<Integer> node1 = new Node<>(1, node2);

		ArrayList<Integer> arrayList1 = printListFromTailToHead1(node1);
		System.out.println(JsonUtil.toJson(arrayList1));

		ArrayList<Integer> arrayList2 = printListFromTailToHead1(node1);
		System.out.println(JsonUtil.toJson(arrayList2));

		ArrayList<Integer> arrayList3 = printListFromTailToHead3(node1);
		System.out.println(JsonUtil.toJson(arrayList3));
	}

	/**
	 * 递归实现 TODO 复杂度 O(2ⁿ)
	 * LinkedList做链表
	 * @param linkNode
	 * @author 巫威
	 * @date 2020/8/13 11:27
	 */
	public static ArrayList<Integer> printListFromTailToHead1(Node<Integer> linkNode){
		ArrayList<Integer> ret = new ArrayList<>();
		if (linkNode != null) {
			ret.addAll(printListFromTailToHead1(linkNode.next));
			ret.add(linkNode.item);
		}
		return ret;
	}

	/**
	 * 压栈处理
	 * @param linkNode
	 * @return java.util.ArrayList<java.lang.Integer>
	 * @author 巫威
	 * @date 2020/8/14 9:51
	 */
	public static ArrayList<Integer> printListFromTailToHead2(Node<Integer> linkNode){
		Stack<Integer> stack = new Stack();
		while (linkNode != null) {
			stack.push(linkNode.item);
			linkNode = linkNode.next;
		}

		ArrayList<Integer> ret = new ArrayList<>();
		while(!stack.isEmpty()){
			ret.add(stack.pop());
		}
		return ret;
	}

	/**
	 * 链表头插法
	 * @param linkNode
	 * @return java.util.ArrayList<java.lang.Integer>
	 * @author 巫威
	 * @date 2020/8/14 9:51
	 */
	public static ArrayList<Integer> printListFromTailToHead3(Node<Integer> linkNode){
		Node<Integer> head = new Node<>();
		while(linkNode != null) {
			Node memo = linkNode.next;
			linkNode.next = head.next;
			head.next = linkNode;
			linkNode = memo;
		}

		ArrayList<Integer> ret = new ArrayList<>();
		head = head.next;
		while (head != null) {
			ret.add(head.item);
			head = head.next;
		}
		return ret;
	}

	public static class Node<E> {
		E item;
		Node<E> next;

		Node(){}

		Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}
}
