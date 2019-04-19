package com.noodles.utils;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

/**
 * 文件名：PrintUtil.java
 * 描述：
 * 作者：FA00118
 * 日期：2017年4月21日上午11:07:49
 */
public class PrintUtil {
	
	public static void printList(List<?> list){
		for(Object obj : list){
			if(obj != null){
				System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE));
			}
		}
	}
	
	public static void printArray(Object[] arr){
		for(Object obj : arr){
			
			System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE));
			
			/*if(obj != null){
				if(obj instanceof String){
					System.out.println(obj);
				}else{
					System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.SIMPLE_STYLE));
				}
			}*/
		}
	}
	
	public static void printObject(Object obj){
		if(obj != null){
			System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE));
		}
	}
	
	public static void printString(String str){
		System.out.println(str);
	}
}
