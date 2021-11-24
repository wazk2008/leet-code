package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

public class Code423 {

    public static void main(String[] args) {

    }

    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int[] cnt = new int[10];
        cnt[0] = map.getOrDefault('z', 0);
        cnt[2] = map.getOrDefault('w', 0);
        cnt[4] = map.getOrDefault('u', 0);
        cnt[6] = map.getOrDefault('x', 0);
        cnt[8] = map.getOrDefault('g', 0);

        cnt[3] = map.getOrDefault('h', 0) - cnt[8];
        cnt[5] = map.getOrDefault('f', 0) - cnt[4];
        cnt[7] = map.getOrDefault('s', 0) - cnt[6];

        cnt[1] = map.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = map.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }


}
