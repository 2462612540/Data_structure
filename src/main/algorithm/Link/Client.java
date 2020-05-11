/**
 * Copyright (C), 2018-2020
 * FileName: Client
 * Author:   xjl
 * Date:     2020/5/10 10:42
 * Description: 链表成环
 */
package Link;

import org.junit.Test;

public class Client {

    public class ListNode {
        //节点的成员变量必须是要为public
        public Integer value;
        public ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public ListNode test1(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;//这个是慢指针
            p2 = p2.next.next;//这个是快指针
            if (p1 == p2) {
                //说明有环了 并让慢指针寸头开始
                p1 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p1 == p2) return p1;
            }
        }
        return null;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(3);
        ListNode s2 = new ListNode(5);
        ListNode s3 = new ListNode(9);
        ListNode s4 = new ListNode(7);
        ListNode s5 = new ListNode(3);
        ListNode s6 = new ListNode(1);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;

        s6.next = s5;

        ListNode listNode = test1(s1);
        System.out.println(listNode.value);
    }

}
