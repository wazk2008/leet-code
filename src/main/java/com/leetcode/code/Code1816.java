package com.leetcode.code;

public class Code1816 {

    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        System.out.println(truncateSentence(s, 5));
    }

    public static String truncateSentence(String s, int k) {
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                k--;
            }
            if (k == 0) {
                idx = i;
                break;
            }
        }
        return s.substring(0, idx==0 ? s.length() : idx);
    }

}
