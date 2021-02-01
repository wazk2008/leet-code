package com.leetcode.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Code888
 * @Author ZK
 * @Description
 * @Date 2021/2/1 17:02
 * @Version 1.0
 **/
public class Code888 {

    public static void main(String[] args) {

    }

    /**
     * 暴力
     * @param A
     * @param B
     * @return
     */
    public static int[] fairCandySwap0(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (sumA - A[i] + B[j] == sumB + A[i] - B[j]) {
                    res[0] = A[i];
                    res[1] = B[j];
                }
            }
        }
        return res;
    }

    /**
     * hash表
     * @param A
     * @param B
     * @return
     */
    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = Arrays.stream(A).sum();
        int sumB = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : B) {
            set.add(x);
            sumB += x;
        }

        for (int x : A) {
            int temp = x - (sumA - sumB)/2;
            if (set.contains(temp)) {
                res[0] = x;
                res[1] = temp;
            }
        }
        return res;
    }

}
