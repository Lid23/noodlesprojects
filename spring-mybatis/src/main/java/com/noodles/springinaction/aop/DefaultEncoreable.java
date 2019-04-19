package com.noodles.springinaction.aop;

/**
 * @ClassName: DefaultEncoreable
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 15:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 15:03
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DefaultEncoreable implements Encoreable {

    @Override
    public void performEncore() {
        System.out.println("default performEncore");
    }
}
