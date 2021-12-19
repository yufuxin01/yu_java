package com.alonginfo;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/18 10:18
 */
public class StaticProxy {

    public static void main(String[] args) {
        
        new Thread(()-> System.out.println("结婚")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("结婚开心");
    }
}

class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚后收尾款");
    }

    private void before() {
        System.out.println("结婚前布置现场");
    }

}
