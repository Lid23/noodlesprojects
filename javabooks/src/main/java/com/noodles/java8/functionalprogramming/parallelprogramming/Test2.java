package com.noodles.java8.functionalprogramming.parallelprogramming;

import java.util.ArrayList;

/**
 * @ClassName: Test2
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2018/1/24 13:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/1/24 13:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Test2 {

    public static void main(String[] args) {
        compareForAndStream();
    }

    public static void compareForAndStream() {
        //p1表示for性能,p2表示流处理性能
        long p1 = 0, p2 = 0;
        int n = 1000000;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int j = 0; j < 100; j ++) {
            for(int i = 0; i < n; i ++) {
                arr.add(i);
            }
            Integer sum = 0;
            long t1 = System.nanoTime();
            for(Integer v : arr) {
                sum = sum + v;
            }
            long t2 = System.nanoTime();
            //arr.stream().reduce(0, (a, b) -> a + b);
            arr.stream().parallel().reduce(0, (a, b) -> a + b);
            long t3 = System.nanoTime();
            p1 += (t2 - t1);
            p2 += (t3 - t2);
            arr.clear();
        }
        System.out.println(p1 / 100 / 1000);
        System.out.println(p2 / 100 / 1000);

    }
}
