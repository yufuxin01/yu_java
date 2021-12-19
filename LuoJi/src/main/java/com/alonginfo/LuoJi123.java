package com.alonginfo;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/24 10:08
 */
public class LuoJi123 {
    public static void main(String[] args) {
        int x = 2;
        for (int i = 1; i < 12; i++) {
            int pow = (int) Math.pow(x, i);
            System.out.println("第"+i+"个月有"+pow+"只兔子");
        }
    }
}
