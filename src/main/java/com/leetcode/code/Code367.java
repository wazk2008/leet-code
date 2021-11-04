package com.leetcode.code;

public class Code367 {

    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right-left)/2;
            long sqrt = (long)mid * mid;
            if (sqrt < num) {
                left = mid+1;
            } else if (sqrt > num) {
                right = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }

}
