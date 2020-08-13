package com.noodles.datastructure.LinkedList;

import java.util.LinkedList;

/**
 * @filename LinkNode
 * @description 链表节点定义
 * @author 巫威
 * @date 2020/8/13 20:40
 */
public class LinkNode<E> {
	public E item;
	public LinkNode<E> next;
	public LinkNode<E> prev;

	public LinkNode(){

	}

	public LinkNode(LinkNode<E> prev, E element, LinkNode<E> next) {
		this.item = element;
		this.next = next;
		this.prev = prev;
	}
}
