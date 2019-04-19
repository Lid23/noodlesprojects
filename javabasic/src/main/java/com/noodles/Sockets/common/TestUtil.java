package com.noodles.Sockets.common;

/**
 * @ClassName: TestUtil
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/23 14:02
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/23 14:02
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class TestUtil {

    public static void doSomething(String str){
        Integer ig = 0;
        for(int i = 0; i < 12000; i++){
            ig = ig + i;
            str = str + ig;
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        doSomething("test");
        long end = System.currentTimeMillis();
        System.out.println( end - start);
    }

}
