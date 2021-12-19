package com.along.dan_li;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/30 14:52
 */
public class dan_li_e_han {
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];
    private dan_li_e_han(){

    }
    private final static dan_li_e_han E_HAN = new dan_li_e_han();

    public static dan_li_e_han getInstance(){
        return E_HAN;
    }
}

