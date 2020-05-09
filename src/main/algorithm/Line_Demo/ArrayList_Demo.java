/**
 * Copyright (C), 2018-2020
 * FileName: ArrayList_Demo
 * Author:   xjl
 * Date:     2020/3/18 14:44
 * Description: 数组的原理
 */
package Line_Demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_Demo {
    public static void main(String[] args) {
        //采用的arraylist来实现动态数组来实现 这个是通用性数据结构
        // 考虑了多种安全性的问题和数据的在多线城下的数据安全的问题
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        System.out.println(list.size());

        //获取第二个位置的大小
        Object o = list.get(2);
        System.out.println(o);
    }

}
