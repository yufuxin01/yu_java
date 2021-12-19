package com.yu.case22;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className SyncCounter
 * @description：
 * @date 2017/2/19 14:03
 */
public class SyncCounter {

    private int num=0;
    public synchronized int getNextNum(){
        ++num;
        return num;
    }
    public static void main(String [] args){
        SyncCounter tn=new SyncCounter();
        Counter tc1=new Counter(tn);
        Counter tc2=new Counter(tn);
        Counter tc3=new Counter(tn);

        tc1.start();
        tc2.start();
        tc3.start();
    }
   static class Counter extends Thread{
        private SyncCounter tn;
        public Counter(SyncCounter tn){
            this.tn=tn;
        }
        public void run(){
            for(int i=0;i<33;i++){
                System.out.println("thread-"+Thread.currentThread().getName()+"-"+tn.getNextNum());
            }
        }
    }

}
