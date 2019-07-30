package com.performance.design.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonReg singletonReg = SingletonReg.getInstance(null);
        System.out.println(singletonReg);
        SingletonReg singletonReg2 = SingletonReg.getInstance(null);
        System.out.println(singletonReg2);
    }
}
