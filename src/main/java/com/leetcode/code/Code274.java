package com.leetcode.code;

import java.util.Arrays;

public class Code274 {

    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int len = citations.length;

        Arrays.sort(citations);

        int h = 0;
        int i = len-1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }

        return h;
    }

}
