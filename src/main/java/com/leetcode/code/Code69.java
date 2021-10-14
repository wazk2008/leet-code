package com.leetcode.code;

public class Code69 {

    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) {
                return mid;
            }
            if (arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]) {
                left = mid;
            }
            if (arr[mid-1]>arr[mid] && arr[mid]>arr[mid+1]) {
                right = mid;
            }
        }
        return 0;
    }

}
