package com.performance.base;
import java.util.Calendar;

/**
 * @author xiaoxiong
 * Long.valueOf("1000") 与 Long.parseLong("1000")
 * 1000次循环打印 性能:56:38左右， Long.parseLong("1000")性能高
 */
public class LongValueOfTest {

    public static void main(String[] args) {
        long ctimes = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < 1000; i++)
        {
            System.out.println(Long.valueOf("1000"));
        }
        long ctimes2 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ctimes2-ctimes);

        long ctimes3 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < 1000; i++)
        {
            System.out.println(Long.parseLong("1000"));
        }
        long ctimes4 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ctimes4-ctimes3);

    }
}
