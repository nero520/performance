package com.performance.base;
import java.util.Calendar;

/**
 * @author xiaoxiong
 * new Boolean("true") 与 Boolean.valueOf("true")
 * 1000次循环打印 性能70:40左右 Boolean.valueOf性能高
 */
public class BooleanValueOfTest {

    public static void main(String[] args) {
        long ctimes = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < 1000; i++)
        {
            System.out.println(new Boolean("true"));
        }
        long ctimes2 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ctimes2-ctimes);

        long ctimes3 = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < 1000; i++)
        {
            System.out.println(Boolean.valueOf("true"));
        }
        long ctimes4 = Calendar.getInstance().getTimeInMillis();
        System.out.println(ctimes4-ctimes3);

    }
}
