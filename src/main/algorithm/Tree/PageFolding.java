/**
 * Copyright (C), 2018-2020
 * FileName: PageFolding
 * Author:   xjl
 * Date:     2020/3/27 14:33
 * Description: 折纸的过程
 */
package Tree;

import java.util.TreeMap;

public class PageFolding {
    public static void main(String[] args) {
        //模拟产生的过程 产生一个树
        TreeMap treeMap=new TreeMap();
        treeMap.put(1,"张1");
        treeMap.put(2,"张2");
        treeMap.put(3,"张3");
        System.out.println(treeMap.size());

        //通过层序遍历来实现

    }
}
