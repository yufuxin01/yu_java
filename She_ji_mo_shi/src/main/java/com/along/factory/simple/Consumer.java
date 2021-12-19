package com.along.factory.simple;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/31 16:48
 * 开闭原则
 *
 */
public class Consumer {
    public static void main(String[] args) {
//        Car wuling = new Wuling();
//        Car tesla = new Tesla();
//        Car wuling = CarFactory1.getCat("五菱");
//        Car tesla = CarFactory1.getCat("特斯拉");
        Car wuling = new WulingFactory().getCar();
        Car tesla = new TeslaFactory().getCar();

        Car mobai = new MobaiFactory().getCar();
        wuling.name();
        tesla.name();
        mobai.name();
    }
}
