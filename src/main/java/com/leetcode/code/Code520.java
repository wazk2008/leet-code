package com.leetcode.code;

public class Code520 {

    public static void main(String[] args) {
        String s = "cAAAAAAD";
        System.out.println(isValid(s, 0, s.length()));
    }

    public boolean detectCapitalUse(String word) {
        // 判断第一个字符是大写还是小写
        if (Character.isUpperCase(word.charAt(0))) {
            return isValid(word, 1, word.length());
        } else {
            return isValid(word, 0, word.length());
        }
    }

    // 判断 [i, j） 范围内字符大小写是否一致
    private static boolean isValid(String s, int i, int j){
        if (i+1 == j) {
            return true;
        }
        for (int k = i+1; k < j; k++) {
            char cur = s.charAt(k);
            char pre = s.charAt(k - 1);
            if (Character.isUpperCase(cur) ^ Character.isUpperCase(pre)) {
                return false;
            }
        }
        return true;
    }

}
