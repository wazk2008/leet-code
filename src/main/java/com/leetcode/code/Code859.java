package com.leetcode.code;

public class Code859 {

    public static void main(String[] args) {

    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            // 判断是否有重复的字符
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i)-'a';
                if (cnt[idx] > 0) {
                    return true;
                }
                cnt[idx]++;
            }
            return false;
        } else {
            int first = -1;
            int second = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return second!=-1 && s.charAt(first)==goal.charAt(second) && s.charAt(second)==goal.charAt(first);
        }
    }

}
