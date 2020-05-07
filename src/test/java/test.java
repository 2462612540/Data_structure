import Line_Demo.Sequeue;
import org.junit.Test;

/**
 * Copyright (C), 2018-2020
 * FileName: test
 * Author:   xjl
 * Date:     2020/3/25 9:20
 * Description: 测试
 */

public class test {
    @Test
    public void test() {
        //创建对象
        Sequeue a = new Sequeue(3);
        //插入
        a.insert("庄小焱1");
        a.insert("庄小焱2");
        a.insert("庄小焱3");
        a.insert("庄小焱4");
        a.insert("庄小焱5");
        a.insert(2, "林小影1***********");
        System.out.println(a.length());
        a.insert(3, "林小影2***********");
        a.insert(3, "林小影3***********");
        a.insert(3, "林小影4***********");
        System.out.println(a.length());
        for (Object s : a) {
            System.out.println(s.toString());
        }
//        System.out.println("************************************");
//        System.out.println(a.get(3));
//        System.out.println(a.remove(3));
//        a.clear();
//        System.out.println(a.length());
    }
}
