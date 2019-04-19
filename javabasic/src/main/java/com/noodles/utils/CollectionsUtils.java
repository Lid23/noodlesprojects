package com.noodles.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 文件名：CollectionsUtils.java
 * 描述：
 * 作者：KJ00019
 * 日期：2018年3月19日下午4:44:43
 */
public class CollectionsUtils {
	
	
	public static List<String> removeStringListDup(List<String> stringList) {
	    Set<String> set = new LinkedHashSet<>();
	    set.addAll(stringList);

	    stringList.clear();

	    stringList.addAll(set);
	    
	    return stringList;
	}
	
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("P2P552834");
		list.add("P2P978070");
		list.add("P2P978070");
		System.out.println(list);
		System.out.println(removeStringListDup(list));
	}
}
