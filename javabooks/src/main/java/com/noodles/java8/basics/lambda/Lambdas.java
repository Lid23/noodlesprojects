package com.noodles.java8.basics.lambda;

import com.noodles.java8.beans.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {
	public static void main(String ...args){

		// Simple example
		String str = "Hello";
		Runnable r = () -> System.out.println(str);
		//str = "";
		r.run();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello");
			}
		};
		r1.run();

		process(r);

		// Filtering with lambdas
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]	
		List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
		System.out.println(greenApples);


		Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

		// [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
		inventory.sort(c);
		System.out.println(inventory);

		List<String> stringList = Arrays.asList( "1", "q");
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmpty = filter(stringList, nonEmptyStringPredicate);

		forEach(Arrays.asList(1,3,4,5), (Integer i) -> System.out.println(i));

		List<Integer> l = map(Arrays.asList("lambda", "Eric", "stream"), (String s) -> s.length());


	}

	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}

	interface ApplePredicate{
		public boolean test(Apple a);
	}

	public static void process(Runnable r){
		r.run();
	}


	/*
	T -> boolean
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T e : list){
			if(p.test(e)){
				result.add(e);
			}
		}
		return result;
	}


	/*
	T -> void
	 */
	public static <T> void forEach(List<T> list, Consumer<T> c){
		for(T i : list){
			c.accept(i);
		}
	}

	/*
	T -> R
	 */
	public static <T, R> List<R> map(List<T> list, Function<T, R> f){
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}

}