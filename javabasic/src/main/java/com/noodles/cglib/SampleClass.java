package com.noodles.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 文件名：SampleClass.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年10月18日上午9:12:32
 */
public class SampleClass {

	public void test(int i){
		System.out.println("Hello Nancy " + i);
	}

	public static void main(String args[]){
		for(int i = 0; i<100000; i++){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(SampleClass.class);
			enhancer.setCallback(new MethodInterceptor(){

				@Override
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					// System.out.println("Before method run");
					Object result = proxy.invokeSuper(obj, args);
					// System.out.println("After method run");
					return result;
				}

			});

			SampleClass proxy = (SampleClass)enhancer.create();
			System.out.println(proxy.toString());
		}
	}
	
}
