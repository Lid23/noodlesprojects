package com.noodles.stream.bean;

/**
 * @filename Student
 * @description Student
 * @author 巫威
 * @date 2019/7/25 15:14
 */
public class Student {

	private String name;

	private int age;

	private String certNo;

	public Student(String name, int age, String certNo) {
		this.name = name;
		this.age = age;
		this.certNo = certNo;
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

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}
