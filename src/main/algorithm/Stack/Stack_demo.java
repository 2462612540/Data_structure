/**
 * Copyright (C), 2018-2020
 * FileName: Stack_demo
 * Author:   xjl
 * Date:     2020/5/10 22:11
 * Description: 括号匹配问题
 */
package Stack;

import org.junit.Test;

import java.util.Stack;

public class Stack_demo {
    /**
     * 主要是实现逆波兰表达式的实现
     *
     * @param noation
     * @return
     */
    public int cal(String[] noation) {
        java.util.Stack<Integer> stack = new Stack();
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
                    result = o2 / o1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(curr));
            }
        }
        return stack.pop();
    }

    /**
     * 实现括号的匹配问题
     */
    public Boolean isMath(String str) {
        //用栈来存储对象 用来存储左括号
        Stack<Character> stack = new Stack<>();
        //开始遍历字符
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                //判断当前的字符是否为走括号 如果是 放入在栈中
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                //如果是不是的弹出栈顶的元素
                if (stack.pop() == null) ;
                {
                    return false;
                }
            }
        }
        //最后检查栈中的元素是否为空 如果是空的这个表示匹配成功 否则表示匹配不成功
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        String str = "(上海(长安)()))";
        boolean res = isMath(str);
        System.out.println(res);
    }

    @Test
    public void test2() {
        String[] noation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int re = cal(noation);
        System.out.println(re);
    }
}
