/**
 * Copyright (C), 2018-2020
 * FileName: BreadthFristSearch
 * Author:   xjl
 * Date:     2020/5/31 14:35
 * Description: 广度优先遍历
 */
package Graph;

import Queue.QueueLink;

public class BreadthFristSearch {
    private boolean[] marked;//索引代表的顶点
    private int count;//记录有多少个顶点与s顶点相遇
    private QueueLink<Integer> waitSearch;//用来存储搜索领接表的点

    public BreadthFristSearch(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new QueueLink<>();
        bfs(G, s);
    }

    //使用的是的广度有优先遍历的找出Gz中的v顶点的所有的相邻的顶点
    public void bfs(Graph graph, int v) {
        //通过把当前顶点v的标识为已经搜索
        marked[v] = true;
        //让顶点进入队例 等待搜索
        waitSearch.push(v);
        //通过循环 如果队列不为空，那么队列弹出一个待搜索的顶点进行搜索
        while (!waitSearch.isEmpty()) {
            //弹出一个等待的搜索的顶点
            Integer wait = waitSearch.pop();
            //遍历wait的顶点的邻接表
            for (Object w : graph.adj(wait)) {
                if (!marked[(Integer) w]) {
                    bfs(graph, (Integer) w);
                }
            }
        }
        //通过想通的顶点加1
        count++;
    }

    //判断w顶点与s顶点是否想通
    public boolean marked(int w) {
        return marked[w];
    }

    //获取顶点的s想通的所有的顶点的总数
    public int count() {
        return count;
    }
}
