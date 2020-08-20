/**
 * Copyright (C), 2018-2020
 * FileName: SelectionSort
 * Author:   xjl
 * Date:     2020/5/31 21:41
 * Description: 选择排序
 */
package Sort;

import org.junit.Test;

public class SelectionSort {
    /**
     * 选择排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            //定义一个变量 记录最小的所在的索引 默认是选择排序的第一个元素所在的位置的
            int minindex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (geeratr(a[minindex], a[j])) {
                    minindex = j;
                }
            }
            //交换最小的元素的位置的值
            exch(a, i, minindex);
        }
    }

    /**
     * 比较的函数
     *
     * @param V
     * @param W
     * @return
     */
    private static boolean geeratr(Comparable V, Comparable W) {
        return V.compareTo(W) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void test() {
        Comparable[] a = {1, 5, 8, 6, 12, 0, 58};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
