package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code301 {

    public static void main(String[] args) {
        String s = "(a)())()";
        List<String> list = removeInvalidParentheses(s);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    static Set<String> set = new HashSet<>();
    static int n, max, len;
    static String str;
    public static List<String> removeInvalidParentheses(String s) {
        str = s;
        n = str.length();
        int l=0, r=0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                r++;
            }
        }
        max = Math.min(l, r);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    private static void dfs(int u, String cur, int score){
        if (score<0 || score>max) {
            return;
        }
        if (u == n) {
            if (score==0 && cur.length()>=len) {
                if (cur.length() > len) {
                    set.clear();
                }
                len = cur.length();
                set.add(cur);
            }
            return;
        }

        char c = str.charAt(u);
        if (c == '(') {
            dfs(u+1, cur+c, score+1);
            dfs(u+1, cur, score);
        } else if (c == ')') {
            dfs(u+1, cur+c, score-1);
            dfs(u+1, cur, score);
        } else {
            dfs(u+1, cur+c, score);
        }
    }


}
