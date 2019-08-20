package com.performace.gui.sort.inner.bucket;
import java.util.Arrays;

public class SortEntity {

    public int[] dataList=new int[20];
    public int index_i;
    public int index_j;
    public int pivot=0;

    public int[] getDataList() {
        return dataList;
    }
    public void setDataList(int[] dataList) {
        for(int i=0;i<dataList.length;i++){
            this.dataList[i] = dataList[i];
        }
    }
    public int getIndex_i() {
        return index_i;
    }
    public void setIndex_i(int index_i) {
        this.index_i = index_i;
    }
    public int getIndex_j() {
        return index_j;
    }
    public void setIndex_j(int index_j) {
        this.index_j = index_j;
    }
    public int getPivot() {
        return pivot;
    }
    public void setPivot(int pivot) {
        this.pivot = pivot;
    }

    public SortEntity() {
    }
    public SortEntity(int[] dataList, int index_i, int index_j, int pivot) {
        for(int i=0;i<dataList.length;i++){
            this.dataList[i] = dataList[i];
        }
        this.index_i = index_i;
        this.index_j = index_j;
        this.pivot = pivot;
    }

    @Override
    public String toString() {
        return "SortEntity [dataList=" + Arrays.toString(dataList) + ", index_i=" + index_i + ", index_j=" + index_j
                + ", pivot=" + pivot + "]";
    }

}
