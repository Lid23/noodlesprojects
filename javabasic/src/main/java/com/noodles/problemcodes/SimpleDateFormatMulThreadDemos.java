package com.noodles.problemcodes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: noodlesprojects
 * @description: SimpleDateFormat多线程安全问题
 * @author: Eric
 * @create: 2019-04-22 12:40
 **/
public class SimpleDateFormatMulThreadDemos {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @Description: 方法内初始化创建simpleDateFormat对象，
     * 当需要大量操作时间格式时，会创建大量的对象，占用大量的内存和jvm空间
     * @Param: date
     * @return: String
     * @Author: Eric
     * @Date: 2019/4/22
     */
    public static String formatDate(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDate);
    }

    /**
     * @Description: 使用静态的simpleDateFormat实例：这样在大部分时间里都会工作的很好，但当一定负载下，问题就出现了，SimpleDateFormat不是线程安全的，
     * 会出现各种不同的情况，比如转化的时间不正确，比如报错，比如线程被挂死等等
     * @Param: date
     * @return: String
     * @Author: Eric
     * @Date: 2019/4/22
     */
    public static String formatDate1(Date date) throws ParseException {
        return sdf.format(date);
    }

    public static Date parse1(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }

    /**
     * @Description: 使用同步，当线程较多时，当一个线程调用该方法时，其他想要调用此方法的线程就要block，多线程并发量大的时候会对性能有一定的影响
     * @Param:
     * @return:
     * @Author: Eric
     * @Date: 2019/5/6
     */
    public static String formatDateSyn(Date date) throws ParseException {
        synchronized (sdf) {
            return sdf.format(date);
        }
    }

    public static Date parseSyn(String strDate) throws ParseException {
        synchronized (sdf) {
            return sdf.parse(strDate);
        }
    }

    /**
    * @Description: 使用ThreadLocal
    * @Param:
    * @return:
    * @Author: Eric
    * @Date: 2019/5/6
    */
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date parseByThreadLocal(String dateStr) throws ParseException{
        return threadLocal.get().parse(dateStr);
    }

    public static String formatByThreadLocal(Date date){
        return threadLocal.get().format(date);
    }

    /**
     * @Description: 多线程测试类, 观察多线程执行使用了静态simpleDateFormat对象的情况
     * @Param:
     * @return:
     * @Author: Eric
     * @Date: 2019/5/6
     */
    public static class TestSimpleDateFormatUnThreadSafe extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //测试异常情况
                    //System.out.println(this.getName() + ":" + parse1("2019-05-06 06:02:20"));

                    //测试同步情况
                    //System.out.println(this.getName() + ":" + parseSyn("2019-05-06 06:02:20"));

                    //测试ThreadLocal使用情况
                    System.out.println(this.getName() + ":" + parseByThreadLocal("2019-05-06 06:02:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //启动多线程
        for (int i = 0; i < 3; i++) {
            new TestSimpleDateFormatUnThreadSafe().start();
        }
    }
}
