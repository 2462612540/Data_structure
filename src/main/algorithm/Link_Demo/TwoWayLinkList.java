/**
 * Copyright (C), 2018-2020
 * FileName: TwoWayLinkList
 * Author:   xjl
 * Date:     2020/3/25 11:49
 * Description: 双向链表
 */
package Link_Demo;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable {
    //头节点
    private Node head;
    //尾结点
    private Node last;
    //链表的长度
    private int N;

    public Iterator iterator() {
        return new TIteraotr();
    }

    private class TIteraotr implements Iterator {
        private Node n;

        public TIteraotr() {
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

    //成员类
    private class Node<T> {
        //元素
        private T item;
        //前指针
        private Node pre;
        //后指针
        private Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    //构造函数

    public TwoWayLinkList() {
        this.head = new Node(null, null, null);
        this.last = new Node(null, null, null);
        this.N = 0;
    }

    //成员函数
    //空置线性表
    public void clear() {
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }

    //判断是否为空
    public Boolean isEmpty() {
        return N == 0;
    }

    //获取一个元素
    public int length() {
        return N;
    }

    //插入一个元素
    public void insert(T t) {
        //如果链表为空
        if (isEmpty()) {
            //创建一个新的节点
            Node newnode = new Node<T>(t, head, null);
            //让新及节点成为尾节点
            last = newnode;
            //让头节点指向尾节点
            head.next = last;
        } else {
            //如果链表不为空
            Node oldlast = last;
            //创建一个新的节点
            Node newnode = new Node<T>(t, oldlast, null);
            //让当前的尾节点指向新的节点
            oldlast.next = newnode;
            //让新的节点成为尾节点
            last = newnode;
        }
        N++;
    }

    //指定的位置插入元素
    public void insert(T t, int i) {
        Node pre = head;
        //找到i-1位置的节点
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        //当前位置的节点
        Node curr = pre.next;
        //创建一个新建节点指向i的前一个的next 新建节点前一个指向i的前一个
        Node newnode = new Node(t, pre, curr);
        //i-1的位置的写一个值新的节点
        pre.next = newnode;
        //i的前一一个指是的新的节点
        curr.pre = newnode;
        //元素加1
        N++;
    }

    //删除元素
    public T remove(int i) {
        //找到i-1的位置
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        //找到i的节点
        Node curr = pre.next;
        //找到下一个节点
        Node nextnode = curr.next;
        //i的前一个节点指向i的后一个节点
        pre.next = nextnode;
        //让i的后一个节点指向i的前一个节点
        nextnode.pre = pre;
        //元素减少1
        N--;
        return (T) curr.item;
    }

    public T get(int i) {
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return (T) n.item;
    }

    //首次出现的元素的位置
    public int indexof(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item == t) {
                return i;
            }
        }
        return -1;
    }

    //获取第一个元素
    public T getFrist() {
        //判断时候是否为空节点
        if (isEmpty()) {
            return null;
        }
        return (T) head.next.item;
    }

    //获取最后的一个元素
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return (T) last.item;
    }
}
