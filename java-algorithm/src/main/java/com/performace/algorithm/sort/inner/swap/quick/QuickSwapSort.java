package com.performace.algorithm.sort.inner.swap.quick;

/**
 快速排序算法
 时间复杂度
 最好情况（每次总是选到中间值作枢轴）T(n)=O(nlogn)(以2为底)
 最坏情况（每次总是选到最小或最大元素作枢轴）
 做n-1趟，每趟比较n-i次，总的比较次数最大：[O(n²)]
 平均时间复杂度为：：T(n)=O(nlogn)
 空间复杂度O(n)=O(nlogn)(以2为底)
 不稳定
 * @author xiaoxiong
 */
public class QuickSwapSort {

    public final static void main(String[] args){
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        quickSort(data, 0, data.length - 1);
        print(data);
    }

    public static void quickSort(int[] data, int start, int end) {
      if (start >= end)
          return;
        //以起始索引为分界点
      int pivot = data[start];
      int i = start + 1;
      int j = end;
      while (true) {
              while (i <= end && data[i] < pivot) {
                       i++;
                   }
                while (j > start && data[j] > pivot) {
                       j--;
                 }
                if (i < j) {
                    swap(data, i, j);
                  } else {
                     break;
                }
           }
        //交换 j和分界点的值
        swap(data, start, j);
        print(data);
        //递归左子序列
        quickSort(data, start, j - 1);
        //递归右子序列
        quickSort(data, j + 1, end);
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
