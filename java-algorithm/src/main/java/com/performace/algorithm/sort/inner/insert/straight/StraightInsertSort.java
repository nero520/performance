package com.performace.algorithm.sort.inner.insert.straight;

/**
 直接插入排序
 直接插入的时间效率并不高，如果在最坏的情况下，所有元素的比较次数总和为（0+1+...+n-1）=O(n^2)。
 其他情况下也要考虑移动元素的次数，故时间复杂度为O(n^2)
 直接插入空间效率很好，只需要1个缓存数据单元，也就是说空间复杂度为O(1).
 直接插入排序是稳定的。
 直接插入排序在数据已有一定顺序的情况下，效率较好。但如果数据无规则，则需要移动大量的数据，其效率就与冒泡排序法和选择排序法一样差了。
 * @author xiaoxiong
 */
public class StraightInsertSort {

    public final static void main(String[] args){
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        straightInsertSort(data);
        print(data);
    }

    public static void straightInsertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                  swap(data,j-1,j);
                  print(data);
                }
            }
            System.out.println(i+"====");
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
