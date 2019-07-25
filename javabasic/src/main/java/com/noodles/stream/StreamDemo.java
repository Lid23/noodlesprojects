package com.noodles.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.noodles.stream.bean.Student;

/**
 * @filename StreamDemo
 * @description StreamDemo
 * @author 巫威
 * @date 2019/7/25 15:01
 */
public class StreamDemo {

	public static void main(String[] args) {
		Student student1 = new Student("张三",15, "123");
		Student student2 = new Student("李四",15, "123");
		Student student3 = new Student("刘五",16, "234");

		List<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);

		Optional<Student> studentMaxAge = studentList.stream().max(Comparator.comparing(Student::getAge));
		List<Student> students = studentList.stream().filter(student -> student.getAge() == studentMaxAge.get().getAge()).collect(Collectors.toList());

		System.out.println(students.size());


		//去重
		Set<String> set  = new HashSet<>();
		List<Student> students1 = studentList.stream().filter(t -> set.add(t.getCertNo())).collect(Collectors.toList());
		students1.stream().forEach(student -> student.setName("hello"));
		for(Student student : students1){
			System.out.println(student.getName());
		}
	}

}
