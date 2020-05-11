/**
 * Copyright (C), 2018-2020
 * FileName: NodeDemo
 * Author:   xjl
 * Date:     2020/5/7 10:02
 * Description: 节点类的构造
 */
package Link;

/**
 * 构造方法的
 *
 * @param <T>
 */
public class NodeDemo<T> {
    //节点的成员变量必须是要为public
    public T item;
    public NodeDemo next;

    public NodeDemo(T item) {
        this.item = item;
    }

    public NodeDemo(T item, NodeDemo next) {
        this.item = item;
        this.next = next;
    }

}
