/**
 * Copyright (C), 2018-2020
 * FileName: deleteNode
 * Author:   xjl
 * Date:     2020/5/10 14:56
 * Description: 删除制指定的节点
 */
package Link_Demo;

import org.junit.Test;

public class deleteNode {
    public class ListNode {
        //节点的成员变量必须是要为public
        public Integer value;
        public ListNode next;

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public ListNode deleteNode1(ListNode head, int val) {

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode temp = head;
        ListNode index = result;

        while (temp != null) {
            if (temp.value == val) {
                temp = temp.next;
                index.next = temp;
            } else {
                temp = temp.next;
                index = index.next;
            }
        }
        return result.next;
    }

    public ListNode deleteNode(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(1);
        index.next = pHead;
        result = index;
        while (temp != null) {
            if (temp.next != null && temp.next.value == temp.value) {
                while (temp.next != null && temp.next.value == temp.value) {
                    temp = temp.next;
                }
                temp = temp.next;
                index.next = temp;
            } else {
                index = index.next;
                temp = temp.next;
            }
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(4);
        ListNode s2 = new ListNode(5);
        ListNode s3 = new ListNode(1);
        ListNode s4 = new ListNode(1);
        ListNode s5 = new ListNode(3);
        ListNode s6 = new ListNode(5);
        ListNode s7 = new ListNode(9);
        ListNode s8 = null;

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;
        s7.next = s8;

        ListNode res = deleteNode1(s1, 9);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}
