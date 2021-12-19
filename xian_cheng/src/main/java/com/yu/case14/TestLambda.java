package com.yu.case14;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className TestLambda
 * @description：
 * @date 2017/12/26 18:14
 */
public class TestLambda {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hi,1线程启动了~~~~~");
            }
        };

        runnable.run();
    }
    /**
     * 语法格式一：无参数，无返回值
     *        () -> System.out.println("Hello Lambda!");
     */
    public static void test2() {
        //“->”左边只有一个小括号，表示无参数，右边是Lambda体(就相当于实现了匿名内部类里面的方法了，(即就是一个可用的接口实现类了。))
        Runnable runnable = ()->System.out.println("hi,2线程启动了~~~~~");
//        runnable.run();
    }

}
