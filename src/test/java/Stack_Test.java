/**
 * Copyright (C), 2018-2020
 * FileName: Stack_Test
 * Author:   xjl
 * Date:     2020/3/19 10:43
 * Description: 栈
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Stack_Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.add(2);
        stack.add(3);
        stack.add(5);
        System.out.println(stack.get(2));
        LinkedList linkedList = new LinkedList();

    }

    @Test
    public void test() {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("总数为=" + stack.size());
        for (Object val : stack) {
            System.out.println(val);
        }
        System.out.println("--------------------------------");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
//        System.out.println("--------------------------------");
//        for (int i = 0; i < 5; i++) {
//            System.out.println(stack.pop());
//        }
    }

    /**
     * 测试逆波兰表达式
     */

}
