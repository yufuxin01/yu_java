package com.yu.case13;

import java.util.concurrent.Callable;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className CheckService2Callable
 * @description：
 * @date 2017/12/31 20:24
 */
public class CheckService2Callable implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        return CheckService2.check();
    }
}
