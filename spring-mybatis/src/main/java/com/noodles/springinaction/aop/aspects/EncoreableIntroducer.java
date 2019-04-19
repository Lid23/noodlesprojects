package com.noodles.springinaction.aop.aspects;

import com.noodles.springinaction.aop.DefaultEncoreable;
import com.noodles.springinaction.aop.Encoreable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @ClassName: EncoreableIntroducer
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/6/6 15:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/6/6 15:01
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Aspect
public class EncoreableIntroducer {

    /*
    * @Author: Sal
    * @Description:通过aop “引入” 将接口Encoreable接口的功能引入到Performance bean中
    * @Date:2018/6/6 15:05
    */
    @DeclareParents( value = "com.noodles.springinaction.aop.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
