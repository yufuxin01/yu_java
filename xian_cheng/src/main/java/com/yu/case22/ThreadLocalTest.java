package com.yu.case22;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className ThreadLocalTest
 * @description：
 * @date 2017/1/30 18:40
 */
public class ThreadLocalTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(1);
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void test() {
        for (int i = 1; i <= 3; i++) {
            int index = i;
            executor.execute(() -> {
                System.out.println("模拟第" + index + "个用户请求");
                System.out.println("线程" + Thread.currentThread().getName() + "保存的信息：" + threadLocal.get());
                threadLocal.set("用户" + index + "的信息");
                System.out.println("线程" + Thread.currentThread().getName() + "保存的信息：" + threadLocal.get());
                //当前线程结束，移除本地线程中保存的信息
//                threadLocal.remove();
            });
        }
        //记得关闭线程池
        executor.shutdown();
    }

    public static void main(String[] args) {
        test();
    }

}
