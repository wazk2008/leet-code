package com.leetcode.code;

import java.util.Arrays;

/**
 * @ClassName Code567
 * @Author ZK
 * @Description
 * @Date 2021/2/10 20:14
 * @Version 1.0
 **/
public class Code567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));

    }

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len2 < len1) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for (int i = 0; i < len1; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        if ( Arrays.equals(map1, map2) ) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            map2[s2.charAt(i-len1) - 'a']--;
            map2[s2.charAt(i) - 'a']++;
            if ( Arrays.equals(map1, map2) ) {
                return true;
            }
        }
        return false;
    }

}
