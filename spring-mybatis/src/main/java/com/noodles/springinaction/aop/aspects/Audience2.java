package com.noodles.springinaction.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @ClassName: Audience2
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 10:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 10:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Aspect
public class Audience2 {

    @Pointcut("execution(** noodles.springaction.aop.Performance.perform(..))")
    public void performance(){}

    @Around( "performance()" )
    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");

            jp.proceed();

            System.out.println("CALP CALP CALP");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
