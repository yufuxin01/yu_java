package com.alonginfo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/18 11:06
 */
public class Lambda {
    private static final char[] ZEROARRAY = "0000000000000000000000000000000000000000000000000000000000000000".toCharArray();

    public static void main(String[] args) {
        String gdbh="20201222"+Lambda.zeroPadString("298806", 6);
        Integer x = 1;
        System.out.println(x.intValue());
        System.out.println(gdbh);
    }

    public static String dateToString(Date date, String format) {
        if (date != null && format != null && !"".equals(format)) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        } else {
            return "";
        }
    }
    public static final String zeroPadString(String string, int length) {
        if (string != null && string.length() <= length) {
            StringBuffer buf = new StringBuffer(length);
            buf.append(ZEROARRAY, 0, length - string.length()).append(string);
            return buf.toString();
        } else {
            return string;
        }
    }

}
