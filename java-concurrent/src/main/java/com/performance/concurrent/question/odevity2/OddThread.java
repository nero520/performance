package com.performance.concurrent.question.odevity2;

/**
 * 奇数线程
 */
public class OddThread implements Runnable {


    public void run() {
            for(int m=0;m<100;m++){
                if(m%2!=0){//奇数
                    System.out.println(Thread.currentThread().getName()+"="+Data.i);
                    Data.i++;
                }else{//偶数让出cpu
                    Thread.yield();
                }
        }


    }
}
