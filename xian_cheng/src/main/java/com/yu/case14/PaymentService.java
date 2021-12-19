package com.yu.case14;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className PayService
 * @description：
 * @date 2017/12/27 11:02
 */
public class PaymentService {

    /**
     * 异步支付的入口方法
     * @return
     */
    public static boolean asyncPay() {

    	CompletableFuture<Boolean> isValid =CompletableFuture.supplyAsync(() -> CheckService.isValid());

    	CompletableFuture<Integer> orderSum=CompletableFuture.supplyAsync(() ->OrderService.createOrder());

    	CompletableFuture<Integer> money=CompletableFuture.supplyAsync(() ->basePay());

        CompletableFuture.allOf(isValid, orderSum, money)
                .thenRun(() -> System.out.println("完成异步支付"))
                .join();

        return true;

    }

    /**
     *同步支付的入口方法
     * @return
     */
    public static boolean syncPay() {
        CheckService.isValid();
        OrderService.createOrder();
        basePay();
        System.out.println("同步支付成功" );

        //假设支付成功
        return true;
    }

    public static int basePay() {
      int  money=1000;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("支付" );
        //假设支付成功
       return money;
    }

}
