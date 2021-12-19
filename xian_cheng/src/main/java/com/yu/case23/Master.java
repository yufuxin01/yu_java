package com.yu.case23;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Master
 * @description：
 * @date 2017/2/1 20:17
 */
public class Master {

    //封装任务的集合
    private ConcurrentLinkedQueue<Product> workQueue = new ConcurrentLinkedQueue<Product>();

    //封装worker的集合
    private HashMap<String, Thread> workers = new HashMap<String, Thread>();

    // 结果集，多个worker并发回写操作
    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

    public Master(Worker worker , int workerCount){
        worker.setWorkQueue(this.workQueue);
        worker.setResultMap(this.resultMap);
        for(int i = 0; i < workerCount; i ++){
            this.workers.put(Integer.toString(i), new Thread(worker));
        }
    }

    //5 需要一个提交任务的方法
    public void submit(Product product){
        this.workQueue.add(product);
    }

    //启动所有的worker方法去执行任务
    public void execute(){
        for(Map.Entry<String, Thread> me : workers.entrySet()){
            me.getValue().start();
        }
    }

    //判断是否运行结束的方法
    public boolean isComplete() {
        for(Map.Entry<String, Thread> me : workers.entrySet()){
            if(me.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }

    //获取计算结果
    public int getResult() {
        int priceResult = 0;
        for(Map.Entry<String, Object> me : resultMap.entrySet()){
            priceResult += (Integer)me.getValue();
        }
        return priceResult;
    }


}
