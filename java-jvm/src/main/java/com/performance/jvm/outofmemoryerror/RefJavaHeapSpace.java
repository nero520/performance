package com.performance.jvm.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 堆溢出(OutOfMemoryError:java heap space)

 堆内存溢出的时候，虚拟机会抛出 java.lang.OutOfMemoryError:java heap space。

 出现此种情况的时候，我们需要根据内存溢出的时候产生的 dump 文件来具体分析（需要增加 -XX:+HeapDump
 OnOutOfMemoryError jvm启动参数）。出现此种问题的时候有可能是内存泄漏，也有可能是内存溢出了。

 1、配置方法

 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${目录}。
 2、参数说明

 （1）-XX:+HeapDumpOnOutOfMemoryError参数表示当JVM发生OOM时，自动生成DUMP文件。

 （2）-XX:HeapDumpPath=${目录}参数表示生成DUMP文件的路径，也可以指定文件名称，例如：-XX:HeapDu
 mpPath=${目录}/java_heapdump.hprof。如果不指定文件名，默认为：java_<pid><date><time>_heapDu
 mp.hprof。
 如果是内存泄漏，我们要找出内存泄漏的对象是怎么被GC ROOT引用起来，然后通过引用链来具体分析泄露的
 原因。

 如果出现了内存溢出问题，这往往是程序本生需要的内存大于了我们给虚拟机配置的内存，这种情况下，我
 们可以采用调大-Xmx来解决这种问题。
 *
 * -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 *
 * 错误信息
 * java.lang.OutOfMemoryError: Java heap space
 Dumping heap to java_pid836.hprof ...
 Heap dump file created [13597778 bytes in 0.082 secs]
 SnapShooter listening on port 65066
 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 at java.util.Arrays.copyOf(Arrays.java:3210)
 at java.util.Arrays.copyOf(Arrays.java:3181)
 at java.util.ArrayList.grow(ArrayList.java:261)
 at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
 at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
 at java.util.ArrayList.add(ArrayList.java:458)
 at Main.main(Main.java:11)
 at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
 at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
 at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
 at java.lang.reflect.Method.invoke(Method.java:498)
 at com.intellij.uiDesigner.snapShooter.SnapShooter.main(SnapShooter.java:59)
 *
 */
public class RefJavaHeapSpace {

    public static void main(String[] args) {
        //引用对象不释放导致的堆溢出
      List<HeapOutErrorObj> list = new ArrayList<HeapOutErrorObj>();
      while(true){
          list.add(new HeapOutErrorObj());
      }

    }
}
