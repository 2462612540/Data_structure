import Queue.QueueArray;
import org.junit.Test;

/**
 * Copyright (C), 2018-2020
 * FileName: QueueArrayTest
 * Author:   xjl
 * Date:     2020/5/11 13:58
 * Description: 数组来实现队列
 */

public class QueueArrayTest {
    @Test
    public void test() {
        QueueArray queueArray = new QueueArray();

        System.out.println(queueArray.size());

        queueArray.push(1);
        queueArray.push(2);
        queueArray.push(3);

        System.out.println(queueArray.isEmpty());
        System.out.println(queueArray.size());

        System.out.println("----------------------");
        queueArray.push(4);
        queueArray.push(5);
        queueArray.push(6);
        queueArray.push(7);
        queueArray.push(8);
        queueArray.push(9);
        queueArray.push(10);
        queueArray.push(11);
        queueArray.push(12);
        System.out.println(queueArray.size());
        queueArray.show();
        System.out.println();
        System.out.println("----------------------------");
        int pop = queueArray.pop();
        System.out.println(pop);
        System.out.println(queueArray.pop());
        System.out.println("----------------------------");
        queueArray.show();
    }
}
