package com.yu.case12;

import java.util.concurrent.ExecutionException;

/**
 *
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //为了模拟测试方便，事先建好了目录，E:\多线程课程代码\mutil-thread\src\main\java\com\yrxy\thread\case12\test，如果没有建立的，请建立。否则会报错。
//        String path = "E:\\多线程课程代码\\mutil-thread\\src\\main\\java\\com\\yrxy\\thread\\case12\\test";
        String path = "";
        String keyword1 = "error";
        int c1 = ConcurrentFileSearchTask.statKeyword(path, keyword1);
        System.out.println("订单团队包含关键字" + keyword1 + "的个数为：" + c1);

        String keyword2 = "exception";
        int c2 = ConcurrentFileSearchTask.statKeyword(path, keyword2);
        System.out.println("订单团队包含关键字" + keyword2 + "的个数为：" + c2);

        String keyword3 = "warn";
        int c3 = ConcurrentFileSearchTask.statKeyword(path, keyword3);
        System.out.println("订单团队包含关键字" + keyword3 + "的个数为：" + c3);

    }

}
