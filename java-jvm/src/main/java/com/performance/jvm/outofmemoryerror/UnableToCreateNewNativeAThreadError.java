package com.performance.jvm.outofmemoryerror;

/**
 *
 * -verbose:gc -Xmn5000M -Xms8000M -Xmx8000M  -XX:+PrintGC
 *
 * 线程761177
 线程761178
 线程761179
 线程761180
 Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 at java.lang.Thread.start0(Native Method)
 at java.lang.Thread.start(Thread.java:714)
 at UnableToCreateNewNativeAThreadError.main(UnableToCreateNewNativeAThreadError.java:17)
 */
public class UnableToCreateNewNativeAThreadError {


    public static void main(String[] args){

        int i =1;
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                }
            }).start();
            i++;
            System.out.println("线程"+i);
        }

    }

}
