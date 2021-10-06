package com.leetcode.code;

public class Code434 {

    public static void main(String[] args) {
        String s = "                ";
        System.out.println(countSegments(s));
    }
    
    public static int countSegments(String s) {
        int res = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if ((i==0 && chars[i]!=' ') || (i>0 && chars[i-1]==' ' && chars[i]!=' ')) {
                res++;
            }
        }
        return res;
    }
    
}
