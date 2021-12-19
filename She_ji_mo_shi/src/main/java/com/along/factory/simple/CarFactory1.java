package com.along.factory.simple;

/**
 * @author yufuxin
 * @version 1.0
 * 车工厂
 * @date 2020/12/31 16:49
 */
public class CarFactory1 {
    public  static Car getCat(String cat){
        if ("五菱".equals(cat)){
            return new Wuling();
        }else if ("特斯拉".equals(cat)){
            return new Tesla();
        }else {
            return null;
        }
    }
}
