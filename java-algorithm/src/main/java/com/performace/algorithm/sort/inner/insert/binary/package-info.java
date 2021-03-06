/**
 * 折半插入排序法，又称二分插入排序法，是直接插入排序法的改良版，
 * 设有一个序列a[0],a[1]...a[n];其中a[i-1]前是已经有序的,当插入时a[i]时,利用二分法搜索a[i]插入的位置
 * 也需要执行i-1趟插入，不同之处在于，第i趟插入，
 * 先找出第i+1个元素应该插入的的位置，假定前i个数据是已经处于有序状态。
 * 复杂度分析： 最佳情况，即都已经排好序，则无需右移，此时时间复杂度为：O(n lg n) 最差情况，全部逆序，此时复杂度为O(n^2)
 * 无法将最差情况的复杂度提升到O(n|logn)。
 *
 * @author xiaoxiong
 */
package com.performace.algorithm.sort.inner.insert.binary;