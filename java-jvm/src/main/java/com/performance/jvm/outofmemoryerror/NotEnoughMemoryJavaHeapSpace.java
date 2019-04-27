package com.performance.jvm.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xmn10M -Xms20M -Xmx20M -XX:+PrintGC
 *
 * [GC (Allocation Failure)  2208K->736K(19456K), 0.0181611 secs]
 [GC (Allocation Failure)  736K->712K(19456K), 0.0215309 secs]
 [Full GC (Allocation Failure)  712K->637K(19456K), 0.0166645 secs]
 [GC (Allocation Failure)  637K->637K(19456K), 0.0009471 secs]
 [Full GC (Allocation Failure)  637K->619K(19456K), 0.0348298 secs]
 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 at NotEnoughMemoryJavaHeapSpace.main(NotEnoughMemoryJavaHeapSpace.java:15)

 对象大于新生代剩余内存的时候，将直接放入老年代，当老
 年代剩余内存还是无法放下的时候，触发垃圾收集，收集后还是不能放下就会抛出内存溢出异常了

 如果出现了内存溢出问题，这往往是程序本生需要的内存大于了我们给虚拟机配置的内存，这种情况下，我
 们可以采用调大-Xmx来解决这种问题。
 *
 */
public class NotEnoughMemoryJavaHeapSpace {

    public static void main(String[] args){
        List<byte[]> buffer = new ArrayList<byte[]>();
        buffer.add(new byte[10*1024*1024]);
    }

}
