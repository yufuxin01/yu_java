package com.yu.case5;

/**
 * Worker主要功能类
 */
public class ComputeWorker extends Worker {

    /**
     * 模拟校验逻辑和计算逻辑
     *
     * @param input 计算的内容
     * @return 计算好的平方和
     */
    @Override
    public Object handle(Object input) {
        try {
            //模拟执行校验逻辑
            System.out.println("我开始校验了");
            Thread.sleep(5);  // 这里模拟校验耗时五毫秒
            System.out.println("我校验完了");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        Long i = (Long) input;
        return i * i; // 计算平方和
    }
}
