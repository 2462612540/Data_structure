/**
 * Copyright (C), 2018-2020
 * FileName: Qtest
 * Author:   xjl
 * Date:     2020/3/25 16:11
 * Description: 测试队列的元素
 */
package Queue_Demo;

import org.junit.Test;

public class Qtest {
    @Test
    public void test() {
        //创建一个队列
        Queue<String> queue = new Queue();
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.push("d");
        System.out.println(queue.size());
        for (int i = 0; i < 4; i++) {
            System.out.println(queue.pop());
        }
    }
}
