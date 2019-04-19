package com.noodles.utils;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	public static void main(String args[]){
		String ss = null;
		
		String s = StringUtils.trimToEmpty(ss);
		
		boolean flag = StringUtils.isNotBlank(ss);
		
		
		System.out.println(s);
	}
	
	public static String replacePlaceholderString(String paramsValue, String paramsContent, String replaceFlag) {
		String paramsString = paramsContent;
		if (StringUtils.isNotEmpty(paramsValue) && StringUtils.isNotEmpty(paramsContent)) {
			String[] templateParamsArr = paramsValue.split(",");
			for (String templateParam : templateParamsArr) {
				paramsString = paramsString.replaceFirst(replaceFlag, templateParam);
			}
		}
		return paramsString;
	}
}
