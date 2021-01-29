package com.leetcode.code;

/**
 * @ClassName Code45
 * @Author ZK
 * @Description
 * @Date 2021/1/27 14:50
 * @Version 1.0
 **/
public class Code45 {

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4,2,4,6,1,4,7,2,4,1,1,3,2,2,3,1,1,1,4};
        int[] nums = {9,7,9,4,8,1,6,1,5,6,2,1,7,9,0};
        int count = jump(nums);
        System.out.println("count:" + count);
    }

    public static int jump(int[] nums) {
        int len = nums.length;
        int steps = 0;

//        如果数组中只有一个元素，返回0，不用走
        if (len == 1){
            return steps;
        }

//        模拟跳跃走路的过程，每次i直接走到下一个目标点，所以for对应的括号内没有标明迭代变量的变化i++这样的等式
        for (int i = 0; i < len; ) {
//            确定下一步走到哪里，也就是确定迭代变量i下一步的位置下标
            i = max(nums, i + 1, i + nums[i]);
//            走一步，步数+1
            steps++;
//            如果最后一步走完到达数组末尾，或者超出数组，则直接break
            if (i >= len-1) {
                break;
            }
        }
        return steps;
    }

    /**
     * 下一步最优走到哪里
     * 例如：例：[3,2,0,1,4] 从3开始走，此时遍历范围就是[2,0,1]
     * begin：1  end:3   return:3
     * @param nums  原始数组
     * @param begin 下一步的起始下标（包含）
     * @param end   下一步的终止下标（包含）
     * @return      下一步应走到哪里 的下标
     */
    public static int max(int[] nums, int begin, int end){
//        如果这一步最后可以走到数组的末尾，或者可以超出数组，直接返回
        if (end >= nums.length-1) {
            return end;
        }
        int res = begin;
        for (int i = begin+1; i <= end; i++) {
//            走到哪一步，以及下一步可以走的更远
//            例：3,2,0,1,4 从3开始走
//            ① 3->2->1->4
//            ② 3->1>4
//            应选择方案2，但是在3的步骤内，2比1大，此时应该是2+1 < 1+3   选择(下一步可以走多远+本次走了几步)最大值
//            即 防止3->2->1这样的事件发生，而应该直接是3->1，也就是在一个大步内防止走两次才走出去
//            上边是原式，下边是化简之后的结果
//            if (i < nums.length && nums[i]+(i-begin)+1 >= nums[res]+(res-begin)+1) {
            if (i < nums.length && nums[i]+i >= nums[res]+res) {
                res = i;
            }
        }
        return res;
    }

}
