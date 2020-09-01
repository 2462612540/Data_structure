/**
 * Copyright (C), 2018-2020
 * FileName: RedTree
 * Author:   xjl
 * Date:     2020/8/22 10:06
 * Description: 红黑树
 */
package Tree;

/**
 * ①创建RBTree,定义颜色
 * ②创建RBNode
 * ③辅助方法定义: parentof (node)，isRed (node)，setRed (node)，setBlack(node)， inOrderPrint()
 * ④左旋方法定义: leftRotate (node )
 * ⑤右旋方法定义: rightRotate (node)
 * ⑥公开插入接口方法定义: insert(K key, V value);
 * ⑦内部插入接口方法定义: insert(RBNode node) ;
 * ⑧修正插入导致红黑树失衡的方法定义: inser tFIxUp (RBNode node) ;
 * ⑨测试红黑树正确性
 */
public class RedTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBTree root;

    /**
     * 中序遍历
     *
     * @param
     */
    public void inorderprint() {
        inorderprint(this.root);
    }

    public void inorderprint(RBTree root) {
        if (root != null) {
            inorderprint(root.left);
            System.out.println(root.key + "--" + root.value);
            inorderprint(root.right);
        }
    }

    /**
     * 左旋
     */

    private void leftrotate(RBTree x) {
        RBTree y = x.right;
        x.right = y.left;
        //1.将x的右子节点指向y的左子节点(ly)，将y的左子节点的父节点更新为x
        if (y.left != null) {
            y.left.parent = x;
        }
        //2.当x的父节点(不为空时)，更新y的父节点为x的父节点，并将x的父节点指定子树(当前x的子树位置) 指定为y
        if (x.parent != null) {
            y.parent = x.parent;
            if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        } else {
            //说明的父节点为y
            this.root = y;
        }
        //3.将x的父节点更新为y，将y的左子节点更新为x
        x.parent = y;
        y.left = x;
    }

    static class RBTree<K extends Comparable<K>, V> {
        private RBTree parent;
        private RBTree left;
        private RBTree right;
        private boolean color;
        private K key;
        private V value;

        public RBTree(RBTree parent, RBTree left, RBTree right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        /**
         * 返回的是的空的节点
         *
         * @param root
         * @return
         */
        private RBTree parentof(RBTree root) {
            if (root != null) {
                return root.parent;
            }
            return null;
        }

        /**
         * 判断节点是红色
         *
         * @param root
         * @return
         */
        private boolean isRed(RBTree root) {
            if (root != null) {
                return root.color == RED;
            }
            return false;
        }

        /**
         * 判断节点的还是黑色
         *
         * @param root
         * @return
         */
        private boolean isBlack(RBTree root) {
            if (root != null) {
                return root.color == BLACK;
            }
            return false;
        }

        /**
         * 设置为红色
         *
         * @param root
         */
        private void setRed(RBTree root) {
            if (root != null) {
                root.color = RED;
            }
        }

        /**
         * 设置为黑色
         *
         * @param root
         */
        private void setBalck(RBTree root) {
            if (root != null) {
                root.color = BLACK;
            }
        }
    }
}
