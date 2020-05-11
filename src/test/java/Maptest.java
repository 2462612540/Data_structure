/**
 * Copyright (C), 2018-2020
 * FileName: Maptest
 * Author:   xjl
 * Date:     2020/3/25 16:56
 * Description: map测试
 */

import Map.MAP;
import Map.OrderMAP;

public class Maptest {

    public static void main(String[] args) {
        MAP<Integer, String> MAP = new MAP();
        MAP.put(1, "张三");
        MAP.put(2, "李四");
        MAP.put(3, "赵六");
        MAP.put(4, "七");
        MAP.put(5, "八");
        System.out.println(MAP.size());
        System.out.println("*********************");
        System.out.println(MAP.get(1));
        System.out.println("*********************");
        System.out.println(MAP.get(2));
        MAP.put(3, "庄小焱");
        System.out.println(MAP.get(3));
        MAP.delete(3);
        System.out.println("#################################");
        System.out.println(MAP.get(3));
        System.out.println("----------------------------------");
        MAP.put(3, "小影");
        System.out.println(MAP.get(3));

        OrderMAP orderMAP = new OrderMAP();
        orderMAP.put(1, "张1");
        orderMAP.put(3, "张3");
        orderMAP.put(8, "张8");
        orderMAP.put(2, "张2");
        orderMAP.put(9, "张9");
        orderMAP.put(4, "张4");

    }

}
