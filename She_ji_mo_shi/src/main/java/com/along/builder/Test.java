package com.along.builder;

import java.util.ArrayList;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2021/1/4 13:59
 */
public class Test {
    public static void main(String[] args) {
//        Director director = new Director();
//        Product build = director.build(new Worker());
//        System.out.println(build.toString());
//
        String x ="57.7-380";
        ArrayList<Double> doubles = new ArrayList<>();
        String[] split = x.split("-");
        for (String s : split) {
            double v = Double.parseDouble(s);
            doubles.add(v);
        }
        Double z = 0.0;
        for (Double aDouble : doubles) {
            if (z<aDouble){
                z = aDouble;
            }
        }
        String result = z+"";
        if (result.contains(".")) {// 是小数
            while (true) {
                if (result.charAt(result.length() - 1) == '0'){
                    result = result.substring(0, result.length() - 1);
                }
                else{
                    if (result.endsWith(".")) {
                        result = result.substring(0, result.length() - 1);
                    }
                    break;
                }

            }

        }
        System.out.println(result);



    }
}
