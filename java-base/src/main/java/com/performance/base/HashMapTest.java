package com.performance.base;
import java.util.*;

/**
 * @author xiaoxiong
 * HashMap.keySet() �� HashMap.entrySet()
 * 1000��ѭ����ӡ ����:93   62    58:38  38   38���ң� HashMap.entrySet()���ܸ�
 */
public class HashMapTest {
    public static void main(String[] args)
    {
        HashMap<String,String> kmap = new HashMap<String,String>();
        HashMap<String, String> emap = new HashMap<String, String>();

        for (int i = 0; i < 1000; i++)
        {
            kmap.put(""+i, "VALUE");
        }
        for (int i = 0; i < 1000; i++)
        {
            emap.put(""+i, "VALUE");
        }

        long stimes = System.currentTimeMillis();
        long ctimes = Calendar.getInstance().getTimeInMillis();
        long dtimes = new Date().getTime();

        //��ʼʱ�� ������������ȡֵ��ʽ �����System.currentTimeMillis();����ֱ�ӵ�ȡֵ����
        System.out.println("��ʼ��ʱ�䣺"+stimes+" "+ctimes+"  "+dtimes);

        Iterator<String> ktor = kmap.keySet().iterator();
        while(ktor.hasNext())
        {
            System.out.println(kmap.get(ktor.next()));
        }

        long stimes1 = System.currentTimeMillis();
        long ctimes1 = Calendar.getInstance().getTimeInMillis();
        long dtimes1 = new Date().getTime();

        //����ʱ�䲢��Ҳ��entrySet�Ŀ�ʼʱ��
        System.out.println(stimes1+"    "+ctimes1+" "+dtimes1);
        System.out.println("kmap.keySet():"+(stimes1-stimes)+"   "+(ctimes1-ctimes)+"    "+(dtimes1-dtimes));


        long stimes2 = System.currentTimeMillis();
        long ctimes2 = Calendar.getInstance().getTimeInMillis();
        long dtimes2 = new Date().getTime();

        Iterator<Map.Entry<String, String>> itor = emap.entrySet().iterator();
        while(itor.hasNext())
        {
            Map.Entry<String, String> e = itor.next();
            //System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        long stimes3 = System.currentTimeMillis();
        long ctimes3 = Calendar.getInstance().getTimeInMillis();
        long dtimes3 = new Date().getTime();
        System.out.println(stimes3+"    "+ctimes3+" "+dtimes3);
        System.out.println("emap.entrySet():"+(stimes3-stimes2)+"  "+(ctimes3-ctimes2)+"   "+(dtimes3-dtimes2));
    }
}