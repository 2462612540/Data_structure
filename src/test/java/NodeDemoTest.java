import Link_Demo.NodeDemo;

/**
 * Copyright (C), 2018-2020
 * FileName: NodeDemoTest
 * Author:   xjl
 * Date:     2020/5/7 10:05
 * Description: 节点的测试
 */

public class NodeDemoTest {
    public static void main(String[] args) {
        //构建一个新的节点
        NodeDemo<Integer> frist = new NodeDemo<>(11, null);
        NodeDemo<Integer> second = new NodeDemo<>(12, null);
        NodeDemo<Integer> three = new NodeDemo<>(13, null);
        NodeDemo<Integer> four = new NodeDemo<>(14, null);
        frist.next = second;
        second.next = three;
        three.next = four;


        //多一个构造函数形成
        NodeDemo<String> s1 = new NodeDemo<>("11111");
        NodeDemo<String> s2 = new NodeDemo<>("22222");
        NodeDemo<String> s3 = new NodeDemo<>("33333");
        NodeDemo<String> s4 = new NodeDemo<>("44444");
        NodeDemo<String> s5 = new NodeDemo<>("55555");

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
    }
}
