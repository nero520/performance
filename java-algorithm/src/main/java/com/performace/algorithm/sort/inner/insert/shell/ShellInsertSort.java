package com.performace.algorithm.sort.inner.insert.shell;

/**
 * 希尔排序
 *希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，当增量减至1时，整个文件恰被分成一组，算法便终止。
 步骤：
 将N个元素的数组分成N/2个数字序列，第i个数据和第N/2+i个数据为一组每一组进行插入排序；
 将上面排序后的数组分成N/4（取整）个数字序列，第i个数据和第N/4+i,N/2+i,3N/4+i为一组,每一组分别进行插入排序
 。。。
 直到N/（2^n）取整为1整个数组分到同一个数列，进行最后一次直接插入排序得到一个递增的数组
 * @author xiaoxiong
 */
public class ShellInsertSort {

    public final static void main(String[] args){
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        shellInsertSort(data);
        print(data);
    }

    public static void shellInsertSort(int[] data) {
        // 计算出最大的h值
        int h = 1;
        while (h <= data.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < data.length; i += h) {
                if (data[i] < data[i - h]) {
                    int tmp = data[i];
                    int j = i - h;
                    while (j >= 0 && data[j] > tmp) {
                        data[j + h] = data[j];
                        j -= h;
                    }
                    data[j + h] = tmp;
                    print(data);
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
    }


    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


}
