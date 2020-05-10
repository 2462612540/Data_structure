/**
 * Copyright (C), 2018-2020
 * FileName: reverse
 * Author:   xjl
 * Date:     2020/3/18 16:21
 * Description: 翻转链表
 */
package Link_Demo;

import org.junit.Test;

public class reverse {

    public class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode node = curr.next;
            curr.next = pre;
            pre = curr;
            curr = node;
        }
        return pre;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode curr = pre;
        while (curr != null) {
            ListNode node = curr.next;
            if (node.next != null) {
                if (node.val == val) {
                    curr.next = node.next;
                } else {
                    curr = curr.next;
                }
            } else {
                if (node.val == val) {
                    curr.next = null;
                    return pre;
                } else {
                    curr = curr.next;
                }
            }
        }
        return pre.next;
    }

    @Test
    public void test1() {
        ListNode s1 = new ListNode(4);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(8);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(1);
        ListNode s6 = new ListNode(6);
        ListNode s7 = new ListNode(4);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;

        ListNode res = removeElements(s1, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(2);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(4);
        s1.next = s2;
        s2.next = s3;

        ListNode re = reverse(s1);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

}


