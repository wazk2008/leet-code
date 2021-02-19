package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code1004
 * @Author: ZK
 * @Date: 2021/2/19 22:51
 * @Version: 1.0
 */
public class Code1004 {

    public static void main(String[] args) {
//        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(A, 3));
        System.out.println(longestOnes1(A, 3));
    }

    public static int longestOnes(int[] A, int K) {
        int len = A.length;
        int max = 0;
        int left = 0;
        int right = 0;
        int count = 0;

        for (right = 0; right < len; right++) {
            if (A[right] == 0) {
                count++;
                while(count > K){
                    if (A[left++] == 0) {
                        count--;
                    }
                }
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }

    public static int longestOnes1(int[] A, int K) {
        int len = A.length;
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < len){
            if (A[right++] == 0) {
                count++;
            }
            if (count > K) {
                if (A[left++] == 0) {
                    count--;
                }
            }
        }
        return right-left;
    }

}
