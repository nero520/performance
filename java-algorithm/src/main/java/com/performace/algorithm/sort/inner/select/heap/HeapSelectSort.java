package com.performace.algorithm.sort.inner.select.heap;

/**
 * 堆排序
 1.  时间复杂度：O(nlog2n)
 首先把数组，初始化成一个堆。这个阶段花费O(N)的时间，可以忽略。
 然后执行N次的删除最大元，每次最大元删除重排花费的时间为O(logn)，因此
 最差时间复杂：O(nlogn)
 最优时间复杂：O(nlogn)
 平均时间复杂：O(nlogn)
 2.   空间复杂度：O(1)
 3.  稳定性
 堆排序是不稳定的
 因为在初始化堆时，相同元素可能被分配到不同的父节点下，所以在反复调整堆过程中，可能会改变相同元素的相对顺序
 * @author xiaoxiong
 */
public class HeapSelectSort {

    public final static void main(String[] args){
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        heapSelectSortByBig(data);//按照大堆排序
        print(data);
    }

    /**
     * 堆排序是一种利用完全二叉树来解决问题的高效算法，合
     * 法的最大堆树要满足一个条件就是每一个结点值都要大于或等于它的孩子结点值。在一个数组中那专业法表示为：
     * arrays[i]>=arrays[2*i+1] && arrays[i]>=arrays[2*i+2];
     * @param data
     */
    public static void heapSelectSortByBig(int[] data){
        for(int i=0;i<data.length;i++){
            int lastIndex = data.length-1-i;
            initMaxHeap(data,lastIndex);
            swap(data,0,lastIndex);
        }
    }


    public static void initMaxHeap(int[] data,int lastIndex){
          for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
                     // 保存当前正在判断的节点
                  int k = i;
                    // 若当前节点的子节点存在
                    while (2 * k + 1 <= lastIndex) {
                          // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                           int biggerIndex = 2 * k + 1;
                          if (biggerIndex < lastIndex) {
                                  // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                                  if (data[biggerIndex] < data[biggerIndex + 1]) {
                                           // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                                         biggerIndex++;
                                     }
                             }
                           if (data[k] < data[biggerIndex]) {//arrays[i]>=arrays[2*i+1] && arrays[i]>=arrays[2*i+2];
                                  // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                                  swap(data, k, biggerIndex);
                                 k = biggerIndex;
                               } else {
                                     break;
                                }
                        }
                 }


    }



    public static void swap(int[] data,int i,int biggerIndex){
        if(i == biggerIndex ){
            return;
        }
        int temp = data[i];
        data[i] = data[biggerIndex];
        data[biggerIndex] = temp;
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

}
