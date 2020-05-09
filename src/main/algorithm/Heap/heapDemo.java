/**
 * Copyright (C), 2018-2020
 * FileName: heapDemo
 * Author:   xjl
 * Date:     2020/4/1 13:11
 * Description: 堆的API设计
 */
package Heap;

public class heapDemo<T extends Comparable<T>> {
    //用于存放数字的
    private T[] items;
    //用于存放柜堆中的个数的元素
    private int N;

    //构造函数
    public heapDemo(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.N = 0;
    }

    //成员方法
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //交换ij 的值
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //插入元素
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    //使用的是上浮算法
    public void swim(int k) {
        while (k > 1) {
            //比较当前的节点的和其他的父节点
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    //删除最大的元素
    public T delMax() {

        T max = items[1];
        //交换1和最大的元素
        exch(1, N);
        //删除最大的元素的删除
        items[N] = null;
        //元素个数减少
        N--;
        //通过元素的下层的方法让堆有序
        sink(1);
        return null;
    }

    //使用的是下浮算法
    public void sink(int k) {
        //通过循环不断的对比 去发现对当前的节点和其左字节点2K和右子节点的2k+1 若小于当前节点那么久交换位置
        while (2 * k <= N) {
            //获取当前节点的字节点的中的较大的节点
            int max;//记录较大的节点的索引
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }
            //比较当前的节点和加大的节点的值
            if (!less(k, max)) {
                break;
            }
            exch(k, max);
            //交换k的值
            k = max;
        }
    }
}
