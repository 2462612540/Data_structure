/**
 * Copyright (C), 2018-2020
 * FileName: Treetest
 * Author:   xjl
 * Date:     2020/3/27 11:06
 * Description: 测试代码
 */
package Tree;

public class Treetest {
    public static void main(String[] args) {
        //创建一个二叉树的
        BinaryTree<Integer, String> tree = new BinaryTree<Integer, String> ();
        //插入的操作
        tree.put(1, "张1");
        System.out.println(tree.size());
//        tree.put(2, "张2");
//        tree.put(3, "张3");
//        tree.put(4, "张4");
//        System.out.println(tree.size());
//        //获取
//        System.out.println(tree.get(3));
//        //测试删除
//        tree.delete(3);
//        System.out.println(tree.size());
    }

}
