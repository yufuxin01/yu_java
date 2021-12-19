package com.yu.case10;
import java.util.concurrent.ExecutionException;


public class Test {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            Dinner.haveDinner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("整个过程，共耗时" + (System.currentTimeMillis() - startTime) + "ms");
    }

}
