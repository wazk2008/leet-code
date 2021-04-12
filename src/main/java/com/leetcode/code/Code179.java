package com.leetcode.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @ClassName: Code179
 * @Author: ZK
 * @Date: 2021/4/12 22:21
 * @Version: 1.0
 */
public class Code179 {

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
//        1.定义排序函数
//        2.排序
//        3.输出结果

        int len = nums.length;
        String[] strNums = new String[len];
        for (int i = 0; i < len; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                3,30 => 3,30
//                3,32 => 3,32
//                3,34 => 34,3
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuffer res = new StringBuffer();
        if (strNums[0].equals("0")) {
            return "0";
        }
        for (int i = 0; i < len; i++) {
            res.append(strNums[i]);
        }

        return res.toString();
    }


}
