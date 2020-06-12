/**
 * Copyright (C), 2018-2020
 * FileName: QuickSort
 * Author:   xjl
 * Date:     2020/6/11 15:55
 * Description: 快速排序
 */
package Sort;

import java.util.Arrays;

public class QuickSort {
    //对数组的元素进行排序
    private static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    //对数组a中从索引lo到hi之间的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //需要对lo到hi的元素进行分组（左数组 右数组）
        int partition = partition(a, lo, hi);//返回的分界的索引
        //让左数组有序
        sort(a, lo, partition - 1);
        //让右数组有序
        sort(a, partition + 1, hi);
    }

    //对数组a中的从lo到hi之间的元素进行分组 并返回分组界限的对应的索引
    private static int partition(Comparable[] a, int lo, int hi) {
        //确定分界值
        Comparable key = a[lo];
        //定义两个指针 分别指向代切分的最小的元素的索引的下一个位置
        int left = lo;
        int right = hi + 1;
        //切分
        while (true) {
            //先从右向左扫描 移动right 找到一个分界值小的元素 停止
            while (less(key, a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            //在从左向右边扫描 移动left 找到一个分界值大的元素 停止
            while (less(key, a[++left])) {
                if (left == hi) {
                    break;
                }
            }
            //判断left是否大于right 如果是表示的扫描完毕 如果不是的交换元素就好
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }
        //把分割的点和第一元素进行交换
        exch(a, lo, right);
        return right;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Comparable[] array = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}