package com.noodles.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: main
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/17 11:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/17 11:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 3);

        System.out.println(ListUtils.getListSizeWithKey( list, 1 ));
    }
}
