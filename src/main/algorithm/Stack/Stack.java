/**
 * Copyright (C), 2018-2020
 * FileName: Stack
 * Author:   xjl
 * Date:     2020/3/25 14:47
 * Description: 实现栈顶结构
 */
package Stack;

import java.util.Iterator;

/**
 * 基于链表的实现
 *
 * @param <T>
 */
public class Stack<T> implements Iterable {
    private Node head;//表示的节点
    private int N;//表示的是元素的个数

    private class Node {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null, null);
        N = 0;
    }

    //成员函数
    public Boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    //压栈
    public void push(T t) {
        //找到首节点指向的第一个元素
        Node oldfrist = head.next;
        //创建一个新的节点
        Node newnode = new Node(t, null);
        //让首节点指向新的节点
        head.next = newnode;
        //让新的节点指向原来的第一个节点
        newnode.next = oldfrist;
        //元素加1
        N++;
    }

    //出栈
    public T pop() {
        //找到首节点指向的第一节点
        Node oldfrist = head.next;
        if (oldfrist == null) {
            return null;
        }
        //让首节点指向原来的第一个节点的下一个节点
        Node newode = oldfrist.next;
        head.next = newode;
        //元素个数-1
        N--;
        return (T) oldfrist.item;
    }

    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node n;

        public SIterator() {
            this.n = head;
        }

        public boolean hasNext() {
            return n.next != null;
        }

        public Object next() {
            n = n.next;
            return n.item;
        }

        public void remove() {

        }
    }
}
