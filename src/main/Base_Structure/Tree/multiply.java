/**
 * Copyright (C), 2018-2020
 * FileName: multiply
 * Author:   xjl
 * Date:     2020/5/17 17:47
 * Description: 测试
 */
package Tree;

import org.junit.Test;

public class multiply {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int sum = 1;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    sum *= A[j];
                }
            }
            B[i] = sum;
        }
        return B;
    }

    @Test
    public void test() {
        int[] A = {1, 2, 3, 4, 5};
        multiply(A);
    }
}
