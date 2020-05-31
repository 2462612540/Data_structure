import Tree.BinaryTree;

/**
 * Copyright (C), 2018-2020
 * FileName: BinaryTreeTest
 * Author:   xjl
 * Date:     2020/5/11 19:28
 * Description: 创建二叉查找树
 */

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        //测试插入
        binaryTree.put(9, "张1");
        binaryTree.put(2, "张2");
        binaryTree.put(1, "张3");
        binaryTree.put(4, "张4");
        binaryTree.put(3, "花花");
        System.out.println(binaryTree.size());
        //测试获取
        System.out.println(binaryTree.get(3));
        //测试删除
        binaryTree.delete(4);
        System.out.println(binaryTree.get(4));
        System.out.println("---------------------------");
        System.out.println(binaryTree.minValue());
        System.out.println(binaryTree.maxkey());
        System.out.println(binaryTree.size());
    }
}
