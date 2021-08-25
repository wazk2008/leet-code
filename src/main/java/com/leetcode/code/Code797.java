package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

public class Code797 {

    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        allPathsSourceTarget(graph);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int dst = graph.length-1;

        dfs(graph, 0, dst);

        return res;
    }

    private static void dfs (int[][] graph, int cur, int dst) {
        list.add(cur);
        if (cur == dst) {
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        for (int num : graph[cur]) {
            dfs(graph, num, dst);
        }
        list.remove(list.size()-1);
    }

}
