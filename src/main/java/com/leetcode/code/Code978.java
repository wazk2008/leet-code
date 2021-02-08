package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code978
 * @Author: ZK
 * @Date: 2021/2/8 22:48
 * @Version: 1.0
 */
public class Code978 {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(arr));
    }

    public static int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int[] down = new int[len];
        int[] up = new int[len];
        for (int i = 0; i < len; i++) {
            down[i] = 1;
            up[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            if (arr[i-1] > arr[i]) {
                down[i] = up[i-1]+1;
            }
            if (arr[i-1] < arr[i]) {
                up[i] = down[i-1]+1;
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max( max, Math.max(up[i], down[i]) );
        }

        return max;
    }

}
