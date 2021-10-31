package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

public class Code500 {

    public static void main(String[] args) {

    }

    public String[] findWords(String[] words) {
        int[] rowIdx = {1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String s = word.toLowerCase();
            boolean flag = true;
            int row = rowIdx[s.charAt(0)-'a'];
            for (int i = 1; i < s.length(); i++) {
                if (rowIdx[s.charAt(i)] != row) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }

}
