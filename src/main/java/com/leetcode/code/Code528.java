package com.leetcode.code;

import java.util.Arrays;

public class Code528 {

    public static void main(String[] args) {
        int[] w = {1,2,3,4,5,6};
        new Solution(w);
    }

}

class Solution {

    private int[] pre;
    int total;

    public Solution(int[] w) {
        int len = w.length;
        pre = new int[len];
        pre[0] = w[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i-1] + w[i];
        }
        total = pre[len-1];
    }

    public int pickIndex() {
        int n = (int)(Math.random() * total) + 1;
        return binarySearch(n);
    }
    private int binarySearch(int x) {
        int low = 0;
        int high = pre.length-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (pre[mid] < x) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
