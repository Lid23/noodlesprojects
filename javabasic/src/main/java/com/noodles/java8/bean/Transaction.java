package com.noodles.java8.bean;

import java.io.Serializable;

/**
 * 交易定义
 * @filename Transaction
 * @author 巫威
 * @date 2019/8/29 11:26
 */
public class Transaction implements Serializable {

	private static final long serialVersionUID = 561897109930552386L;
	/**交易金额*/
	private Double price;

	/**交易货币*/
	private String currency;

	public Transaction(Double price, String currency){
		this.price = price;
		this.currency = currency;
	}

	public Transaction(){}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String toString(){
	    return "{" + this.price + ", " +
	           "year: "+this.currency +"}";
	}
}