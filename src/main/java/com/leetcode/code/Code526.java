package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code526 {

    public static void main(String[] args) {

    }

    static Map<Integer, List<Integer>> map;
    static boolean[] vis;
    static int num;

    public static int countArrangement(int n) {
//        定义一个标识，标识每个数字是否被使用过
        vis = new boolean[n+1];
//        定义一个map
//        key : index 表示当前位置
//        val : List<Integer> 表示当前位置满足题意的数字集合
        map = new HashMap<>();

//        为map准备数据，i表示下表，从j获取当前i这个位置满足题意的数字
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i%j==0 || j%i==0) {
                    List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    map.put(i, list);
                }
            }
        }

        backtrack(1, n);
        return num;
    }

    private static void backtrack (int index, int n) {
        if (index == n+1) {
            num++;
            return;
        }
        for (int x : map.get(index)) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index+1, n);
                vis[x] = false;
            }
        }
    }

}
