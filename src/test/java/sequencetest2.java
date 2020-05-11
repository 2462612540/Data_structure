import Line.Sequeue;
import org.junit.Test;

/**
 * Copyright (C), 2018-2020
 * FileName: sequencetest
 * Author:   xjl
 * Date:     2020/5/7 9:01
 * Description: 线性表的测试
 */

public class sequencetest2 {

    @Test
    public void test() {
        // 数据的扩容的的测试
        Sequeue<String> objectSequeue = new Sequeue<>(3);
        objectSequeue.insert("大哥");
        objectSequeue.insert("二哥");
        objectSequeue.insert("三歌");
        objectSequeue.insert("四个");

        for (Object s : objectSequeue) {
            System.out.println(s);
        }
        System.out.println("*********************************************");

    }
}
