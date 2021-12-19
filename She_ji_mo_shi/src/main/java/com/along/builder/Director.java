package com.along.builder;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2021/1/4 13:31
 * 指挥 构建一个工程 由他决定
 */
public class Director {

    /**
     * 功能描述:
     * 〈〉指挥工人操作
     * @Param: [builder]
     * @Return: com.along.builder.Product
     * @Author: 20297
     * @Date: 2021/1/4 13:38
     */
    public Product build(Builder builder){
        builder.builderB();
        builder.builderA();
        builder.builderC();
        builder.builderD();

        return builder.getProduct();
    }

}
