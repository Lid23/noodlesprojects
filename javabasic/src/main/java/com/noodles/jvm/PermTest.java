package com.noodles.jvm;

import com.noodles.cglib.SampleClass;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 文件名：Permtest.java
 * 描述：使用Cglib库生成大量的动态类
 * 作者：KJ00019
 * 日期：2017年10月17日下午3:13:20
 */
public class PermTest {
	
	public static void main(String args[]){
		int i = 0;
		try{
			for(i = 0; i<10000; i++){
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
				proxy.test(i);
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Total create count:" + i);
		}
	}
}
