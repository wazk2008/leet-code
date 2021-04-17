package com.leetcode.code;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:
 * @ClassName: Code220
 * @Author: ZK
 * @Date: 2021/4/17 22:44
 * @Version: 1.0
 */
public class Code220 {

    public static void main(String[] args) {
//        TreeSet<Long> set = new TreeSet<>();
//        set.add(2l);
//        set.add(4l);
//        set.add(6l);
//        set.add(8l);
//        Long s = set.ceiling(5l);
//        System.out.println(s);
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            long num = nums[i];
            Long ceiling = set.ceiling(num - t);
            if (ceiling!=null && ceiling<=(num+t)) {
                return true;
            }
            set.add(num);
            if (i >= k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

}
