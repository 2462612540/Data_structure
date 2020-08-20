/**
 * Copyright (C), 2018-2020
 * FileName: JosephTest
 * Author:   xjl
 * Date:     2020/5/10 16:38
 * Description: 约瑟夫问题
 */
package Link;

import org.junit.Test;

/**
 * 主要是另个问题：1 如何成为一个环
 * 2 如何成为一个删除顶点的并保留到最后一个的节点
 */
public class JosephTest {
    public class ListNode {
        //节点的成员变量必须是要为public
        Integer value;
        ListNode next;

        public ListNode(Integer value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(Integer value) {
            this.value = value;
        }
    }

    public int test2() {
        //产生一个环
        ListNode frist = null;
        ListNode pre = null;
        for (int i = 1; i <= 41; i++) {
            if (i == 1) {
                frist = new ListNode(i, null);
                pre = frist;
                continue;
            }
            ListNode newnode = new ListNode(i, null);
            pre.next = newnode;
            pre = newnode;
            if (i == 41) {
                pre.next = frist;
            }
        }

        //模拟报数
        int count = 0;
        ListNode n = frist;
        ListNode before = null;
        while (n != n.next) {
            //模拟报数
            count++;
            if (count == 3) {
                //如果是3则是当前的节点
                before.next = n.next;
                System.out.print(n.value + " ");
                count = 0;
                n = n.next;
            } else {
                //判断当前的报数是不是3
                before = n;
                n = n.next;
            }
        }
        System.out.println(n.value);
        return n.value;
    }

    @Test
    public void test() {
        test2();
    }
}
