package com.performace.algorithm.sort.inner.select.direct;

/**
 * 直接选择排序
 * 算法不稳定，
 * O(1)的额外的空间
 * 比较的时间复杂度为O(n^2)
 * 交换的时间复杂度为O(n)
 * @author xiaoxiong
 */
public class DirectSelectSort {

    public final static void main(String[] args){
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        directSelectSort(data);
        print(data);
    }

    public static void directSelectSort(int[] data){
        for(int i=0;i<data.length-1;i++){
            int minidx = i;
            for(int j = i+1;j<data.length;j++){
                if(data[j]<data[minidx]){
                    minidx = j;
                }
            }
            if(minidx != i){
             swap(data,i,minidx);
            }
        }
    }

    public static void swap(int[] data,int i,int minidex){
        if(i == minidex ){
            return;
        }
        int temp = data[i];
        data[i] = data[minidex];
        data[minidex] = temp;
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
                  System.out.print(data[i] + "\t");
        }
        System.out.println();
    }






}
