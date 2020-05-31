/**
 * Copyright (C), 2018-2020
 * FileName: Array.Solution
 * Author:   xjl
 * Date:     2020/5/12 13:12
 * Description: 测试
 */
package recursive;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList<>();

    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[2] = 1;
        for (int i = 3; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[target];
    }

    public int cutRope2(int target) {
        if (target < 2) {
            return 0;
        }
        int[] array = new int[target + 1];
        for (int i = 3; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                array[i] = Math.max(Math.max(j * array[i - j], j * (i - j)), array[i]);
            }
        }
        return array[target];
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size <= 0) {
            return list;
        }
        int max = 0;
        for (int i = 0; i <= num.length - size; i++) {
            for (int j = 0; j < size; j++) {
                max = max > num[i + j] ? max : num[i + j];
            }
            list.add(max);
            max = 0;
        }
        return list;
    }

    public void Insert(Integer num) {
        list.add(num);
        double res = GetMedian();
        System.out.println(res);
    }

    public Double GetMedian() {
        Collections.sort(list);
        if (list.size() == 1) {
            return (double) list.get(0);
        }
        if (list.size() % 2 == 0) {
            double re = ((double)list.get(list.size() / 2-1) + (double)list.get(list.size() / 2 )) / 2;
            return re;
        } else {
            return (double) list.get(list.size() / 2);
        }
    }

    @Test
    public void test3() {
        int[] array = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < array.length; i++) {
            Insert(array[i]);
        }
    }

    {
    }

    @Test
    public void test2() {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        List list = maxInWindows(num, size);
        for (Object value : list) {
            System.out.print(value);
        }
    }

    @Test
    public void test() {
        System.out.println(cutRope2(8));
    }
}
