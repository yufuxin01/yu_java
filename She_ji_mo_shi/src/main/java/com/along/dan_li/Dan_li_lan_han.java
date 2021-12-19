package com.along.dan_li;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/30 14:58
 */
public class Dan_li_lan_han {
    private Dan_li_lan_han(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    private static Dan_li_lan_han dan_li_lan_han;

    public static Dan_li_lan_han getInstance(){
        if (dan_li_lan_han == null){
            synchronized (Dan_li_lan_han.class){
                if (dan_li_lan_han == null){
                    dan_li_lan_han = new Dan_li_lan_han();
                }
            }
        }

        return dan_li_lan_han;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Dan_li_lan_han.getInstance();
            }).start();
        }
    }
}
