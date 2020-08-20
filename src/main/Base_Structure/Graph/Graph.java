/**
 * Copyright (C), 2018-2020
 * FileName: Graph
 * Author:   xjl
 * Date:     2020/4/1 14:12
 * Description: 实现无线图利用是的数组加上链表
 */
package Graph;

import Queue.QueueLink;

public class Graph {
    private final int V;//记录定点的数量
    private int E;//获取图中的边的数量
    private QueueLink<Integer>[] adj;//邻接表

    public Graph(int v) {
        //初始化成员变量
        this.V = v;
        this.E = 0;
        this.adj = new QueueLink[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new QueueLink<Integer>();
        }
    }

    //获取定点的数量
    public int V() {
        return V;
    }

    //获取边的数量
    public int E() {
        return E;
    }

    //添加一条边的方法
    public void addEdge(int v, int w) {
        //在无向图中边是没有方向的，所以在这个边中可以说是v到W的也可以是w到V的
        adj[v].push(w);
        adj[w].push(v);
        E++;
    }

    //获取和顶点相关的所有的点
    public QueueLink<Integer> adj(int v) {
        return adj[v];
    }
}
