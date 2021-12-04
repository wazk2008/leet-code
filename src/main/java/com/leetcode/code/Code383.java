package com.leetcode.code;

public class Code383 {

    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int idx = magazine.charAt(i) - 'a';
            cnt[idx]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (--cnt[idx] < 0) {
                return false;
            }
        }
        return true;
    }

}
