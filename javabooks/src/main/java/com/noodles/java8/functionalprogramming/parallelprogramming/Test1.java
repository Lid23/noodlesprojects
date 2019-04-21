package com.noodles.java8.functionalprogramming.parallelprogramming;

import org.openjdk.jmh.runner.RunnerException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


public class Test1 {

    private static List<Integer> integers = new ArrayList<>();

    public static final int size = 10000000;

    static {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++) {
            int i1 = random.nextInt(size);
            integers.add(i1);
        }
    }

    public static void main(String[] args) throws RunnerException {
        // System.out.println("done in: " + measurePerf(Test1::iteratorMaxInteger) + " msecs");

        // System.out.println( integers );

        System.out.println("done in: " + measurePerf(Test1::iteratorMaxInteger) + " msecs");
        System.out.println("done in: " + measurePerf(Test1::forEachLoopMaxInteger) + " msecs");
        System.out.println("done in: " + measurePerf(Test1::forMaxInteger) + " msecs");
        System.out.println("done in: " + measurePerf(Test1::parallelStreamMaxInteger) + " msecs");
        System.out.println("done in: " + measurePerf(Test1::lambdaMaxInteger) + " msecs");

        /*System.out.println(iteratorMaxInteger());
        System.out.println(forEachLoopMaxInteger());
        System.out.println(forMaxInteger());
        System.out.println(parallelStreamMaxInteger());
        System.out.println(lambdaMaxInteger());*/
    }

    public static int iteratorMaxInteger() {

        int max = Integer.MIN_VALUE;
        for (Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
            max = Integer.max(max, it.next());
        }
        return max;
    }

    public static int forEachLoopMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (Integer n : integers) {
            max = Integer.max(max, n);
        }
        return max;
    }

    public static int forMaxInteger() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, integers.get(i));
        }
        return max;
    }

    public static int parallelStreamMaxInteger() {
        Optional<Integer> max;
        max = integers.parallelStream().reduce(Integer::max);
        return max.get();
    }

    public static  int lambdaMaxInteger() {
        return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }

    public static <T> long measurePerf(Supplier<T> s) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            T result = s.get();
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + result);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

   /*public static void main(String[] args) {
        Test1 test = new Test1();
        test.time(test::forEachLoopMaxInteger, test::forMaxInteger, test::iteratorMaxInteger, test::lambdaMaxInteger, test::parallelStreamMaxInteger);
    }*/


}
