package com.noodles.collections;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Cat implements Serializable {
	private String cat;

	public Cat(String name) {
		cat = name;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
}

public class CopyList {
	public static void main(String[] args) throws Exception {
		ArrayList<Cat> list = new ArrayList<Cat>();
		list.add(new Cat("a"));
		list.add(new Cat("b"));
		// 用原有集合创建新集合
		List<Cat> listCopy = deepcopy(list);

		//Collections.copy(listCopy, list);
		System.out.println(list.get(0) == listCopy.get(0));
		listCopy.add(new Cat("c"));
		for (Cat s : listCopy) {
			System.out.println("listCopy:" + s + "--cat:" + s.getCat());
		}
		for (Cat s : list) {
			System.out.println("list:" + s + "--cat:" + s.getCat());
		}
		System.out.println("listCopy:" + listCopy);
		System.out.println("list:" + list);
	}

	public static <T> List<T> deepcopy(List<T> src) throws Exception {
		ByteArrayOutputStream byteout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteout);
		out.writeObject(src);
		ByteArrayInputStream bytein = new ByteArrayInputStream(byteout.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bytein);
		List<T> dest = (List) in.readObject();
		out.close();
		in.close();
		return dest;
	}
} 