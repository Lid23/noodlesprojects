package com.noodles.java8.bean;
public  class Trader{

	/**姓名*/
	private String name;

	/**所属城市*/
	private String city;

	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}

	public String getName(){
		return this.name;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String newCity){
		this.city = newCity;
	}

	public String toString(){
		return "Trader:"+this.name + " in " + this.city;
	}
}