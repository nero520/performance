package com.performace.algorithm.sort.inner.insert.binary;

/**
 * 折半插入排序算法
 * 复杂度分析： 最佳情况，即都已经排好序，则无需右移，此时时间复杂度为：O(n lg n)
 * 最差情况，全部逆序，此时复杂度为O(n^2)
 * 无法将最差情况的复杂度提升到O(n|logn)。
 * @author xiaoxiong
 */
public class BinaryInsertSort {

    public final static void main(String[] args){
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        binaryInsertSort(data);
        print(data);
    }


    public static void binaryInsertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
                 if (data[i] < data[i - 1]) {
                        // 缓存i处的元素值
                        int tmp = data[i];
                        // 记录搜索范围的左边界
                        int low = 0;
                        // 记录搜索范围的右边界
                        int high = i - 1;
                        while (low <= high) {
                                // 记录中间位置
                                 int mid = (low + high) / 2;
                                 // 比较中间位置数据和i处数据大小，以缩小搜索范围
                                 if (data[mid] < tmp) {
                                        low = mid + 1;
                                     } else {
                                         high = mid - 1;
                                     }
                             }
                        //将low~i处数据整体向后移动1位
                        for (int j = i; j > low; j--) {
                                 data[j] = data[j - 1];
                            }
                       data[low] = tmp;
                       print(data);
                   }
            }
    }



    public static void swap(int[] data,int i,int j){
        if(i == j ){
            return;
        }
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


}
