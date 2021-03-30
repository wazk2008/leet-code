package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code190
 * @Author: ZK
 * @Date: 2021/3/29 23:00
 * @Version: 1.0
 */
public class Code190 {

    public static void main(String[] args) {
        int n = 8;
        System.out.println( Integer.toBinaryString(n) );
        System.out.println( n >> 1);
        System.out.println( Integer.toBinaryString(n>>1) );
        System.out.println( n >> 2);
        System.out.println( Integer.toBinaryString(n>>2) );
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
//            每次取最后一位
            int t = (n >> i) & 1;
            if (t == 1) {
//                当t==1时，每次向右移动对应的位数(31-i)
//                使用或运算，来叠加结果res
                res |= (1 << (31-i));
            }
        }
        return res;
    }


}
