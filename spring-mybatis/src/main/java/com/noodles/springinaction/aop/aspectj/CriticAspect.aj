package com.noodles.springinaction.aop.aspectj;

/**
 * @ClassName: CriticAspect
 * @Description: java类作用描述 aspectj 切面，当Spring Aop功能不能满足需求时，可以用aspectj切面，例如：构造器切面，属性修改切面等
 * @Author: Sal
 * @CreateDate: 2018/6/6 18:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 18:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public aspect CriticAspect {

    private CriticismEngine criticismEngine;

    public CriticAspect(){}


    pointcut performance() : execution(* perform(..));

    after():performance(){
        System.out.printf( "after performance dddddddddd" );
    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
