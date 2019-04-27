package com.performance.concurrent.question.odevity;

public class MainThread {

    public static void main(String[] args) {
        Data data = new  Data();
        Thread odd = new Thread(new OddThread(data));
        Thread even = new Thread(new EvenThread(data));
        odd.setName("奇数线程");
        even.setName("偶数线程");
        even.start();
        odd.start();

    }

}
