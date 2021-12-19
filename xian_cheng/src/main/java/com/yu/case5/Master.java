package com.yu.case5;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Master是协调用的,给计算任务分给不同的worker线程来处理.
 */
public class Master {
    // 放任务的队列
    protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
    //装载Worker线程
    protected Map<String, Thread> workerThreadMap = new HashMap<String, Thread>();
    //每个worker计算结果放到这个map里面

    protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

    /**
     * 构造方法
     *
     * @param worker      工作线程
     * @param countWorker 工作线程数量
     */
    public Master(Worker worker, int countWorker) {
        // 设置工作队列
        worker.setWorkQueue(workQueue);
        // 设置 存放计算结果的Map
        worker.setResultMap(resultMap);

        for (int i = 0; i < countWorker; i++) {
            // 装载Worker线程 ,!! 需要注意的是,这里如果工作线程设置的过大的话,这里装在Worker线程会比较多
            // 如果你电脑配置不高的话,这里可能会消耗很多时间去实例化线程,并且装到workerThreadMap 里面
            // 所以设置工作线程数量的时候要量力而行.
            workerThreadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    /**
     * 会判断每一个线程状态是否有结束
     *
     * @return 没结束就返回false, 结束了就返回true
     */
    public boolean isComplete() {
        for (Map.Entry<String, Thread> entry : workerThreadMap.entrySet()) {
            // Thread.State.TERMINATED : 终止线程的线程状态。线程已完成执行

            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                // 没结束就返回false

                return false;
            }
        }
        // 结束了就返回true
        return true;
    }

    //提交
    public void submit(Object job) {
        workQueue.add(job);
    }


    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    //发起执行
    public void execute() {
        for (Map.Entry<String, Thread> entry : workerThreadMap.entrySet()) {
            entry.getValue().start();
        }
    }
}
