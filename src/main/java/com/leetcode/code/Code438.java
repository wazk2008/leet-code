package com.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code438 {

    public static void main(String[] args) {
        String s = "abaebabacdzxf";
        String p = "abc";
//        String s = "abbbbbb";
//        String p = "aaa";
        List<Integer> list = findAnagrams(s, p);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    // 此为基础方法， 还有可以优化的地方=>留给后续再思考吧......
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (pLen > sLen) {
            return new ArrayList<>();
        }

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < pLen; i++) {
            pCnt[p.charAt(i)-'a']++;
            sCnt[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(pCnt, sCnt)) {
            res.add(0);
        }

        for (int i = 0; i < sLen-pLen; i++) {
            sCnt[s.charAt(i)-'a']--;
            sCnt[s.charAt(i+pLen)-'a']++;
            if (Arrays.equals(pCnt, sCnt)) {
                res.add(i+1);
            }
        }

        return res;
    }

}
