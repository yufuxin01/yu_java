package com.along.dan_li;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/31 9:48
 */
public class Aa {
    public static void main(String[] args) {
        String x = "http://bdkf.alonginfo.com.cn:4321/api/zhgl/djwh/list?fl=01_lb=2_zyfl=10_lbbh=101010";
        String s = x.replaceAll("_", "&");

        System.out.println(s);
    }
}
