package com.noodles.wildcards;

/**
 * @program: noodles-parent
 * @description: 泛型通配符测试
 * @author: Eric
 * @create: 2019-03-01 09:49
 **/
public class WildcardsTest {

    public static void main(String args[]){
        //装苹果的盘子 IS-NOT-A 装水果的盘子,无法编译通过
        // Plate<Fruit> plate = new Plate<Apple>(new Apple());

        Apple apple = new Apple();
        // 上界通配符:一个能放水果以及一切是水果派生类的盘子
        Plate<? extends Fruit> plate1 = new Plate<Apple>(new Apple());

        //上界通配符副作用会使set方法失效  error
        // plate1.set(apple);

        // 读取出来的东西只能存放在Fruit或它的基类里
        Fruit fruit1 = plate1.get();
        Object fruit2 = plate1.get();
        //Apple apple1 = plate1.get();  // error

        // 下界通配符:不影响往里存，但往外取只能放在Object对象里
        Plate<? super Fruit> plate2 = new Plate<Food>(new Food());
        plate2.set(new Fruit());
        plate2.set(new Apple());

        //Apple apple1 = plate2.get(); // error
        //Fruit fruit = plate2.get(); // error
        Object obj = plate2.get();

    }

}

class Food{}

class Fruit extends Food{}

class Meat extends Food{}

class Apple extends Fruit{}

class Banana extends Fruit{}

class Pork extends Meat{}

class Beaf extends Meat{}

class RedApple extends Apple{}

class GreenApple extends Apple{}

/** 
* @Description: 盘子 
* @Param:  
* @return:  
* @Author: Eric
* @Date: 2019/3/1 
*/
class Plate<T>{
    private T item;
    public Plate(T t){
        item = t;
    }
    public void set(T t){
        item = t;
    }
    
    public T get(){
        return item;
    }
}
