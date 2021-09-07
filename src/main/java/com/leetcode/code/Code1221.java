package com.leetcode.code;

public class Code1221 {

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                count++;
            }
            if (c == 'R') {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }

}
