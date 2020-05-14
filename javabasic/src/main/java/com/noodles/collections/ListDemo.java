package com.noodles.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

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
public class ListDemo {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(1, 1, 2, 3);
        System.out.println(ListUtils.getListSizeWithKey( arrayList, 1 ));

        /**Vector使用了 synchronized 进行同步，线程安全*/
        List<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(1);
        vector.add(2);
        vector.add(3);


        //ArrayList非线程安全，可以通过Collections.synchronizedList()得到一个线程安全的ArrayList
        List<Integer> synList = Collections.synchronizedList(arrayList);

        //也可以使用 concurrent 并发包下的 CopyOnWriteArrayList 类替代Vector
        //读写分离，写加锁，适用读多写少的场景，缺陷是内存占用，写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右
        //
        List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);

        //LinkedList基于双向列表实现，使用Node存储链表节点信息，插入删除只需要改变指针，不需移动元素
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

    }
}
