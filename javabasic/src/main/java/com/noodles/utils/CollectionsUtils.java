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
	
	/**
	 * List去除重复的数据
	 * @param stringList
	 * @return java.util.List<java.lang.String>
	 * @author 巫威
	 * @date 2020/12/28 17:44
	 */
	public static List<String> removeStringListDup(List<String> stringList) {
	    Set<String> set = new LinkedHashSet<>();
	    set.addAll(stringList);

	    stringList.clear();

	    stringList.addAll(set);
	    
	    return stringList;
	}
	

}
