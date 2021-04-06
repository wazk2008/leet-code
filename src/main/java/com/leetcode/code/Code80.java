package com.leetcode.code;

import java.util.Arrays;

/**
 * @author: zhangkun@codemao.cn
 * @description:
 * @create: 2021-04-06 17:59
 * @Version 1.0
 **/
public class Code80 {

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,3,3};
        int[] nums = {1,1,1,2,2,3};
//        int[] nums = {1,1,1,1,2,2,3};
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

//    记录当前元素在后边出现的数量
//    如果小于2，则后移一步
//    如果大于2，则后移两步，并使后移两步里边的元素相同
//    移动完毕后用下一个元素代替当前位置的元素
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1 || len == 2) {
            return len;
        }
//        定义fast，用来向前遍历，fast指向的是下一个不相同的元素
        int fast = 1;
//        定义slow，用来重写重复的元素
        int slow = 0;
//        计数，来表示slow指向的元素的数量
        int sum = 1;

        while (fast < len) {
//            如果fast指向当前元素和上一个元素相同
            if (nums[fast] == nums[fast-1]) {
//                则该元素数量+1，fast后移并且continue
                sum++;
                fast++;
                continue;
            } else {
//                如果fast指向的元素和上一个元素不相同时，则表示和slow指向的元素相同的数量找完了
//                对slow指向的元素数量进行判断
//                如果相同数量为1，则slow向后移动一步
                if (sum < 2) {
                    slow++;
                } else {
//                    如果相同数量大于1
//                    slow的下一个元素需要和slow指向的当前元素相同
                    nums[slow+1] = nums[slow];
//                    slow向后移动两步
                    slow+=2;
//                    重新开始对slow指向的元素进行计数
                    sum = 1;
                }
//                移动后的位置用fast指向的元素代替
                nums[slow] = nums[fast];
                fast++;
            }
        }
//        fast遍历完数组后，需要对sum再进行一次判断
//        如果sum大于1，则表示slow指向的元素数量至少为2个
        if (sum > 1) {
//            slow需醒后移动一步，并且用最后一个元素进行代替
            nums[++slow] = nums[fast-1];
        }
//        由于slow指向的是下标的位置，所以最终数量需要+1
        return slow+1;
    }

}