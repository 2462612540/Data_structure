/**
 * Copyright (C), 2018-2020
 * FileName: Stack_Demo
 * Author:   xjl
 * Date:     2020/3/19 10:43
 * Description: 栈
 */
package Stack_Demo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Stack_Demo {
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
        Stack_My stack = new Stack_My();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("总数为=" + stack.size());
        for (Object val : stack) {
            System.out.println(val);
        }
//        for (int i=0;i<5;i++){
//            System.out.println(stack.pop());
//        }
    }

    /**
     * 测试逆波兰表达式
     */
    @Test
    public void test2() {
        String[] noation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int re = cal(noation);
        System.out.println(re);
    }

    public int cal(String[] noation) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < noation.length; i++) {
            String curr = noation[i];
            Integer o1;
            Integer o2;
            Integer result = 0;
            switch (curr) {
                case "+":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 + o1;
                    stack.push(result);
                    break;
                case "-":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 - o1;
                    stack.push(result);
                    break;
                case "*":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 * o1;
                    stack.push(result);
                    break;
                case "/":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2/o1 ;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(curr));
            }
        }
        return stack.pop();
    }
}
