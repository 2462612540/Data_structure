package Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020
 * FileName: Array.Solution
 * Author:   xjl
 * Date:     2020/5/12 15:17
 * Description: ceshi
 */

public class Solution {

    String res = new String();

    public void Insert(char ch) {
        res += ch;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < res.length(); i++) {
            if (!map.containsKey(res.charAt(i))) {
                map.put(res.charAt(i),1);
            }else {
                map.put(res.charAt(i),map.get(res.charAt(i))+1);
            }
        }
        for (int i=0;i<res.length();i++){
            if (map.get(res.charAt(i))==1){
                return res.charAt(i);
            }else {
                continue;
            }
        }
        return '#';
    }


    @Test
    public void test() {
        String s = "google";
        for (int i = 0; i < s.length(); i++) {
            Insert(s.charAt(i));
            char c=FirstAppearingOnce();
            System.out.print(c);
        }
    }
}
