package com.yu.case13;

import java.util.concurrent.Callable;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className CheckService1Callable
 * @description：
 * @date 2017/12/31 20:23
 */
public class CheckService1Callable  implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        return CheckService1.check();
    }

}
