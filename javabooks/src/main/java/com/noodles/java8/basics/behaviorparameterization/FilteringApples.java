package com.noodles.java8.basics.behaviorparameterization;

import com.noodles.java8.beans.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * List集合操作
 * @filename FilteringApples
 * @author 巫威
 * @date 2019/8/27 11:04
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple(100, "green"), new Apple(10, "green"),
                new Apple(120, "red"));
        System.out.println("初始list:" + appleList);

		appleList.sort(comparing(Apple::getWeight));
		System.out.println("排序list:" + appleList);

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
    

    /**
    * @Description: 过滤绿苹果
    * @Param:
    * @return:
    * @Author: Eric
    * @Date: 2019-04-21
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

    /**
    * @Description: 过滤重苹果
    * @Param:
    * @return:
    * @Author: Eric
    * @Date: 2019-04-21
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
