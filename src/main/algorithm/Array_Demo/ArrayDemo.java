/**
 * Copyright (C), 2018-2020
 * FileName: ArrayDemo
 * Author:   xjl
 * Date:     2020/3/18 14:33
 * Description: 数组的列表
 */
package Array_Demo;

/**
 * 数组的特点有;
 * 高效的访问，但是插入和删除是低效的
 *
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //定义一个数组
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = new int[5];

        array2[0] = 1;
        array2[2] = 3;
        int element = array2[2];
        System.out.println(element);
        System.out.println(array2.length);
    }
}
