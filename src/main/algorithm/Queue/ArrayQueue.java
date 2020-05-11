/**
 * Copyright (C), 2018-2020
 * FileName: ArrayQueue
 * Author:   xjl
 * Date:     2020/3/19 11:00
 * Description: 队列
 */
package Queue;

/**
 * 顺序队列
 * 队列的操作是基于数据来实现的
 * 定义了队列的基本的结构：数组的默认的大小 数组的长度 数组的头尾的指针
 * 定义了队列的相关的操作：入队和出队的操作。扩容的机制
 *
 */
public class ArrayQueue {

    //定义队列的一些结构
    //使用数组来存储我们队列的元素
    private Object[] elements;
    //定义队列的大小
    private int size;
    //定义队列的初始化容量
    private int DEFAULT_SIZE = 10;
    //定义尾最的容量的
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    //定义头指针
    private int head;
    //定义尾指针
    private int tail;

    /**
     * 定义一个默认的长度的10的队列
     */
    //定义结构上的操作
    public ArrayQueue() {
        elements = new Object[DEFAULT_SIZE];
        //初始化头尾指针
        this.intitpoint(0, 0);
    }

    //初始化头指针
    private void intitpoint(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    //用户自定义队列的大小
    public ArrayQueue(int capcity) {
        if (capcity <= 0) {
            throw new RuntimeException("error");
        }
        elements = new Object[capcity];
        this.intitpoint(0, 0);
    }

    /**
     * 入队列的操作
     */
    public boolean enqueue(Object element) {
        //判断的容量是否够用
        ensureSizeHelper();
        elements[tail++] = element;
        size++;
        return true;
    }

    /**
     * 出队列的操作
     */
    public Object dequeue() {
        if (head == tail) {
            return null;
        }
        Object object = elements[head++];
        size--;
        return object;
    }

    //动态的扩容的机制

    //判断队列的容量是否够用
    private void ensureSizeHelper() {
        //尾指针已经越过了队尾
        if (tail == elements.length) {
            if (size < elements.length) {
                if (head == 0) {
                    //扩容的操作
                } else {
                    for (int i = head; i < tail; i++) {
                        elements[i - head] = elements[i];
                    }
                    intitpoint(0, tail - head);
                }
            }
        }
    }

    //扩容的方法
    private void grow(int oldsize) {
        int newSize = oldsize + (oldsize >> 1);//扩容了1.5倍
        if (newSize - oldsize < 0) {
            newSize = DEFAULT_SIZE;
        }
        if (newSize - MAX_ARRAY_SIZE > 0) {
            newSize = capityFinal(newSize);
        }
    }

    private int capityFinal(int newSize) {
        return (newSize > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE - 8 : newSize;
    }

}
