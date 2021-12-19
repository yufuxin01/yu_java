package com.yu.case12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className KeywordCounter
 * @description：
 * @date 2017/12/27 19:20
 */
public class KeywordCounter implements Callable<Integer> {

    public File file;
    public String keyword;
    private  Integer keywordCount = 0;

    public Integer call() throws Exception {   //call封装线程所需做的任务
        try(Scanner scanner = new Scanner(new FileInputStream(file))){
            while( scanner.hasNextLine()){
                if (scanner.nextLine().contains(keyword)) {
                    keywordCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return keywordCount;
    }

}
