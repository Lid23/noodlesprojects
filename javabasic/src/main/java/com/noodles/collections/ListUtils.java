package com.noodles.collections;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: ListUtils
 * @Description: java类作用描述
 * @Author: Sal
 * @CreateDate: 2018/5/17 11:09
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/17 11:09
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ListUtils {

    /*
    * @Author: Sal
    * @Description:对list去重
    * @Date:2018/5/17 11:10
    */
    public static <T> List<T> removeStringListDup(List<T> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        Set<T> set = new LinkedHashSet<T>();
        set.addAll(list);
        list.clear();
        list.addAll(set);

        return list;
    }

    /*
    * @Author: Sal
    * @Description:获取list单一元素的size
    * @Date:2018/5/17 11:22
    */
    public static <T> int getListSizeWithKey(List<T> list, T key){
        return Collections.frequency(list, key);
    }

}
