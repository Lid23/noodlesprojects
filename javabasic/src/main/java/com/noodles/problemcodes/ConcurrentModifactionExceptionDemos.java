package com.noodles.problemcodes;

import com.noodles.gson.JsonUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @program: noodles-projects
 * @description: 遍历集合时同时对集合进行修改，抛出异常
 * @author: Eric
 * @create: 2019-04-21 19:51
 **/
public class ConcurrentModifactionExceptionDemos {


    public static void main(String args[]){

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        //迭代器去除元素
        rightCode(integerList, (i) -> i == 2);
        System.out.println(JsonUtil.toJson(integerList));




        /**抛出ConcurrentModificationException*/
        //wrongCode(integerList, (i)-> i == 2);



    }

  
    /** 
    * @Description:  错误写法，在遍历List过程中，符合某个条件时，移除元素
    * @Param:  
    * @return:  
    * @Author: Eric
    * @Date: 2019-04-21 
    */ 
    public static <T> void wrongCode(List<T> list, Predicate<T> p){
        for(T e : list){
            if(p.test(e)){
                list.remove(e);
            }
        }
    }


    /**
    * @Description: 正确写法，用迭代器
    * @Param:
    * @return:
    * @Author: Eric
    * @Date: 2019-04-21
    */
    public static <T> void rightCode(List<T> list, Predicate<T> p){

        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()){
            if(p.test(iterator.next())){
                iterator.remove();
            }
        }

    }
}
