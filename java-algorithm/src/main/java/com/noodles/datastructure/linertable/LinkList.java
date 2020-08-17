package com.noodles.datastructure.linertable;

/**
 * @filename LinkList
 * @description 单链表
 * @author 巫威
 * @date 2020-08-13 22:57
 */
public class LinkList<E> implements IList<E> {

	//头指针
	private Node<E> head;

	public LinkList() {
		head = new Node<E>();
	}

	public LinkList(int n, boolean order) {
		this();
		if(order){
			// 尾插法顺序建立单链表
			tailCreate(n);
		} else {
			// 头插法逆序建立单链表
			headCreate(n);
		}
	}

	public void tailCreate(int n){

	}

	public void headCreate(int n){

	}

	@Override
	public void clear() {

	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public E get(int i) {
		return null;
	}

	@Override
	public void insert(E e) {

	}

	@Override
	public void remove(int i) {

	}

	@Override
	public int indexOf(E e) {
		return 0;
	}

	@Override
	public void display() {

	}

	private static class Node<E> {
		E item;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.item = element;
			this.next = next;
		}

		public Node() {
			this(null, null);
		}

		public Node(E element) {
			this.item = element;
		}

		public E getItem() {
			return item;
		}

		public void setItem(E item) {
			this.item = item;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

}
