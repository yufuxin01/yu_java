package com.along.builder;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2021/1/4 13:26
 */
public class Worker extends Builder {

    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Worker(){
        product = new Product();
    }

    @Override
    void builderA() {
        product.setBuilderA("地基");
        System.out.println("地基");
    }

    @Override
    void builderB() {
        product.setBuilderB("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    void builderC() {
        product.setBuilderC("铺电线");
        System.out.println("铺电线");
    }

    @Override
    void builderD() {
        product.setBuilderD("粉刷");
        System.out.println("粉刷");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
