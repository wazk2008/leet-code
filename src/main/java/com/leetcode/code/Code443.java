package com.leetcode.code;

public class Code443 {

    public static void main(String[] args) {
//        char[] chars = {'a','a','a','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c'};
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int len = chars.length;
        int res = 0;
        int index = 0;
        while (index < len) {
            char c = chars[index];
            int count = getNum(chars, index);
            index += count;
            chars[res++] = c;
            if (count > 1) {
                String str = String.valueOf(count);
                char[] strCharts = str.toCharArray();
                for (int i = 0; i < strCharts.length; i++) {
                    chars[res++] = strCharts[i];
                }
            }

        }
        return res;
    }

    private static int getNum (char[] chars, int index) {
        int len = chars.length;
        int count = 1;
        char c = chars[index];
        for (int i = index+1; i < len; i++) {
            if (chars[i] == c) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }



}
