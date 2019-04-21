package com.noodles.java8.basics.lambda;

import com.noodles.java8.beans.Apple;
import com.noodles.java8.beans.Fruit;
import com.noodles.java8.beans.Orange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用重复使用现有的方法定义，像lambda一样传递他们
 * 可读性
 * */
public class MethodReference {
    public static void main(String[] args) {
        /**方法引用例子*/
        Function<Apple, Integer> fLamb = a -> a.getWeight();
        Function<Apple, Integer> fModRef = Apple::getWeight;

        /**1. 指向静态方法的方法引用**/
        Function<String, Integer> ff = Integer::parseInt;

        /**2. 指向类实例方法的方法引用**/
        List<String> strs = Arrays.asList("a", "b", "c", "d");
        strs.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        strs.sort(String::compareToIgnoreCase);

        /**3. 指向现有对象的实例方法的方法引用**/

        /**4. 构造函数引用**/
        //构造函数引用指向默认的构造函数
        Supplier<Apple> s1 = Apple::new;
        Apple a1 = s1.get();
        Function<Integer, Apple> f2 = Apple::new;
        Apple a2 = f2.apply(100);

        //不将构造函数实例化却能够引用他，这个功能有一些有趣的应用

    }

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();
    static{
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static Fruit getMeFruit(String fruit, Integer weight){
        return map.get(fruit).apply(weight);
    }
}
