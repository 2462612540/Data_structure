/**
 * Copyright (C), 2018-2020
 * FileName: MinPriorityQueue
 * Author:   xjl
 * Date:     2020/5/24 20:43
 * Description: 最小的队列
 */
package Queue;

public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    private int N;

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public T delMin() {
        T min = items[1];
        exch(1, N);
        N--;
        sink(1);
        return min;
    }

    public void swim(int k) {
        while (k > 1) {
            if (less(k, k / 2)) {
                exch(k, k / 2);
            }
            k = k / 2;
        }
    }

    public void sink(int k) {
        //通过循环的比较的较小的值
        while (2 * k <= N) {
            //找到子节点中的较小的值
            int min;
            if (2 * k + 1 <= N) {
                if (less(2 * k, 2 * k + 1)) {
                    min = 2 * k;
                } else {
                    min = 2 * k + 1;
                }
            } else {
                min = 2 * k;
            }
            //判断当前的节点和较小的值
            if (less(k, min)) {
                break;
            }
            exch(k, min);
            k = min;
        }
    }

}
