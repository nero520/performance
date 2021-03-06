/**
桶式排序不再是一种基于比较的排序方法，它是一种比较巧妙的排序方式，但这种排序方式需要待排序的序列满足以下两个特征：
 待排序列所有的值处于一个可枚举的范围之类；
 待排序列所在的这个可枚举的范围不应该太大，否则排序开销太大。
 排序的具体步骤如下：
 （1）对于这个可枚举范围构建一个buckets数组，用于记录“落入”每个桶中元素的个数；
 （2）将（1）中得到的buckets数组重新进行计算，按如下公式重新计算：
 buckets[i] = buckets[i] +buckets[i-1] (其中1<=i<buckets.length);
 桶式排序是一种非常优秀的排序算法，时间效率极高，它只要通过2轮遍历：第1轮遍历待排数据，统计每个待排数据“落入”各桶中的个数，第2轮遍历buckets用于重新计算buckets中元素的值，2轮遍历后就可以得到每个待排数据在有序序列中的位置，然后将各个数据项依次放入指定位置即可。
 桶式排序的空间开销较大，它需要两个数组，第1个buckets数组用于记录“落入”各桶中元素的个数，进而保存各元素在有序序列中的位置，第2个数组用于缓存待排数据。
 桶式排序是稳定的。
 如果待排序数据的范围在0~k之间，那么它的时间复杂度是O(k+n)的
 桶式排序算法速度很快，因为它的时间复杂度是O(k+n)，而基于交换的排序时间上限是nlg n。
 但是它的限制多，比如它只能排整形数组。而且当k较大，而数组长度n较小，即k>>n时，辅助数组C[k+1]的空间消耗较大。
 当数组为整形，且k和n接近时, 可以用此方法排序。

 * @author xiaoxiong
 */
package com.performace.algorithm.sort.inner.bucket;



