package recursive;

/**
 * Copyright (C), 2018-2020
 * FileName: recursive.Recursive
 * Author:   xjl
 * Date:     2020/3/19 14:25
 * Description: 递归的问题
 */

public class Recursive {
    //这里是一个简答的实现递归的调用 这里是用了通用的表达式f(n)
    public static int factorial(int n) {
        int sum = 1;
        if (n == 1) {
            return 1;
        } else {
            sum = n * factorial(n - 1);
        }
        return sum;
    }

    //不适用的递归的算法实现
    public static int factorial2(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum > Integer.MAX_VALUE ? 0 : sum;//这也是一个选择的方法
    }
    //利用数据的来存储数字

    public static void main(String[] args) {
        System.out.println(factorial(10));

        System.out.println("不用试递归的=" + factorial2(200));
    }
}
