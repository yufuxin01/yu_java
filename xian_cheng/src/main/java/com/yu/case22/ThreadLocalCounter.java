package com.yu.case22;

/**
 * @author huanglaoxie(微信:yfct-8888)
 * @className ThreadLocalCounter
 * @description：
 * @date 2017/2/19 14:06
 */
public class ThreadLocalCounter {
    private ThreadLocal<Integer> num=new ThreadLocal<Integer>(){
        public Integer initialValue(){
            return 0;
        }
    };
    public  int getNextNum(){
        num.set(num.get()+1);
        return num.get();
    }
    public static void main(String [] args){
        ThreadLocalCounter tn=new ThreadLocalCounter();
        Counter tc1=new Counter(tn);
        Counter tc2=new Counter(tn);
        Counter tc3=new Counter(tn);

        tc1.start();
        tc2.start();
        tc3.start();
    }
  static  class Counter extends Thread{
        private ThreadLocalCounter tn;
        public Counter(ThreadLocalCounter tn){
            this.tn=tn;
        }
        public void run(){
            for(int i=0;i<99;i++){
                System.out.println("thread-"+Thread.currentThread().getName()+"-"+tn.getNextNum());
            }
        }
    }

}
