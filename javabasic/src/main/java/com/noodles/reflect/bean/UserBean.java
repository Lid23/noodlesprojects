package com.noodles.reflect.bean;

/**
 * 文件名：UserBean.java
 * 描述：
 * 作者：KJ00019
 * 日期：2017年9月12日上午11:21:21
 */
public class UserBean {
	private String name;
	
	private String address;
	
	private String mobileNo;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setMobileNo(String mobileNo){
		this.mobileNo = mobileNo;
	}
	
	public String getMobileNo(){
		return this.mobileNo;
	}
}
