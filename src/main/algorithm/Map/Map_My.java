/**
 * Copyright (C), 2018-2020
 * FileName: Map_My
 * Author:   xjl
 * Date:     2020/3/25 16:23
 * Description: map的实现
 */
package Map;

public class Map_My<Key, Value> {
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

    public Map_My() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        Node n = head;
        //已经存在key中
        while (n.next != null) {
            //替换
            n = n.next;
            //判断首位key 如果是 那么需要替换n的节点中的
            if (n.key == key) {
                n.value = value;
                return;
            }
        }
        // 如果是存在相同的key  创建的节点的
        Node newnode = new Node(key, value, null);
        Node oldfrist = head.next;
        newnode.next = oldfrist;
        head.next = newnode;
        //元素+1
        N++;
    }

    public void delete(Key key) {
        //找到key的值
        Node n = head;
        while (n.next != null) {
            if (n.key == key) {
                //删除这个节点
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value get(Key key) {
        Node n = head;
        while (n.next != null) {
            if (n.key == key) {
                return n.value;
            }
            n = n.next;
        }
        return null;
    }

}
