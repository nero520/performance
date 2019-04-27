package com.performance.jvm.stackoverflowerror;

/**
 栈溢出（StackOverflowError）

 栈溢出抛出 StackOverflowError 错误，出现此种情况是因为方法运行的时候栈的深度超过了虚拟机容许的最大深
 度所致。一般情况下是程序错误所致的，比如写了一个死递归，就有可能造成此种情况。下面我们通过一段代码
 来模拟一下此种情况的内存溢出。

 Exception in thread "main" java.lang.StackOverflowError
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 at StackOverflowError.stackOverFlowMethod(StackOverflowError.java:6)
 */
public class StackOverflowError {

    public void stackOverFlowMethod(){
        stackOverFlowMethod();
    }
    public static void main(String[] args){
        StackOverflowError oom = new StackOverflowError();
        oom.stackOverFlowMethod();
    }

}
