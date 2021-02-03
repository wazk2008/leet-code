package com.leetcode.code;

import java.util.Arrays;

/**
 * @ClassName Code480
 * @Author ZK
 * @Description
 * @Date 2021/2/3 9:58
 * @Version 1.0
 **/
public class Code480 {

    public static void main(String[] args) {
        int[] nums = {1,4,2,3};
        double[] res = medianSlidingWindow(nums, 4);
        System.out.println(Arrays.toString(res));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] res = new double[len-k+1];
        for (int i = 0; i <= len-k; i++) {
//            System.out.println(i + "\t" + (i+k-1));
            double median = getMedian(nums, i, i + k - 1);
            res[i] = median;
        }
        return res;
    }

    public static double getMedian(int[] nums, int begin, int end){
        int len = end - begin + 1;
        int[] temp = new int[len];
        int index = 0;
        for (int i = begin; i <= end; i++) {
            temp[index++] = nums[i];
        }
        Arrays.sort(temp);
//        奇数
        if ((len & 1) == 1) {
            return temp[len/2];
        } else {
//            偶数
            return ((double) temp[len/2] + temp[(len-1)/2])/2;
        }
    }


}
