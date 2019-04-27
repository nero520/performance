package com.performance.concurrent.question.join;

public class Thread2 extends Thread{

    Thread thread1;

    public Thread2(Thread thread) {
        this.thread1 = thread;
    }

    @Override
    public void run() {

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("t2 is running");
        }

    }
}
