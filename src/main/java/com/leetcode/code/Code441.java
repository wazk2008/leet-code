package com.leetcode.code;

public class Code441 {

    public static void main(String[] args) {
        int n = 8;
//        System.out.println(arrangeCoins(n));
        System.out.println(arrangeCoins2(9));
    }

    public static int arrangeCoins(int n) {
        int res = 0;
        while (n > res) {
            n = n-(res+1);
            res++;
        }
        return res;
    }

    public static int arrangeCoins1(int n) {
        return (int)((Math.sqrt(1+8.0*n)-1)/2);
    }

    public static int arrangeCoins2(int n) {
        long left = 1;
        long right = n;
        while (left <= right) {
            long mid = left+(right-left)/2;
            long total = mid*(mid+1)/2;
            if (total == n) {
                return (int)mid;
            } else if (total < n) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return (int)right;
    }

}
