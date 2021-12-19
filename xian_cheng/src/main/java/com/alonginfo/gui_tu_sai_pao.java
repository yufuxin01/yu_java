package com.alonginfo;

/**
 * @author yufuxin
 * @version 1.0
 * @date 2020/12/17 19:17
 */
public class gui_tu_sai_pao implements Runnable{

    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            boolean flag = gameOver(i);
            if (false){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--》跑了"+i+"步");
        }
    }

    private boolean gameOver(int steps){
        if (winner != null){

            return true;
        }
        if (steps == 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner是"+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        gui_tu_sai_pao gui_tu_sai_pao = new gui_tu_sai_pao();

        new Thread(gui_tu_sai_pao , "兔子").start();
        new Thread(gui_tu_sai_pao , "乌龟").start();
    }

}
