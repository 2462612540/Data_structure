/**
 * Copyright (C), 2018-2020
 * FileName: QueueLink
 * Author:   xjl
 * Date:     2020/3/25 15:55
 * Description: 队列实现
 */
package Queue;

import java.util.Iterator;

public class QueueLink<T> implements Iterable {
    //记录首节点
    private Node head;
    //记录最后一个节点
    private Node last;
    //记录队列中元素的个数
    private int N;

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    //构造函数
    public QueueLink() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    //成员函数
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        //当前的节点为空
        if (last == null) {
            last = new Node(t, null);
            head.next = last;
        } else {
            //当前的节点不为空
            Node oldnode = last;
            last = new Node(t, null);
            oldnode.next = last;
        }
        N++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node oldfrist = head.next;
        head.next = oldfrist.next;
        N--;
        //因为出队是在删除元素 如果是在队列中元素被删除了那就需要是的last=null;
        if (isEmpty()) {
            last = null;
        }
        return oldfrist.item;
    }

    @Override
    public Iterator iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator {
        private Node n;

        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }

        @Override
        public void remove() {

        }
    }
}
