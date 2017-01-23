#java-base基础测试环境<br />
操作系统:Windows10<br />
处理器:Intel(R) Core(TM) i5-5200 @ 2.20GHz 2.19GHz<br />
内存:8G<br />
JAVA版本:JDK1.7<br />
#java-base基础包测试模块<br />
###1. new Boolean("true") 与 Boolean.valueOf("true")<br />
1000次循环打印 性能70:40左右 Boolean.valueOf性能高<br />
###2. HashMap.keySet() 与 HashMap.entrySet()<br />
1000次循环打印 性能:93   62    58:38  38   38左右， HashMap.entrySet()性能高<br />
###3. Long.valueOf("1000") 与 Long.parseLong("1000")<br />
1000次循环打印 性能:56:38左右， Long.parseLong("1000")性能高<br />
###4. 换行符 System.out.printf("Read %s as %s\n", "/test", "value") 与  System.out.printf("Read %s as %s%n", "/test", "value")<br />
1000次循环打印 性能:250:165左右， System.out.printf("Read %s as %s%n", "/test", "value")性能高<br />