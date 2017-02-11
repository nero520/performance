package com.performace.algorithm.sort.inner.swap.bubble;

/**
 * 冒泡排序算法稳定，O(1)的额外的空间，比较和交换的时间复杂度都是O(n^2)，
 * 自适应，对于已基本排序的算法，时间复杂度为O(n)
 * 时间复杂度为O（n^2），虽然不及堆排序、快速排序的O（nlogn，底数为2）
 * @author xiaoxiong
 */
public class BubbleSwapSort {

    public final static void main(String[] args){
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        bubbleSort(data);
        print(data);
    }

    private static void bubbleSort(int[] data) {
        for(int i=0;i<data.length-1;i++){
            boolean isSort = false;//记录某趟是否发生交换，若为false表示数组已处于有序状态(优化版的应该可以不考虑也行)
            for(int j=0;j<data.length-1-i;j++){
                if(data[j]>data[j+1]){
                    swap(data,j,j+1);
                    isSort = true;
                }
            }
            if(!isSort){
                break;
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
