package com.along.builder;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2021/1/4 13:21
 */
public abstract class Builder {
    abstract void  builderA();
    abstract void  builderB();
    abstract void  builderC();
    abstract void  builderD();

    abstract Product getProduct();

}
