package com.leetcode.code;

public class Code476 {

    public static void main(String[] args) {

    }

    public static int findComplement(int num) {
        long res = 1;
        for (int i = 1; i < 32; i++) {
            res = res<<1;
            if (num < res) {
                break;
            }
        }
        return num ^ (int)(res-1);
    }

}
