import Queue.QueueLink;
import Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Copyright (C), 2018-2020
 * FileName: BinaryTreeTest
 * Author:   xjl
 * Date:     2020/5/11 19:28
 * Description: 创建二叉查找树
 */

public class BinaryTreeTest2 {
    public static void main(String[] args) {
        BinaryTree<String, String> binaryTree = new BinaryTree();

        //测试插入
        binaryTree.put("E", "5");
        binaryTree.put("B", "2");
        binaryTree.put("G", "7");
        binaryTree.put("A", "1");
        binaryTree.put("D", "4");
        binaryTree.put("F", "6");
        binaryTree.put("H", "8");
        binaryTree.put("C", "3");

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        //前序遍历的测试
        QueueLink<String> queueLink = binaryTree.preErgodic();
        for (Object key : queueLink) {
            System.out.print(key);
        }
        System.out.println();
        System.out.println("----------------------------------");
        //中序遍历
        QueueLink<String> queueLink1 = binaryTree.midErgodic();
        for (Object key : queueLink1) {
            System.out.print(key);
        }
        System.out.println();
        System.out.println("----------------------------------");
        //后序遍历
        QueueLink<String> queueLink2 = binaryTree.afterErgodic();
        for (Object key : queueLink2) {
            System.out.print(key);
        }
        System.out.println();
        System.out.println("----------------------------------");
        //后序遍历
        QueueLink<String> queueLink3 = binaryTree.layerErgodic();
        for (Object key : queueLink3) {
            System.out.print(key);
        }
        System.out.println();
        System.out.println("**************************************");
        System.out.println(binaryTree.maxDepth());
    }
}
