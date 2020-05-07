/**
 * Copyright (C), 2018-2020
 * FileName: LinkList_new
 * Author:   xjl
 * Date:     2020/3/25 10:57
 * Description: Arraylist的自定义
 */
package List_Demo;

import java.util.Iterator;

public class LinkList_new<T> implements Iterable {
    private Node head;//记录一个头结点
    private int N;//记录链表的长度

    //提供遍历的方式
    public Iterator iterator() {
        return new LinkIterator();
    }

    private class LinkIterator implements Iterator {
        private Node n;

        public LinkIterator() {
            this.n = head;
        }

        public boolean hasNext() {
            return n.nxet != null;
        }

        public Object next() {
            n = n.nxet;
            return n.item;
        }

        public void remove() {

        }
    }

    //成员变量
    private class Node<T> {
        T item;//存放数据的
        Node nxet;//存放时指针的，指向下一个

        public Node(T item, Node next) {
            this.item = item;
            this.nxet = next;
        }
    }

    //构造函数

    public LinkList_new() {
        //初始化头结点
        this.head = new Node(null, null);
        //初始化元素的个数
        this.N = 0;
    }

    //成员函数
    //清空链表
    public void clear() {
        head.nxet = null;
        this.N = 0;
    }

    //判断链表是否为空
    public Boolean isEmptry() {
        return N == 0;
    }

    //判断链表中的元素的个数
    public int length() {
        return N;
    }

    //读取第i个元素的值
    public T get(int i) {
        //通过循环 i次
        Node n = head.nxet;
        for (int index = 0; index < i; index++) {
            n = n.nxet;
        }
        return (T) n.item;
    }

    //添加元素
    public void insert(T t) {
        Node n = head;
        //找到最后一个
        while (n.nxet != null) {
            n = n.nxet;
        }
        //创建一个新的节点
        Node newnode = new Node(t, null);
        //让当前指向新的节点
        n.nxet = newnode;
        //元素加1
        N++;
    }

    //在i之前添加元素
    public void insert(int i, T t) {
        //找到i的前一个元素
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.nxet;
        }
        //找i的节点
        Node curr = pre.nxet;
        //创建新的节点 并且新的节点指向原来的节点  创建了新的节点并指向了原来的节点
        //Node newnode = new Node(t, null);
        //newnode.nxet=curr;
        Node newnode = new Node(t, curr);
        //原来的i的及节点指向新的节点既可以
        pre.nxet = newnode;
        //元素的个数+1
        N++;
    }

    //删除第i个元素
    public T remove(int i) {
        Node pre = head;
        //找打i-1出节点
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.nxet;
        }
        //找i的节点
        Node cu = pre.nxet;
        //i-1出的节点指向i的下一个节点
        pre.nxet = cu.nxet;
        //元素个数减1
        N--;
        return (T) cu.item;
    }

    //返回首次出现的元素
    public int indexof(T t) {
        //从节点开始遍历
        Node n = head;
        for (int i = 0; n.nxet != null; i++) {
            n = n.nxet;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        //判断是否为空链表
        if (isEmptry()) {
            return;
        } else {
            reverse(head.nxet);
        }
    }

    //反转指定的节点 并把反转后的节点返回
    public Node reverse(Node curr) {
        if (curr.nxet == null) {
            head.nxet = curr;
        }
        //递归表用反转当前的curr的下一个节点 返回值就会链表反转的后，当前的上的一个节点
        Node pre = reverse(curr.nxet);
        //返回的节点的下一个节点的当前的节点
        pre.nxet = curr;
        //把当前的节点的下一个节点变为null;
        curr.nxet = null;
        return curr;
    }
}
