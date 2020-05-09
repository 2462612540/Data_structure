/**
 * Copyright (C), 2018-2020
 * FileName: DepthFristSearch
 * Author:   xjl
 * Date:     2020/4/1 14:57
 * Description: 深度优先搜索
 */
package Graph;

public class DepthFristSearch {
    //成员变量
    private boolean[] mark;//代表索引的顶点，值表示的是顶点是否已经被搜索了
    private int count;//记录有多少个顶点的想通
    //构造方法

    public DepthFristSearch(Graph G, int s) {
        //初始化的marked的数据
        this.mark = new boolean[G.V()];
        //初始化的顶点s的想通的顶点的数量
        this.count = 0;
        dfs(G, s);
    }

    //成员函数
    //使用深度优先搜索找出G图中的V的顶点的所有的想通的顶点
    private void dfs(Graph G, int v) {
        //把v的顶点标记为已经搜索
        mark[v] = true;

    }

    //判断是w和顶点的S的顶点得是否想通
    public boolean marked(int W) {
        return true;
    }

    //获取顶点S想通的所有的顶点的总数
    public int count() {
        return 0;
    }
}
