package com.leetcode.code;

import java.util.Collections;

public class Code482 {

    public static void main(String[] args) {
//        String s = "5F3Z-2e-9-w";
        String s = "---";
        int k = 3;
        System.out.println(licenseKeyFormatting(s, k));
    }

    public static String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for (int i = len-1; i >= 0; i--) {
            char c = chars[i];
            if (c != '-') {
                res.append(Character.toUpperCase(c));
                cnt++;
            }
            if (cnt == k) {
                res.append('-');
                cnt = 0;
            }
        }
        if (res.length()!=0 && res.charAt(res.length()-1) == '-') {
            res.deleteCharAt(res.length()-1);
        }
        return res.reverse().toString();
    }

}
