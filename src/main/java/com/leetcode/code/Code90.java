package com.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @ClassName: Code90
 * @Author: ZK
 * @Date: 2021/3/31 22:40
 * @Version: 1.0
 */
public class Code90 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
//        int[] nums = {1,2,3,4};
        List<List<Integer>> lists = subsetsWithDup(nums);
        for (List<Integer> integerList : lists) {
            int len = integerList.size();
            System.out.print("[");
            for (int i = 0; i < len; i++) {
                if (i < len-1) {
                    System.out.print(integerList.get(i) + ", ");
                } else {
                    System.out.print(integerList.get(i));
                }
            }
            System.out.println("]");
        }
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        排序，目的是让相同的元素相邻，便于去重
        Arrays.sort(nums);
        int len = nums.length;
//        使用boolean数组来记录对应的元素在当前路径中是否被使用过
        boolean[] visited = new boolean[len];
//        开始递归回溯
        backtrace(nums, 0, visited, len);
        return res;
    }

    public static void backtrace(int[] nums, int start, boolean[] visited, int len){
//        首先保存当前路径，也能保存到初始的[]
        res.add(new ArrayList<>(list));
//        从start开始遍历后边的没一个元素，尝试添加到路径中
        for (int i = start; i < len; i++) {
//            如果当前元素和前一个元素相同，且前一个元素没有被访问过(回溯时会将其置为false，其实已经被用过了)，说明前一个元素在当前层次的路径中已经被访问过了
            if (i>0 && nums[i-1]==nums[i] && !visited[i-1]) {
                continue;
            }
//            将当前元素添加到本次的路径中
            list.add(nums[i]);
//            当前元素在本次路径中已经被访问过，记为true
            visited[i] = true;
//            递归向下走
            backtrace(nums, i+1, visited, len);
//            回溯，将当前元素置为false
            visited[i] = false;
//            从本次路径中移除掉当前元素
            list.remove(list.size()-1);
        }
    }

}
