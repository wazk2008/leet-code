package com.leetcode.code;

public class Code551 {

    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        int len = s.length();
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                if (++countA >= 2) {
                    return false;
                }
            }
            if (c == 'L') {
                if (++countL >= 3) {
                    return false;
                }
            } else {
                countL = 0;
            }
        }
        return true;
    }

}
