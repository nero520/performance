package com.performance.concurrent.question.odevity2;

public class MainThread {

    public static void main(String[] args) {

        Thread odd = new Thread(new OddThread());
        Thread even = new Thread(new EvenThread());
        odd.setName("奇数线程");
        even.setName("偶数线程");
        odd.start();
        even.start();
    }

}
