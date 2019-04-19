package com.noodles.java8.basics.lambda;

import nod.java8.commons.beans.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class ComplexLambda {

    public static void main(String[] args) {
        /**复合lambda-多个简单的lambda可以复合成复杂的表达式，比如，可以让
         * 两个谓词做一个or操作，组合成一个更大的谓词，也可以让一个函数的结果成为另一个函数的输入
         * --默认方法*/

        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"),
                new Apple(120, "red")));

        /**比较器复合*/
        Comparator<Apple> c = comparing(Apple::getWeight);

        /**逆序*/
        inventory.sort(comparing(Apple::getWeight).reversed());

        /**比较器链*/
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));

        /***谓词复合*/
        Predicate<Apple> redApple = a -> "red".equals(a.getColor());
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> heavyApple = a -> a.getWeight() > 100;
        Predicate<Apple> redAndHeavyApple = redApple.and(heavyApple);


        /**函数复合*/
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        //g(f(x))
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);

        //f(g(x))
        Function<Integer, Integer> h1 = f.compose(g);
        int result2 = h1.apply(1);



    }
}
