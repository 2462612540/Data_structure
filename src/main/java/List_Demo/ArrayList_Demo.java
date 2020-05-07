/**
 * Copyright (C), 2018-2020
 * FileName: ArrayList_Demo
 * Author:   xjl
 * Date:     2020/3/18 14:44
 * Description: 数组的原理
 */
package List_Demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_Demo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        //获取第二个位置的大小
        Object o = list.get(2);
        System.out.println(o);
    }
}
