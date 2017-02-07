package com.performace.algorithm.kingdoms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * one dimensional kingdoms
 * @author xiaoxiong
 */
public class KingDoms {

    public static void main(String[] args) {
        String path = "G:\\performance\\performance\\java-algorithm\\src\\main\\java\\com\\performace\\algorithm\\kingdoms\\DataLine.txt";
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(inputStream);
        int t,n;//t表示数据组数，n表示一维数组的个数
        t = scanner.nextInt();
        for(int m=0;m<t;m++){
            n = scanner.nextInt();
            Region[] region = new Region[n];
            KingDoms kingDoms = new KingDoms();
            ArrayList<Region> MergeSec = new ArrayList<Region>();
            for(int i = 0;i<region.length;i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                region[i] = new Region(x,y);
            }
            kingDoms.quickSort(region, 0, n - 1);//排序
            kingDoms.merge(region, n, MergeSec);//数组取交集
            for(int i = 0;i<MergeSec.size();i++){
                System.out.println("所需炸弹所在数轴："+MergeSec.get(i).x);
            }
            System.out.println("摧毁整个一维王国所需总共的炸弹数量："+MergeSec.size());

        }

    }


    /**
     * 快速排序
     * 对一维数组以x为准进行从小到大排序
     */
    private void quickSort(Region[] regions, int low, int high){

        int i = low;
        int j = high;
        Region temp = regions[low];

        while(i < j){
            while(i < j && temp.x < regions[j].x)
                j--;
            if(i < j){
                regions[i] = regions[j];
                i++;
            }
            while(i < j && temp.x > regions[i].x)
                i++;
            if(i < j){
                regions[j] = regions[i];
                j--;
            }
        }
        regions[i] = temp;
        if(low < i)
            quickSort(regions, low, i - 1);
        if(high > j)
            quickSort(regions, j + 1, high);
    }
    /**
     * 冒泡排序依次比较交集取值x值最大，y值最小
     * 对排序后的数组取交集
     */
    private void merge(Region[] regions, int n, ArrayList<Region> MergeList){

        Region temp = regions[0];
        for(int i = 1; i < n; i++){
            if(temp.y >= regions[i].x){
                temp.x = regions[i].x;
                if(temp.y >= regions[i].y){
                    temp.y = regions[i].y;
                }
            }
            else if(temp.y < regions[i].x){
                MergeList.add(temp);
                temp = regions[i];
            }
        }
        MergeList.add(temp);//最后一个数据
    }

}
