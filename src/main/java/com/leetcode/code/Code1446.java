package com.leetcode.code;

public class Code1446 {

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(maxPower(s));
    }

    public static int maxPower(String s) {
        int len = s.length();
        if (len < 2) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] == chars[i-1]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return Math.max(res, count);
    }

}
