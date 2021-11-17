package com.leetcode.code;

public class Code318 {

    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] bits = new int[len];
        for (int i = 0; i < len; i++) {
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                bits[i] |= 1 << chars[j] - 'a';
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }

}
