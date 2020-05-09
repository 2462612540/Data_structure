import Line_Demo.Sequeue;
import org.junit.Test;

/**
 * Copyright (C), 2018-2020
 * FileName: sequencetest
 * Author:   xjl
 * Date:     2020/5/7 9:01
 * Description: 线性表的测试
 */

public class sequencetest {

    @Test
    public void test() {
        Sequeue<String> objectSequeue = new Sequeue<>(10);
        objectSequeue.insert("大哥");
        objectSequeue.insert("二哥");
        objectSequeue.insert("三歌");
        objectSequeue.insert("四个");

        for (Object s:objectSequeue){
            System.out.println(s);
        }
        System.out.println("*********************************************");
        //总的元素的个数
        System.out.println(""+objectSequeue.length());

        //获取第一个位置的元素
        String s = objectSequeue.get(0);
        System.out.println(s);

        //删除第i位置的元素 并返回来
        String remove = objectSequeue.remove(3);
        System.out.println(objectSequeue.length());
        System.out.println(remove);

        objectSequeue.clear();
        System.out.println(objectSequeue.length());

    }
}
