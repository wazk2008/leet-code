package com.leetcode.code;

/**
 * @ClassName Code55
 * @Author ZK
 * @Description
 * @Date 2021/2/3 11:04
 * @Version 1.0
 **/
public class Code55 {

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; ) {
//            如果当前位置已经到数组的最后了，则直接返回true
            if (i >= len-1) {
                return true;
            } else {
//                如果当前位置为0，则无法跳跃，自然不能到达终点
                if (nums[i] == 0) {
                    return false;
                } else {
//                    确定下一步走到哪里，也就是迭代变量i下一次的值
                    i = max(nums, i+1, i+nums[i]);
                }
            }
        }
//        其实这个return，应该永远走不到
        return true;
    }

    /**
     * 给定一个位置区间，确定当前下一步走到当前区间的哪个位置
     * @param nums      原始数组
     * @param begin     开始位置
     * @param end       终点位置
     * @return
     */
    public static int max(int[] nums, int begin, int end){
        int len = nums.length;
//        如果终点位置已经在数组的最后了，直接返回最后位置
        if (end >= len-1) {
            return end;
        }
//        先将结果设为开始begin的位置
        int res = begin;
//        从开始begin的下一个位置开始遍历，遍历到结束end的位置
        for (int i = begin+1; i <= end; i++) {
//            获取一个 （当前距离+下一步可走距离）的最大值，i即是当前应该走到的位置
            if ( (i+nums[i]) >= (res+nums[res]) ) {
                res = i;
            }
        }
        return res;
    }

}
