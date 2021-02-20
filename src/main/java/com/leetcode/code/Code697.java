package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName: Code697
 * @Author: ZK
 * @Date: 2021/2/20 22:56
 * @Version: 1.0
 */
public class Code697 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 3, 1};
        int[] nums = {1,2,2,3,1,4,2};
//        int res = findShortestSubArray(nums);
        int res = findShortestSubArray1(nums);
        System.out.println(res);
    }


//    方法一   超过12%
    public static int findShortestSubArray(int[] nums) {
        int len = nums.length;
        int du = 0;
        int res = len;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> duList = new ArrayList<>();
//        获取每个数字出现的次数
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
//        找到最大的du
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            du = Math.max(du, entry.getValue());
        }
//        找到最大du对应的数字，添加到集合中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (du == entry.getValue()) {
                duList.add(entry.getKey());
            }
        }

//        遍历最大du对应的数字
        for (Integer num : duList) {
//            找到该数字的第一个下标（从前往后遍历）
            int first = getIndexFirst(num, nums);
//            找到该数字的最后一个下标（从后往前遍历）
            int end = getIndexEnd(num, nums);
//            取最小的范围
            res = Math.min(res, end-first+1);
        }

        return res;
    }

    public static int getIndexFirst(int num, int[] nums){
        int index = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == num){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int getIndexEnd(int num, int[] nums){
        int index = 0;
        int len = nums.length;
        for (int i = len-1; i >= 0; i--) {
            if (nums[i] == num){
                index = i;
                break;
            }
        }
        return index;
    }



    //    方法二   超过66%
    public static int findShortestSubArray1(int[] nums) {
        int len = nums.length;
        int res = len;
        int du = 0;
//        key：num   value：出现的次数
        Map<Integer, Integer> map = new HashMap<>();
//        key：num   value：{num的第一个下标，num的最后一个下标}
        Map<Integer, int[]> dus = new HashMap<>();
//        获取每个数字出现的次数
//        获取每个数字出现的第一个下标和最后一个下标
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, count+1);

                int[] arr = dus.get(num);
                arr[1] = i;
                dus.put(num, arr);
            } else {
                map.put(num, 1);
                int[] arr = {i, i};
                dus.put(num, arr);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            如果遇到du一样的，则res取最小
            if (du == entry.getValue()) {
                int[] arr = dus.get(entry.getKey());
                res = Math.min(res, arr[1] - arr[0] + 1);
            }
//            如果遇到更大的du，则取更大du的res
            if (du < entry.getValue()) {
                du = entry.getValue();
                int[] arr = dus.get(entry.getKey());
                res = arr[1] - arr[0] + 1;
            }
        }

        return res;
    }

}
