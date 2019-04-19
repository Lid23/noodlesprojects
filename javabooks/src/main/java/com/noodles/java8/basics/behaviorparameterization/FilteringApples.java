package com.noodles.java8.basics.behaviorparameterization;

import nod.java8.commons.beans.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*

 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple(10, "green"), new Apple(100, "green"),
                new Apple(120, "red"));

        List<Apple> greenAppleList =  filterGreenApples(appleList);
        System.out.println(greenAppleList);

        List<Apple> heavyAppleList =  filterHeavyApples(appleList);
        System.out.println(heavyAppleList);

        List<Apple> greenAppleList2 = filterApples(appleList, (Apple apple) -> "green".equals(apple.getColor()));
        List<Apple> greenAppleList3 =  filterApples(appleList, FilteringApples::isGreenApple);
        System.out.println(greenAppleList2);

        List<Apple> heavyAppleList2 = filterApples(appleList, apple -> apple.getWeight() > 100);
        List<Apple> heavyAppleList3 =  filterApples(appleList, FilteringApples::isHeavyApple);
        System.out.println(heavyAppleList2);

        List<Apple> weirdApples = filterApples(appleList, (Apple a) -> a.getWeight() < 80 ||
                "brown".equals(a.getColor()));
        System.out.println(weirdApples);
    }
    
    /*
    * @Author: Eric
    * @Description: 过滤绿苹果
    * @Date:2018/1/16 17:48
    */
    public static List<Apple> filterGreenApples(List<Apple> appleList){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : appleList){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /*
    * @Author: Eric
    * @Description:过滤重苹果
    * @Date:2018/1/16 17:50
    */
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 100) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 100;
    }

    public static List<Apple> filterApples(List<Apple> appleList, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : appleList){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

}
