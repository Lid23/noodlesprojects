package com.noodles.javabasis.classtest;

import java.io.FileNotFoundException;

/**
 * @filename CustomerClassLoader
 * @description 一个简单的类加载器实现的示例
 * @author 巫威
 * @date 2020/1/6 13:38
 */
public class CustomerClassLoader extends ClassLoader{

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] result = getClassFromCustomerPath(name);
			if(result == null){
				throw new FileNotFoundException();
			}else{
				return defineClass(name, result, 0, result.length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		throw new ClassNotFoundException(name);
	}

	private byte[] getClassFromCustomerPath(String name){
		/**自定义路径中加载指定类*/
		return "test".getBytes();
	}

	public static void main(String[] args) {
		CustomerClassLoader customerClassLoader = new CustomerClassLoader();
		try {
			Class<?> clazz = Class.forName("One", true, customerClassLoader);
			Object obj = clazz.newInstance();
			System.out.println(obj.getClass().getClassLoader());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
