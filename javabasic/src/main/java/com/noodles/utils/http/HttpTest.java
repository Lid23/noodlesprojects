package com.noodles.utils.http;

import org.junit.Test;

import java.util.HashMap;

/**
 * 文件名：HttpTest.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年11月10日上午10:11:42
 */
public class HttpTest {
	
	@Test
	public void testJsoupExecuteAsBytes(){
		try {
			JsoupUtil.executeAsBytes("http://www.baidu.com", new HashMap<String, String>());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJsoupExecuteAsString(){
		try {
			JsoupUtil.executeAsString("http://www.baidu.com", new HashMap<String, String>());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJsoupExecuteAsString2(){
		try {
			String result = JsoupUtil.executeAsString("http://www.baidu.com", "application/json;charset=utf-8",
					"aaaa");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
