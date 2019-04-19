package com.noodles.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import noodles.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class GsonBasicUsage {
	public static void main(String args[]){
		Gson gson = new Gson();
		
		/**基本数据类型的解析*/
		int i = gson.fromJson("100", int.class);
		double d = gson.fromJson("99.99", double.class);
		boolean b = gson.fromJson("true", boolean.class);
		String str = gson.fromJson("String", String.class);
		
		System.out.println("i = " + i);
		System.out.println("d = " + d);
		System.out.println("b = " + b);
		System.out.println("str = " + str);
		
		/**基本数据类型的生成*/
		String jsonNumber = gson.toJson(100);       // 100
		String jsonBoolean = gson.toJson(false);    // false
		String jsonString = gson.toJson("String"); //"String"
		
		System.out.println("jsonNumber = " + jsonNumber);
		System.out.println("jsonBoolean = " + jsonBoolean);
		System.out.println("jsonString = " + jsonString);
		
		/**POJO类的生成与解析*/
		User user = new User("Eric", 20, "test@163.com");
		String jsonUser = gson.toJson(user);
		System.out.println(jsonUser);
		
		//解析json
		User userFromJson = gson.fromJson(jsonUser, User.class);
		PrintUtil.printObject(userFromJson);
		
		/**属性重命名 @SerializedName 注解的使用*/
		String jsonStr = "{'name':'怪盗kidou','age':24,'email':'ikidou@example.com'}";
		User user1 = gson.fromJson(jsonStr, User.class);
		PrintUtil.printObject(user1);
		
		/**Gson中使用泛型*/
		//json字符串数组
		Gson gsonArr = new Gson();
		String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
		String[] strings = gsonArr.fromJson(jsonArray, String[].class);
		
		PrintUtil.printArray(strings);
		
		//使用list
		Gson gsonList = new Gson();
		String jsonList = "[\"Android\",\"Java\",\"PHP\"]";
		List<String> stringList = gsonList.fromJson(jsonList, new TypeToken<List<String>>() {}.getType());
		PrintUtil.printList(stringList);
		
		
		//
		User u1 = new User("a", 5, "asd");
		User u2 = new User("a", 5, "asd");
		User u3 = new User("a", 5, "asd");
		
		List<User> listUser = new ArrayList<User>();
		listUser.add(u1);
		listUser.add(u2);
		listUser.add(u3);
		
		PrintUtil.printString(gson.toJson(listUser));
		
		List<User> list = gson.fromJson(gson.toJson(listUser), new TypeToken<List<User>>() {}.getType());
		
		PrintUtil.printList(list);
		
	}
}

class User{
	
	private String name;
	
	private int age;
	
	@SerializedName(value = "emailAddress", alternate = {"email", "email_address"})
	private String emailAddress;
	
	public User(){
		
	}
	
	public User(String name, int age, String emailAddress){
		this.name = name;
		this.age = age;
		this.emailAddress = emailAddress;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	/**我行过许多地方的桥，看过许多次数的云，喝过许多种类的酒，却只爱过一个正当最好年龄的人。
	 * */
	
}
