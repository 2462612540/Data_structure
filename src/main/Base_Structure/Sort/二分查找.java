/**
 * Copyright (C), 2018-2020
 * FileName: Binary_search
 * Author:   xjl
 * Date:     2020/9/1 15:59
 * Description:
 */
package Sort;

public class 二分查找 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int target = 3;

        int search = search(array, target);
        System.out.println(search);

    }

    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
