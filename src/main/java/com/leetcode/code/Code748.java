package com.leetcode.code;

public class Code748 {

    public static void main(String[] args) {

    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                cnt[Character.toLowerCase(c) - 'a']++;
            }
        }

        String res = null;
        for (String word : words) {
            int[] temp = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLetter(c)) {
                    temp[Character.toLowerCase(c) - 'a']++;
                }
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > temp[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag && (res==null || word.length()<res.length())) {
                res = word;
            }
        }
        return res;
    }

}
