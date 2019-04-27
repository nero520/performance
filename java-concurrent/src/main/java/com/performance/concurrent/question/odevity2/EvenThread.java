package com.performance.concurrent.question.odevity2;

/**
 * 偶数线程
 */
public class EvenThread implements Runnable{

    public void run() {
            for (int m = 0; m < 100; m++) {
                if (m%2==0) {//偶数数
                    System.out.println(Thread.currentThread().getName()+"=" + Data.i);
                    Data.i++;
                } else {//奇数让出cpu
                    Thread.yield();
                }
            }
    }
}
