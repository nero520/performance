java base test
============
java-base基础包测试模块
1. new Boolean("true") 与 Boolean.valueOf("true")
1000次循环打印 性能70:40左右 Boolean.valueOf性能高
2. HashMap.keySet() 与 HashMap.entrySet()
1000次循环打印 性能:93   62    58:38  38   38左右， HashMap.entrySet()性能高
3. Long.valueOf("1000") 与 Long.parseLong("1000")
1000次循环打印 性能:56:38左右， Long.parseLong("1000")性能高
4. 换行符 System.out.printf("Read %s as %s\n", "/test", "value") 与  System.out.printf("Read %s as %s%n", "/test", "value")
1000次循环打印 性能:250:165左右， System.out.printf("Read %s as %s%n", "/test", "value")性能高