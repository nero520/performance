package com.performace.gui.sort.inner.bucket;

import java.util.ArrayList;
import java.util.List;

public class SortUtils {
    private static int length=20;
    private int[] dataList;
    private List<SortEntity> quickList=new ArrayList<SortEntity>();;
    private List<SortEntity> bubbleList=new ArrayList<SortEntity>();;
    private List<SortEntity> shellList=new ArrayList<SortEntity>();;

    public int[] getDataList() {
        return dataList;
    }

    public void setDataList() {
        dataList = new int[length];

        boolean flag=false;
        int temp;
        int index = 0;
        while(index < length){
            temp = (int)(Math.random()*length)+1;
            //Check the same element
            for(int j=0;j<index;j++){
                if(temp == dataList[j]){
                    flag=true;
                    break;
                }
                else{
                    flag = false;
                }
            }
            if(!flag ){
                dataList[index++] = temp;
            }
        }
    }

    /**
     * 对初始数组进行赋值
     */
    public SortUtils(){
        setDataList();
    }
    /**
     * 得到快速排序的结果集
     * @return
     */
    public List<SortEntity> getQuickList(){
        quickSort(getDataList(),0,length-1);
        return quickList;
    }

    /**
     * 得到冒泡排序结果集
     * @return
     */
    public List<SortEntity> getBubbleList() {
        bubbleList.add(new SortEntity(getDataList(), 0, 1, 0));
        bubbleSort(getDataList());

        return bubbleList;
    }

    /**
     * 得到希尔排序的结果集
     * @return
     */
    public List<SortEntity> getShellList() {
        shellList.add(new SortEntity(getDataList(), 0, 1, 0));
        shellSort(getDataList());
        return shellList;
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(int[] arr,int left,int right) {
        if(left>right){
            return;
        }
        int pivot=arr[left];
        quickList.add(new SortEntity(arr, left, right, pivot));

        //定义基准值为数组第一个数
        int i=left;
        int j=right;
        while(i<j) {
            //从右往左找比基准值小的数
            while(pivot<=arr[j]&&i<j){
                j--;
                quickList.add(new SortEntity(arr, left, right, pivot));
            }
            //从左往右找比基准值大的数
            while(pivot>=arr[i]&&i<j){
                i++;
                quickList.add(new SortEntity(arr, left, right, pivot));
            }
            //如果i<j，交换它们
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                quickList.add(new SortEntity(arr, left, right, pivot));
            }
        }
        //把基准值放到合适的位置
        arr[left]=arr[i];
        arr[i]=pivot;
        //对左边的子数组进行快速排序
        quickSort(arr,left,i-1);
        //对右边的子数组进行快速排序
        quickSort(arr,i+1,right);
    }
    /**
     * 冒泡排序
     * @param arr
     */
    public void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){//外层循环控制排序趟数
            for(int j=0;j<arr.length-1-i;j++){//内层循环控制每一趟排序多少次
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                bubbleList.add(new SortEntity(arr, i, j, 0));
            }
        }
    }
    /**
     * 希尔排序
     * @param arr
     */
    public void shellSort(int[] arr){
        //增量
        int incrementNum = arr.length/2;
        while(incrementNum >=1){
            for(int i=0;i<arr.length;i++){
                //进行插入排序
                for(int j=i;j<arr.length-incrementNum;j=j+incrementNum){
                    if(arr[j]>arr[j+incrementNum]){
                        int temple = arr[j];
                        arr[j] = arr[j+incrementNum];
                        arr[j+incrementNum] = temple;
                    }
                    shellList.add(new SortEntity(arr, i, j, 0));
                }
            }
            //设置新的增量
            incrementNum = incrementNum/2;
        }
    }
}
