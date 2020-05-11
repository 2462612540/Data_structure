/**
 * Copyright (C), 2018-2020
 * FileName: LinkListQueue
 * Author:   xjl
 * Date:     2020/3/19 13:52
 * Description: 队列元素
 */
package Queue;

/**
 * 定义一个节点的完毕
 */
public class LinkListQueue {
    //定义元素的个数和节点的头指针和指针
    private int size;
    private Node head;
    private Node tail;

    //构造函数
    public LinkListQueue(Node head, Node tial) {
        this.head = head;
        this.tail = tial;
    }

    //入队元素
    public Boolean emqueue(Object data) {
        Node node = new Node(data, null);
        if (tail == null) {
            tail = node;
            head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    //出队元素

    public Object dequeue() {
        if (head == null) {
            return null;
        }
        Object data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    static class Node {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
