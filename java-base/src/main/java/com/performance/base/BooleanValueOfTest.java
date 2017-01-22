package com.performance.base;
import java.util.Calendar;

/**
 * @author xiaoxiong
 * new Boolean("true") �� Boolean.valueOf("true")
 * 1000��ѭ����ӡ ����70:40���� Boolean.valueOf���ܸ�
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
