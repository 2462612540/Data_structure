/**
 * Copyright (C), 2018-2020
 * FileName: BubboSort
 * Author:   xjl
 * Date:     2020/3/19 14:50
 * Description: 冒泡排序原理
 */
package Sort;

public class BubboSort {
    public static int[] BubboSort(int[] number) {
        //控制比较的排序的次数
        for (int i = number.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (number[j] > number[j + 1]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int count=200000;
        int[] number =new int[count];
        for (int i=0;i<count;i++){
            number[i]=(int) (Math.random()*100);
        }
        long st=System.currentTimeMillis();
        int[] number2 = BubboSort(number);
        long end=System.currentTimeMillis();
        for (int i = 0; i <number2.length; i++) {
            System.out.println(number2[i]);
        }
        System.out.println(end-st);
    }
}
