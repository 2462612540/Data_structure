/**
 * Copyright (C), 2018-2020
 * FileName: MAP
 * Author:   xjl
 * Date:     2020/3/25 16:23
 * Description: map的实现
 */
package Map;

public class OrderMAP<Key extends Comparable<Key>, Value> {
    //记录首节点
    private Node head;
    //记录符号中的元素的个数
    private int N;

    private class Node {
        //键
        public Key key;
        //值
        private Value value;
        //下一个节点
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderMAP() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        Node pre = head;

        Node curr = pre;
        Node index = curr.next;

        while (index != null) {
            if (index.key == key) {
                index.value = value;
                return;
            } else if (index.key.compareTo(key) > 0) {
                Node node = new Node(key, value, null);
                curr.next = node;
                node.next = index;
                return;
            }
            index = index.next;
            curr = curr.next;
        }
        curr.next = new Node(key, value, null);
        //元素+1
        N++;
    }

    public void delete(Key key) {
        //找到key的值
        Node n = head;
        Node curr = n.next;
        while (curr.next != null) {
            if (curr.key == key) {
                n.next = curr.next;
                N--;
                return;
            }
            n = curr;
            curr = curr.next;
        }
    }

    public Value get(Key key) {
        Node pre = head;
        Node curr = pre.next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

}
