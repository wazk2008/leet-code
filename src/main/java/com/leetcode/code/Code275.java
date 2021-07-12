package com.leetcode.code;

public class Code275 {

    public static void main(String[] args) {

    }

    public static int hIndex(int[] citations) {
        int len = citations.length;

        int left = 0;
        int right = len-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (citations[mid] >= len-mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }

}
