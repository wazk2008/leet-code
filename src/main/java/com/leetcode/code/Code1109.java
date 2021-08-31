package com.leetcode.code;

public class Code1109 {

    public static void main(String[] args) {

    }

//    暴力
    public static int[] corpFlightBookings(int[][] bookings, int n) {
//        [1,5,9]  => [ 9,9,9,9,9]
//        [2,5,8]  => [ 0,8,8,8,8]
//        [3,6,4]  => [ 0,0,4,4,4,4]
//        [4,7,2]  => [ 0,0,0,2,2,2,2]
//        ===>        [ 9,17,21,23,23,6,2]
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                nums[i-1] += booking[2];
            }
        }
        return nums;
    }

//    差分
    public static int[] corpFlightBookings1(int[][] bookings, int n) {
//        处理第1个和最后1个，变成前缀和的数组
//        [1,5,9]  => [ 9,0,0,0,0,-9]
//        [2,5,8]  => [ 0,8,0,0,0,-8]
//        [3,6,4]  => [ 0,0,4,0,0, 0,-4]
//        [4,7,2]  => [ 0,0,0,2,0, 0,0]
//        ===>        [ 9,8,4,2,0,-17,-4]       差分
//        ===>        [ 9,17,21,23,23,6,2]      前缀和
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0]-1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }

//        求前缀和
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }

        return nums;
    }


}
