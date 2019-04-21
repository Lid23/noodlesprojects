package com.noodles.java8.basics.behaviorparameterization;

import com.noodles.java8.beans.Apple;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*

 */
public class FilteringApplesByStream {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple(10, "green"), new Apple(100, "green"),
                new Apple(120, "red"));

        //顺序处理 stream
        List<Apple> heavyApples = appleList.stream().filter((Apple apple) -> apple.getWeight() > 100).collect(toList());

        //并行处理
        List<Apple> heavyApples1 = appleList.parallelStream().filter((Apple apple) -> apple.getWeight() > 100).collect(
                toList());

    }
    


}
