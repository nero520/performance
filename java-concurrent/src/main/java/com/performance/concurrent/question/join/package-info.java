package com.performance.concurrent.question.join;
/**

 问题：现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行?

 join方法是Thread类中的一个方法，该方法的定义是等待该线程终止。
 其实就是join()方法将挂起调用线程的执行，直到被调用的对象完成它的执行。
 如果要join正常生效，调用join方法的对象必须已经调用了start()方法且并未进入终止状态。

 */