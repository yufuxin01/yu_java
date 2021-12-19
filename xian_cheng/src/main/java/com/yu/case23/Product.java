package com.yu.case23;
/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className Product
 * @description：
 * @date 2017/2/1 20:19
 */
public class Product {

    private int prdId;
    private int prdPrice;
    public int getPrdId() {
        return prdId;
    }
    public void setPrdId(int prdId) {
        this.prdId = prdId;
    }
    public int getPrdPrice() {
        return prdPrice;
    }
    public void setPrdPrice(int prdPrice) {
        this.prdPrice = prdPrice;
    }

    public String toString() {
        return "商品信息: 商品id " + prdId + ", 商品价格" + prdPrice+"元" ;
    }

}
