package com.leetcode.code;

public class Code1588 {

    public static void main(String[] args) {

    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
//            左边为奇数的数量
            int leftOddCount = (i+1)/2;
//            左边为奇数的数量
            int rightOddCount =  (len-i)/2;
//            左边为偶数的数量
            int leftEvenCount = i/2+1;
//            右边为偶数的数量
            int rightEvenCount = (len-1-i)/2+1;
            res += (leftOddCount*rightOddCount + leftEvenCount*rightEvenCount)*arr[i];
        }
        return res;
    }

}
