package com.noodles.cglib;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 文件名：CglibBean.java
 * 描述：动态生成Bean，建立一个动态实体bean，使用cglib动态添加属性和相应的get，set方法
 * 作者：KJ00019
 * 日期：2017年10月17日下午3:39:24
 */
public class CglibBean {
	
	public Object object = null;
	
	public BeanMap beanMap = null;
	
	public CglibBean(){
		super();
	}
	
	@SuppressWarnings("unchecked")
	public CglibBean(Map propertyMap){
		this.object = generateBean(propertyMap);
		this.beanMap = BeanMap.create(this.object);
	}
	
	/**
	 * 给bean属性赋值
	 * @param property
	 * @param value
	 * 作者：KJ00019
	 * 日期：2017年10月17日下午3:49:09
	 */
	public void setValue(String property, Object value){
		beanMap.put(property, value);
	}
	
	/**
	 * 通过属性名得到属性值
	 * @param property
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年10月17日下午3:49:38
	 */
	public Object getValue(String property){
		return beanMap.get(property);
	}
	
	/**
	 * 得到实体Bean对象
	 * @return
	 * 作者：KJ00019
	 * 日期：2017年10月17日下午3:49:59
	 */
	public Object getObject(){
		return this.object;
	}
	
	@SuppressWarnings("unchecked")
	private Object generateBean(Map propertyMap){
		BeanGenerator generator = new BeanGenerator();
		Set keySet = propertyMap.keySet();
		for(Iterator i = keySet.iterator(); i.hasNext();){
			String key = (String)i.next();
			generator.addProperty(key, (Class)propertyMap.get(key));
		}
		return generator.create();
		
	}
	
}
