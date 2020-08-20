package Graph;

/**
 * Copyright (C), 2018-2020
 * FileName: Graph.DepthTest
 * Author:   xjl
 * Date:     2020/5/31 14:18
 * Description: ceshi
 */

public class DepthTest {

    public static void main(String[] args) {
        //准备好graph对象
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(11, 12);

        //准备好深度优先搜索对象
        DepthFristSearch depthFristSearch = new DepthFristSearch(graph, 0);
        //测试与每一个顶点得数量
        int count = depthFristSearch.count();
        System.out.println("与0相同的顶点是的数量为：" + count);
        //测试某一个顶点与起点是否相同
        boolean marked = depthFristSearch.marked(5);
        System.out.println("顶点5是否与顶点0想通" + marked);

        boolean marked2 = depthFristSearch.marked(7);
        System.out.println("顶点5是否与顶点7想通" + marked2);

        System.out.println("==================================================");

        BreadthFristSearch breadthFristSearch=new BreadthFristSearch(graph,0);

        int count1=breadthFristSearch.count();
        System.out.println("与0相同的顶点的数量树为"+count1);

        boolean marked1 = breadthFristSearch.marked(5);
        System.out.println("顶点5是否与顶点0想通" + marked1);

        boolean marked3 = breadthFristSearch.marked(7);
        System.out.println("顶点5是否与顶点0想通" + marked3);

    }

}
