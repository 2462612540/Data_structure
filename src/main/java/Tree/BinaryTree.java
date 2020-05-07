/**
 * Copyright (C), 2018-2020
 * FileName: BinaryTree
 * Author:   xjl
 * Date:     2020/3/25 17:10
 * Description: 二叉树
 */
package Tree;

import Queue_Demo.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    //成员变量
    //记录的是更根节点
    private Node root;//这里是表示的根节点
    //节点的个数
    private int N;

    //表示二叉树中的一个节点
    private class Node<Key, Value> {
        //存储键
        public Key key;
        //存储的值
        public Value value;
        //左节点
        public Node left;
        //右节点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //构造函数
    public BinaryTree() {
        this.root = new Node(null, null, null, null);
        this.N = 0;
    }

    //成员函数
    public int size() {
        return N;
    }

    //向树中的插入键值对
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //给指定的数中添加键值对key-value 并返回添加后的新树    传递给的插上是当前的额这个节点 和需要插入的键值
    // 要插入的是key-value
    public Node put(Node x, Key key, Value value) {
        //子树为空 新建这个节点并返回这个节点作为树的根节点
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //子树不为空
        //比较节点的键值和插入的key的大小
        int crp = key.compareTo((Key) x.key);// key的大于节点的值
        System.out.println(crp);
        if (crp > 0) {
            //key>x.key x表示的是节点 插入的值比节点值大 那就应该是放置在右边的这个地方
            //x.right=put(x.right,key,value) 表示的是去插入到想 x的右节点？
            x.right = put(x.right, key, value);
        } else if (crp < 0) {
            //如果key<x的节点的值 x 是表示节点的值 则方式在左节点的地方.则继续找左子树
            //x.left=put(x.left,key,value) 表示的是插入到x的左节点
            x.left = put(x.left, key, value);
        } else {
            //如果key=x的节点的值 替换原理的值便 这里其实这是没有改变的。
            x.value = value;
        }
        //让元素个数增加
        N++;
        return x;
    }

    //在树中查询的key值
    public Value get(Key key) {
        return get(root, key);
    }

    //在指定的数中的查询方法
    public Value get(Node x, Key key) {
        //分x为null
        if (x == null) {
            return null;
        }
        //分为x不为null
        //比较key的值
        int crp = key.compareTo((Key) x.key);
        if (crp > 0) {
            //如果是key大于节点的key 这找到右子树 x.right 表示的x的整个右边的节点
            return (Value) get(x.right, key);
        } else if (crp < 0) {
            //如果是key小于节点的key 这找到左子树
            return (Value) get(x.left, key);
        } else {
            //如果等于key的的返回这个value
            return (Value) x.value;
        }
    }

    //删除该树中的key的value的值
    public void delete(Key key) {
        delete(root, key);
    }

    //删除指定树中的key的value的值 并返回这个删除后的树 那应该是返回的是根节点的值
    public Node delete(Node x, Key key) {
        //x树为null
        if (x == null) {
            return null;
        }
        //x树不为null
        int cmp = key.compareTo((Key) x.key);
        if (cmp > 0) {
            //如果是key大于节点的key 这找到右子树 x.right 表示的x的整个右边的节点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            //如果是key小于节点的key 这找到左子树
            x.left = delete(x.left, key);
        } else {
            //让元素个数减少
            N--;
            //如果等于key的的x的键的时候，那么就需要完成是的是删除这个节点的操作
            //找到右子树中的小的节点
            if (x.right == null) {
                return x.left;
            }
            if (x.right == null) {
                return x.right;
            }
            //找到右子树的最小的节点
            Node minnode = x.right;
            while (minnode.left != null) {
                minnode = minnode.left;
            }
            //删除右子树的最小的点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left != null) {
                    //断开节点
                    n.left = null;
                } else {
                    //变换节点为下一个就可以
                    n = n.left;
                }
            }
            //让x的节点的左子树minnode的左子树
            minnode.left = x.left;
            //让x的节点的右子树minnode的右子树
            minnode.right = x.right;
            //让x的节点的父节点指向minnode
            x = minnode;
        }
        return x;
    }

    //查找树的最小的键 就会一直找到左边的值 然后在这个节点 并返回这个
    public Key minkey() {
        return (Key) minNode(root).key;
    }

    //查找树的最小的键对应的值 就会一直找到左边的值 然后在这个节点 并返回这个
    public Value minValue() {
        return (Value) minNode(root).value;
    }

    //找到最小的键在节点
    public Node minNode(Node x) {
        if (x.left != null) {
            return minNode(x.left);
        } else {
            return x;
        }
    }

    public Key maxkey() {
        return (Key) minNode(root).key;
    }

    //查找树的最大的键对应的值 就会一直找到左边的值 然后在这个节点 并返回这个
    public Value maxValue() {
        return (Value) minNode(root).value;
    }

    //找到最大的键在节点
    public Node maxNode(Node x) {
        if (x.right != null) {
            return maxNode(x.right);
        } else {
            return x;
        }
    }

    //二叉树的遍历的方式
    //前序遍历
    //获取整个树的键
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    //获取指定的数x的所有的键，并放置在keys中
    private void preErgodic(Node x, Queue<Key> keys) {
        //如果树为空的话
        if (x == null) {
            return;
        }
        //如果树不为空的话 将节点的key记性入队的操作
        keys.push((Key) x.key);
        if (x.left != null) {
            //如果左子树不为空则 将递归左子树
            preErgodic(x.left, keys);
        }
        if (x.right != null) {
            //如果右子树不为空则 将递归右子树
            preErgodic(x.right, keys);
        }
    }

    //中序遍历
    //获取整个树的键
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    //获取指定的数x的所有的键，并放置在keys中
    private void midErgodic(Node x, Queue<Key> keys) {
        //如果树为空的话
        if (x == null) {
            return;
        }
        //将左子树的放置
        if (x.left != null) {
            midErgodic(x.left, keys);
        }
        //将当前子树的放置
        keys.push((Key) x.value);
        //将右子树的放置
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    //后序遍历
    //获取整个树的键
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    private void afterErgodic(Node x, Queue<Key> keys) {
        //如果树为空的话
        if (x == null) {
            return;
        }
        //将左子树的放置
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }
        //将右子树的放置
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }
        //将当前子树的放置
        keys.push((Key) x.value);
    }

    //层序遍历的方法
    public Queue<Key> layerErgodic() {
        //定义两个队列
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            //从队列中的弹出节点 把节点中的key放置keys中
            Node node = nodes.pop();
            keys.push((Key) node.key);
            //判断当前节点有没有左边的节点 如果有 则放入到nodes中
            if (node.left != null) {
                nodes.push(node.left);
            }
            //判断当前的节点有没有右节点  如果有 则放入到nodes中
            if (node.right != null) {
                nodes.push(node.right);
            }
        }
        return keys;
    }

    //获取整个树的最大深度
    public int maxDepth() {
        return maxDepth(root);
    }

    //获取指定树的深度
    private int maxDepth(Node x) {
        if (x == null) {
            return 0;
        }
        //x的最大深度
        int max = 0;
        //左子树的最大深度
        int maxl = 0;
        //右子树的最大深度
        int maxr = 0;
        //计算左子树的最大深度
        if (x.left != null) {
            maxl = maxDepth(x.left);
        }
        //计算右子树的最大深度
        if (x.right != null) {
            maxr = maxDepth(x.right);
        }
        //比较左字树和右子树的最大的深度 在加1就可以满足既可以
        max = maxl > maxr ? maxl + 1 : maxr + 1;
        return max;
    }

}
