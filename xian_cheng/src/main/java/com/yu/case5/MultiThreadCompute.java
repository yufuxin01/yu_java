package com.yu.case5;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

public class MultiThreadCompute {

    @Test
    public void testCompute() {
        Long start = System.currentTimeMillis();
        // 初始化Master,初始化100个Worker

        int countWorker = 500;
        Master master = new Master(new ComputeWorker(), countWorker);
        //for循环提交任务,计算100万条数据
        for (long i = 1; i < 1000001; i++) {
            master.submit(i);
        }
        master.execute();

        long re = 0;
        //获取计算结果
        Map<String, Object> resultMap = master.getResultMap();

        //如不满足这个while结果之后,说明计算完成了

        while (resultMap.size() > 0 || !master.isComplete()) {

            // 获取存放任务的Map
            Set<String> keys = resultMap.keySet();

            String key = null;
            // 获取第一个key然后跳出循环
            for (String k : keys) {
                key = k;
                break;
            }

            Long singleResult = null;
            if (key != null) {
                // 如果有key的话,就从resultMap里面取出这个key对应的计算完的结果
                singleResult = (Long) resultMap.get(key);
            }
            // 如果计算结果不为空的话就进行累加
            if (singleResult != null) {
                re += singleResult;
            }
            // 如果这个key不是null的话,就从计算结果里面删除这个key,原因是因为已经计算完了,留着也没啥用了.
            if (key != null) {
                resultMap.remove(key);
            }
        }


        Long end = System.currentTimeMillis();

        System.out.println("当前工作线程有: " + countWorker + " 个  ,执行计算结果为:" + re + " 耗时: " + (end - start) + "毫秒");
    }


}
