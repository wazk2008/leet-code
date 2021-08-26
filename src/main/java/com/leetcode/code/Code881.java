package com.leetcode.code;

import java.util.Arrays;

public class Code881 {

    public static void main(String[] args) {

    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int left = 0;
        int right = people.length-1;
        while (left <= right) {
            if (people[left] + people[right] > limit) {
                right--;
            } else {
                left++;
                right--;
            }
            res++;
        }
        return res;
    }

//    if条件进行优化
    public static int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int left = 0;
        int right = people.length-1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            res++;
        }
        return res;
    }

}
