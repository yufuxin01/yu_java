package com.yu.case5;

import java.util.Map;
import java.util.Queue;


public class Worker implements Runnable {
    /**
     * 工作队列
     */
    protected Queue<Object> workQueue;
    /**
     * 存放计算结果的Map
     */
    protected Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    /**
     * 计算相关的逻辑 ,这里子类会实现
     */
    public Object handle(Object input) {
        return input;
    }

    /**
     * 从队列里面拉取内容,计算相关的逻辑,把计算的结果放到resultMap里面去.
     */
    @Override
    public void run() {
        while (true) {
            //拉取内容
            Object input = workQueue.poll();
            if (input == null) {
                break;
            }
            //执行计算逻辑
            Object result = handle(input);

            // 计算的逻辑结果放到这个map里面去.
            // key就是hashCode,value就是计算的结果
            resultMap.put(Integer.toString(input.hashCode()), result);
        }
    }
}
