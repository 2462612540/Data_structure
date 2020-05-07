/**
 * Copyright (C), 2018-2020
 * FileName: reverseList
 * Author:   xjl
 * Date:     2020/3/18 16:21
 * Description: 翻转链表
 */
package List_Demo;

public class reverseList {
    public static void main(String[] args) {
        ListNode prve=new ListNode(2);
        ListNode prve1=new ListNode(2);
        ListNode prve2=new ListNode(2);
        prve.next=prve1;
        prve1.next=prve2;

        ListNode node=null;
        System.out.println("pre"+prve);
        System.out.println("node="+node);
        System.out.println(prve1.next);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
