package com.performace.algorithm.sort.inner.select.direct;

/**
 直接选择排序
  1.  时间复杂度：O(n^2)
 直接选择排序耗时的操作有：比较 + 交换赋值。时间复杂度如下：
 1)   最好情况：序列是升序排列，在这种情况下，需要进行的比较操作需n(n-1)/2次。交换赋
 值操作为0次。即O(n^2)
 2)   最坏情况：序列是降序排列，那么此时需要进行的比较共有n(n-1)/2次。交换赋值n-1
 次（交换次数比冒泡排序少多了），选择排序的效率比较稳定，最好情况和最坏情况差
 不多。即O(n^2)
 3)   渐进时间复杂度（平均时间复杂度）：O(n^2)
 2.   空间复杂度：O(1)
 3.  稳定性
 直接选择排序是不稳定的。
 因为每次遍历比较完后会使用本次遍历选择的最小元素和无序区的第一个元素交换位置，
 所以如果无序区第一个元素后面有相同元素的，则可能会改变相同元素的相对顺序。
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
