package com.performace.algorithm.sort.inner.radix;

import java.util.Arrays;

/**
 * ��������
 * @author xiaoxiong
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] data = new int[] { 1100, 192, 221, 12, 23 };
        print(data);
        radixSort(data, 10, 4);
        print(data);
    }

    public static void radixSort(int[] data, int radix, int d) {
        // ��������
        int[] tmp = new int[data.length];
        // buckets���ڼ�¼������Ԫ�ص���Ϣ
        // buckets���鶨����max-min��Ͱ
        int[] buckets = new int[radix];

        for (int i = 0, rate = 1; i < d; i++) {

            // ����count���飬��ʼͳ����һ���ؼ���
            Arrays.fill(buckets, 0);
            // ��data�е�Ԫ����ȫ���Ƶ�tmp������
            System.arraycopy(data, 0, tmp, 0, data.length);

            // ����ÿ�����������ݵ��ӹؼ���
            for (int j = 0; j < data.length; j++) {
                int subKey = (tmp[j] / rate) % radix;
                buckets[subKey]++;
            }

            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            // ���ӹؼ��ֶ�ָ�������ݽ�������
            for (int m = data.length - 1; m >= 0; m--) {
                int subKey = (tmp[m] / rate) % radix;
                data[--buckets[subKey]] = tmp[m];
            }
            rate *= radix;
        }

    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
