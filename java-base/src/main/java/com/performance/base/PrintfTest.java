package com.performance.base;
import java.util.Calendar;

/**
 * @author xiaoxiong
 *  换行符 System.out.printf("Read %s as %s\n", "/test", "value") 与  System.out.printf("Read %s as %s%n", "/test", "value")
 * 1000次循环打印 性能:250:165左右， System.out.printf("Read %s as %s%n", "/test", "value")性能高
 */
public class PrintfTest {

    public static void main(String[] args) {
        long ctimes = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < 1000; i++)
        {
            System.out.printf("Read %s as %s\n", "/test", "value");
        }
        long ctimes2 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ctimes2-ctimes);

        long ctimes3 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < 1000; i++)
        {
            System.out.printf("Read %s as %s%n", "/test", "value");
        }
        long ctimes4 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ctimes4-ctimes3);

    }
}
