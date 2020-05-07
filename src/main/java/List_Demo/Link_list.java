/**
 * Copyright (C), 2018-2020
 * FileName: Link_list
 * Author:   xjl
 * Date:     2020/3/18 15:04
 * Description: 链表
 */
package List_Demo;

import java.util.Iterator;
import java.util.LinkedList;

public class Link_list {
    /**
     * 这是一个链表的
     * 存储是有元素和指针来指导的。
     *
     * 定义一个节点
     * 使用节点来表示链表
     *Linklist中使用时双向的链表
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> linklist = new LinkedList();
        linklist.add(2);
        linklist.add(3);
        linklist.add(5);

//        //利用是for循环的遍历
//        for (int i=0;i<linklist.size();i++){
//            System.out.println(linklist.get(i));
//        }

//        //使用新的遍历的方式
//        for(Integer va:linklist){
//            System.out.println(va);
//        }

        Iterator iterator1 = linklist.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("*************************************");
        //学会使用迭代器的使用
        for (Iterator iterator = linklist.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
