/**
 * Copyright (C), 2018-2020
 * FileName: Sequeuearr
 * Author:   xjl
 * Date:     2020/3/25 8:25
 * Description: 线性表
 */
package Line_Demo;

import java.util.Iterator;

/**
 * 其中就两个重要的元素
 * 一个数组
 * 一个N表示顺序表中的元素的的个数 初始化为0
 *
 * @param <T>
 */
public class Sequeue<T> implements Iterable {
    /**
     * 成员变量
     */
    private T[] eles;//存储元素的数组
    private int N;//表示线性表的元素的个数

    /**
     * 构造函数
     */
    public Sequeue(int n) {
        //初始化数组的长度
        this.eles = (T[]) new Object[n];
        //初始化长度
        this.N = 0;
    }

    /**
     * 成员函数
     */
    //清空链表
    public void clear() {
        this.N = 0;
    }

    //判断链表是否为空
    public Boolean isEmpty() {
        return N == 0;
    }

    //获取线性表中的元素个数
    public int length() {
        return N;
    }

    //获取第i个元素
    public T get(int i) {
        return eles[i];
    }

    //插入一个元素在线性表中
    public void insert(T t) {
        //判断是否需要进行扩容的操作
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        eles[N++] = t;
    }

    //插入在线性表中第i个位置
    public void insert(int i, T t) {
        if (N == eles.length) {
            resize(eles.length * 2);
        }
        //将i后面的元素一次向后移动
        for (int index = N; index >= i; index--) {
            eles[index] = eles[index - 1];
        }
        eles[i] = t;
        N++;

    }

    public void resize(int newsize) {
        //定义一个临时数组来指向原来的数组
        T[] temp = eles;
        //创建一个新的数组
        eles = (T[]) new Object[newsize];
        //把原来数组的拷贝到数组既可以
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }

    //移除某一个元素
    public T remove(int i) {
        //向前移动
        for (int index = i; i < N - 1; i++) {
            eles[index - 1] = eles[index];
        }
        N--;
        //判断是否需要缩容量
        if (N < eles.length / 4) {
            resize(eles.length / 2);
        }
        return eles[i];
    }

    //首次出现元素的位置
    public int indexof(T t) {
        for (int i = 0; i < N; i++) {
            if (t.equals(eles[i])) {
                return i;
            }
        }
        return 0;
    }

    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        public boolean hasNext() {
            return cusor < N;
        }

        public Object next() {
            return eles[cusor++];
        }

        public void remove() {

        }
    }
}
