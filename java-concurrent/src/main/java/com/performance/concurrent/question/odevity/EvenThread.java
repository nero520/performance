package com.performance.concurrent.question.odevity;

/**
 * 偶数线程
 */
public class EvenThread implements Runnable{

    Data data;

    public EvenThread(Data data) {

        this.data = data;

    }

    public void run() {

        synchronized (data) {
            for (int m = 0; m < 100; m++) {
                if (data.isDubble) {//偶数数
                    System.out.println(Thread.currentThread().getName()+"=" + Data.i);
                    Data.i++;
                    data.isDubble = false;
                    data.notify();
                } else {//奇数等待
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }
}
