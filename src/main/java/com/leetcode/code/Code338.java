package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code338
 * @Author: ZK
 * @Date: 2021/3/3 23:14
 * @Version: 1.0
 */
public class Code338 {

    public static void main(String[] args) {
        int x = 11;
        int y = 12;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(x & y));
        System.out.println(x & y);
    }

    public static int[] countBits(int num) {
        int[] res = new int[num+1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[ i&(i-1) ] + 1;
        }

        return res;
    }

}
