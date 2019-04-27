package com.performance.jvm.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**

 -verbose:gc -Xmn2M -Xms5M -Xmx5M -XX:MaxPermSize=1M -XX:+PrintGC
 注意：JDK8以下版本，报Exception in thread "main" java.lang.OutOfMemoryError: PermGen space

 JDK8环境的报如下错误
 [Full GC (Ergonomics)  5041K->5039K(5632K), 0.0227322 secs]
 [Full GC (Ergonomics)  5039K->5039K(5632K), 0.0218374 secs]
 [Full GC (Ergonomics)  5039K->5039K(5632K), 0.0259485 secs]
 [Full GC (Ergonomics)  5039K->5039K(5632K), 0.0239671 secs]
 [Full GC (Ergonomics) Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 5039K->5039K(5632K), 0.0279387 secs]
 [Full GC (Ergonomics) 	at java.util.Arrays.copyOfRange(Arrays.java:3664)
 at java.lang.String.<init>(String.java:207)
 at java.lang.String.substring(String.java:1933)
 at java.util.UUID.digits(UUID.java:386)
 at java.util.UUID.toString(UUID.java:379)
 at ConstantGCOverheadLimitExceeded.main(ConstantGCOverheadLimitExceeded.java:23)
 5055K->751K(5632K), 0.0137249 secs]
 Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=1M; support was removed in 8.0

 运行时常量池溢出

 */
public class ConstantGCOverheadLimitExceeded {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        while(true){
            list.add(UUID.randomUUID().toString().intern());
        }
    }

}
