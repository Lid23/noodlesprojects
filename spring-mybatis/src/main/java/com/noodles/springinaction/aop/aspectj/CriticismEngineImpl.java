package com.noodles.springinaction.aop.aspectj;

/**
 * @ClassName: CriticismEngineImpl
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 16:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 16:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CriticismEngineImpl implements  CriticismEngine {

    private String[] criticismPool;


    public CriticismEngineImpl(){};

    @Override
    public String getCriticism() {
        int i = (int)(Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    public String[] getCriticismPool() {
        return criticismPool;
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
