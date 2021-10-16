package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

public class Code282 {

    public static void main(String[] args) {
        String num = "232";
        int target = 8;
        List<String> list = addOperators(num, target);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    static List<String> res = new ArrayList<>();
    static String s;
    static int len, t;

    public static List<String> addOperators(String num, int target) {
        s = num;
        len = s.length();
        t = target;
        dfs(0, 0, 0, "");
        return res;
    }

    private static void dfs(int idx, long prev, long cur, String ss){
        if (idx == len) {
            if (cur == t) {
                res.add(ss);
            }
            return;
        }
        for (int i = idx; i < len; i++) {
            if (i!=idx && s.charAt(idx)=='0') {
                break;
            }
            long next = Long.valueOf(s.substring(idx, i+1));
            if (idx == 0) {
                dfs(i+1, next, next, ""+next);
            } else {
                dfs(i+1, next, cur+next, ss+"+"+next);
                dfs(i+1, -next, cur-next, ss+"-"+next);
                dfs(i+1, prev*next, cur-prev+prev*next, ss+"*"+next);
            }
        }
    }

}
