package com.performance.concurrent.question.odevity;

/**
 * 奇数线程
 */
public class OddThread implements Runnable {

    Data data;

    public OddThread(Data data) {

        this.data = data;

    }

    public void run() {

        synchronized (data){

            for(int m=0;m<100;m++){
                if(!data.isDubble){//奇数
                    System.out.println(Thread.currentThread().getName()+"="+Data.i);
                    Data.i++;
                    data.isDubble = true;
                    data.notify();
                }else{//偶数等待
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
