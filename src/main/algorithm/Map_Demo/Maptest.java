/**
 * Copyright (C), 2018-2020
 * FileName: Maptest
 * Author:   xjl
 * Date:     2020/3/25 16:56
 * Description: map测试
 */
package Map_Demo;

public class Maptest {

    public static void main(String[] args) {
        Map_My<Integer, String> map_my=new Map_My();
        map_my.put(1,"张三");
        map_my.put(2,"李四");
        map_my.put(3,"赵六");
        map_my.put(4,"七");
        map_my.put(5,"八");
        System.out.println(map_my.size());
        System.out.println(map_my.get(3));
    }

}
