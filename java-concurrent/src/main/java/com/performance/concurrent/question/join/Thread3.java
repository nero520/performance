package com.performance.concurrent.question.join;

public class Thread3 extends Thread{

    Thread thread2;

    public Thread3(Thread thread) {
        this.thread2 = thread;
    }

    @Override
    public void run() {
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("t3 is running");
        }
    }
}
