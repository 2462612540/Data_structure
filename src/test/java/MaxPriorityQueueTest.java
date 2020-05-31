import Queue.MaxPriorityQueue;
import Queue.MinPriorityQueue;
import org.junit.Test;

/**
 * Copyright (C), 2018-2020
 * FileName: MaxPriorityQueueTest
 * Author:   xjl
 * Date:     2020/5/24 20:36
 * Description: 测试
 */

public class MaxPriorityQueueTest {

    @Test
    public void test() {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue(10);

        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");

        while (!queue.isEmpty()) {
            String max = queue.delMax();
            System.out.println(max);
        }

    }

    @Test
    public void test1() {
        MinPriorityQueue<String> queue = new MinPriorityQueue(10);

        queue.insert("A");
        queue.insert("B");
        queue.insert("E");
        queue.insert("F");
        queue.insert("C");
        queue.insert("D");

        while (!queue.isEmpty()) {
            String min = queue.delMin();
            System.out.println(min);
        }
    }
}
