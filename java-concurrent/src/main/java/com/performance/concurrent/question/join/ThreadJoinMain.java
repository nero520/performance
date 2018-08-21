package com.performance.concurrent.question.join;

public class ThreadJoinMain {

    public static void main(String[] args) {

        Thread t1 = new Thread1();
        Thread t2 = new Thread2(t1);
        Thread t3 = new Thread3(t2);

        t1.start();
        t3.start();
        t2.start();

        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("主线程执行");
        }


    }

}
