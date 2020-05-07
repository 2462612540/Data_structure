/**
 * Copyright (C), 2018-2020
 * FileName: yuesefu
 * Author:   xjl
 * Date:     2020/3/25 13:27
 * Description: 约瑟fu
 */
package Line_Demo;

public class yuesefu {
    private static class Node<T> {
        //存储数据
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //构建循环链表
        //记录首节点
        Node<Integer> frist = null;
        //记录当前节点
        Node pre = null;
        //count 计数器 模拟报数
        for (int i = 0; i <= 41; i++) {
            if (i == 1) {
                frist = new Node<Integer>(i, null);
                pre = frist;
                continue;
            }
            //如果不是第一个节点
            Node newnode = new Node(i, null);
            pre.next = newnode;
            pre = newnode;
            //如果是最后一个节点
            if (i == 41) {
                pre.next = frist;
            }
        }
        //计数器
        int count = 0;
        //遍历循环链表
        Node<Integer> n = frist;
        Node<Integer> before = null;
        while (n != n.next) {
            //模拟报数
            count++;
            //判断是否为3
            if (count == 3) {
                //如果是三则删除当前的调用 打印当前的节点 重置count=0
                before.next = n.next;
                System.out.println(n.item);
                count = 0;
            } else {
                //若如果是不是3 那就下一栋下一个节点
                before = n;
                n = n.next;
            }
        }
        System.out.println(n.item);
    }
}
