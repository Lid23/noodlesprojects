package com.noodles.springinaction.aop.aspects;

import org.aspectj.lang.annotation.*;

/**
 * @ClassName: Audience
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 10:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 10:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Aspect
public class Audience {

    @Pointcut("execution(** noodles.springaction.aop.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    @Before("execution(** noodles.springaction.aop.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(** noodles.springaction.aop.Performance.perform(..))")
    public void  applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("execution(** noodles.springaction.aop.Performance.perform(..))")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }
}
