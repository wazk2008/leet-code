package com.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Code39
 * @Author ZK
 * @Description
 * @Date 2021/1/25 11:21
 * @Version 1.0
 **/
public class Code39 {

    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        List<List<Integer>> res = combinationSum(arr, 7);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
//        排序，对应剪枝
        Arrays.sort(candidates);

        dfs(candidates, 0, len, target, new ArrayList<Integer>(), res);

        return res;
    }

    private static void dfs(int[] candidates, int begin, int len, int target, List<Integer> path, List<List<Integer>> res){
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
//        i=begin，为了是去掉重复数据，如果i=0的话，则是全部的解
        for (int i = begin; i < len; i++) {
            int cur = candidates[i];
//            剪枝，对应排序，如果加上当前数值已经小于0之后，后边的数据则不用继续递归，剪掉
            if (target - cur < 0) {
                break;
            }
            path.add(cur);
            dfs(candidates, i, len, target-cur, path, res);
//            回溯，移出当前数据
            path.remove(path.size()-1);
        }
    }
}
