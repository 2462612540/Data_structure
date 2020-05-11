/**
 * Copyright (C), 2018-2020
 * FileName: QueueTest
 * Author:   xjl
 * Date:     2020/3/19 13:42
 * Description: 队列的实现
 */

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        //查看是否包含一个元素
        System.out.println(queue.contains("d"));
        //出队的操作的函数
        queue.add("f");
        System.out.println(queue.remove());
        System.out.println(((LinkedList<String>) queue).get(2));
        System.out.println("******************************************");
        //遍历整队列的元素
        for (String value : queue) {
            System.out.println(value);
        }
    }
}
