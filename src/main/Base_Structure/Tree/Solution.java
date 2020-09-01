/**
 * Copyright (C), 2018-2020
 * FileName: Array.Solution
 * Author:   xjl
 * Date:     2020/5/11 21:13
 * Description: 树的遍历
 */
package Tree;

import org.junit.Test;

import java.util.*;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.poll();
            lists.add(Collections.singletonList(treeNode.val));
            if (treeNode.left != null) {
                deque.add(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.add(treeNode.right);
            }
        }
        return lists;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode root, List list) {
        //如果树为空的话
        if (root == null) {
            return;
        }
        //将左子树的放置
        if (root.left != null) {
            postorderTraversal(root.left, list);
        }
        //将右子树的放置
        if (root.right != null) {
            postorderTraversal(root.right, list);
        }
        //将当前子树的放置
        list.add(root.val);
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        KthNode(pRoot, list);
        if (k <= 0 || k > list.size()) {
            return null;
        }
        return new TreeNode(list.get(k));
    }

    public void KthNode(TreeNode root, List list) {
        //中序遍历 左右根
        if (root == null) {
            return;
        }
        if (root.left != null) {
            KthNode(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            KthNode(root.right, list);
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        if (pRoot == null)
            return ret;
        q.add(pRoot);
        int now = 1, next = 0;

        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            now--;
            tmp.add(t.val);
            if (t.left != null) {
                q.add(t.left);
                next++;
            }
            if (t.right != null) {
                q.add(t.right);
                next++;
            }
            if (now == 0) {
                ret.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }
        }
        return ret;
    }


    @Test
    public void test() {
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(1);
        TreeNode s3 = new TreeNode(1);
        TreeNode s4 = new TreeNode(1);
        TreeNode s5 = new TreeNode(1);
        TreeNode s6 = new TreeNode(1);
        TreeNode s7 = new TreeNode(1);

        s1.left = s2;
        s1.right = s3;
        s2.left = s4;
        s2.right = s5;
        s3.left = s6;
        s3.right = s7;

        ArrayList<ArrayList<Integer>> re = Print(s1);
        for (ArrayList<Integer> va : re) {
            Object[] objects = va.toArray();
            for (Object o:objects){
                System.out.println(o);
            }
        }
    }

}
