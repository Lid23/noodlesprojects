package com.noodles.gson.bean;

/**
 * 文件名：ResultData.java
 * 描述：
 * 作者：FA00118
 * 日期：2017年4月21日下午1:32:57
 */
public class ResultData<T, V> {
	
	private String retCode;
	
	private String retMsg;
	
	private T headData;
	
	private V bodyData;

	public T getHeadData() {
		return headData;
	}

	public void setHeadData(T headData) {
		this.headData = headData;
	}

	public V getBodyData() {
		return bodyData;
	}

	public void setBodyData(V bodyData) {
		this.bodyData = bodyData;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

}
