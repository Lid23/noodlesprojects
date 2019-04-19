package com.noodles.springinaction.aop;

import noodles.springaction.aop.aspectj.CriticAspect;
import noodles.springaction.aop.aspectj.CriticismEngine;
import noodles.springaction.aop.aspectj.CriticismEngineImpl;
import noodles.springaction.aop.aspects.Audience;
import noodles.springaction.aop.aspects.Audience2;
import noodles.springaction.aop.aspects.EncoreableIntroducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName: PerformanceConfig
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 10:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 10:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Configuration
@EnableAspectJAutoProxy
public class PerformanceConfig {

    @Bean
    public Performance performance(){
        return new Performance();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }

    @Bean
    public Audience2 audience2(){
        return new Audience2();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer(){
        return new EncoreableIntroducer();
    }


    /*
    * @Author: Sal
    * @Description:注入aspectj切面
    * @Date:2018/6/7 14:23
    */
    @Bean
    public CriticismEngine criticismEngine(){

        String[] criticismPool = new String[]{"123", "abc"};

        CriticismEngineImpl criticismEngineImpl = new CriticismEngineImpl();
        criticismEngineImpl.setCriticismPool( criticismPool );

        return criticismEngineImpl;
    }

    @Bean
    public CriticAspect criticAspect(CriticismEngine criticismEngine){

        //aspect对象需用工厂方法产生，不能用构造器
        CriticAspect criticAspect = CriticAspect.aspectOf();

        criticAspect.setCriticismEngine( criticismEngine );

        return criticAspect;
    }

}
