package com.noodles.datastructure.linertable;

/**
 * @filename IList
 * @description 线性表的抽象数据类型
 * @author 巫威
 * @date 2020-08-13 22:53
 */
public interface IList<E> {

	public void clear();

	public boolean isEmpty();

	public int length();

	public E get(int i);

	public void insert(E e);

	public void remove(int i);

	public int indexOf(E e);

	public void display();
}
