package com.leetcode.code;

public class Code405 {

    public static void main(String[] args) {
        int num = 16;
        System.out.println(toHex(num));
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int t = num & 15;
            char c = (char)(t + '0');
            if (t >= 10) {
                c = (char)(t-10+'a');
            }
            System.out.println(t + "\t" + c);
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

}
