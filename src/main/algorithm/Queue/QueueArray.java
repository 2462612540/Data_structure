/**
 * Copyright (C), 2018-2020
 * FileName: QueueArray
 * Author:   xjl
 * Date:     2020/5/10 22:36
 * Description: 数组实现的队列的这样的数据结构
 */
package Queue;

public class QueueArray {
    private int N;
    private Integer[] array;

    //默认是16个元素
    public QueueArray() {
        this.N = 0;
        array = new Integer[8];
    }

    //或者是自己指定元素的个数
    public QueueArray(int n) {
        this.N = 0;
        this.array = new Integer[n];
    }

    public void resize(int newsize) {
        Integer[] newarr = array;
        //扩容的函数
        this.array = new Integer[newsize];
        for (int i = 0; i < newarr.length; i++) {
            array[i] = newarr[i];
        }
    }

    //成员函数
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Integer t) {
        //当N<数组的大小的时候表示的是还有空余的数据
        if (N < array.length) {
            array[N++] = t;
        } else {
            //先进行扩容的函数操作
            resize(N * 2);
            //在来存取元素
            array[N++] = t;
        }
    }

    public int pop() {
        //将剩下的元素向前移动一位
        int res = array[N - 1];
        array[N - 1] = 0;
        N--;
        return res;
    }

    public void show() {
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }

}
