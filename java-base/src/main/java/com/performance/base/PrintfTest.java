package com.performance.base;
import java.util.Calendar;

/**
 * @author xiaoxiong
 *  ���з� System.out.printf("Read %s as %s\n", "/test", "value") ��  System.out.printf("Read %s as %s%n", "/test", "value")
 * 1000��ѭ����ӡ ����:250:165���ң� System.out.printf("Read %s as %s%n", "/test", "value")���ܸ�
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
