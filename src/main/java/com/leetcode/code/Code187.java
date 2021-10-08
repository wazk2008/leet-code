package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code187 {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }

    static final int L = 10;

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i <= len-L; i++) {
            String sub = s.substring(i, i + L);
            map.put(sub, map.getOrDefault(sub, 0)+1);
            if (map.get(sub) == 2) {
                res.add(sub);
            }
        }
        return res;
    }

}
