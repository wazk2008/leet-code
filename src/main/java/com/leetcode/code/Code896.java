package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code896
 * @Author: ZK
 * @Date: 2021/2/28 18:59
 * @Version: 1.0
 */
public class Code896 {

    public static void main(String[] args) {

    }

    public static boolean isMonotonic(int[] A) {
        int len = A.length;
        boolean up = false;
        boolean down = false;
        for (int i = 1; i < len; i++) {
            if (A[i-1] < A[i]) {
                up = true;
            }
            if (A[i-1] > A[i]) {
                down = true;
            }
        }
        return up && down ? false : true;
    }

}
