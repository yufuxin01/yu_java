package com.yu.case12;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className ConcurrentFileSearchTask
 * @description：
 * @date 2017/11/18 14:47
 */
public class ConcurrentFileSearchTask {

    public static int statKeyword(String path, String keyword) throws InterruptedException, ExecutionException {
        int keywordCount = 0;
        File[] files = new File(path).listFiles();
        ArrayList<Future<Integer>> futureArrayList = new ArrayList<>();
        for(File file: files){
            //每个文件启动一个task去查找
            KeywordCounter count = new KeywordCounter();
            count.file = file;
            count.keyword = keyword;
            FutureTask<Integer> task = new FutureTask(count);
            futureArrayList.add(task); //将任务返回的结果添加到集合中
            Thread thread = new Thread(task);
            thread.start();
        }

        for(Future<Integer> f: futureArrayList){
            keywordCount += f.get(); //迭代返回结果并累加
        }
        return keywordCount;
    }
}




