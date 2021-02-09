package com.leetcode.code;

/**
 * @ClassName Code992
 * @Author ZK
 * @Description
 * @Date 2021/2/9 23:30
 * @Version 1.0
 **/
public class Code992 {

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        int num = subarraysWithKDistinct(arr, k);
        System.out.println(num);
    }

    /**
     * 获取恰好为 K 个不同整数的子数组数量
     * 最多K个不同整数的子数组数量 - 最多K-1个不同整数子数组的数量
     * 相减的关系
     * @param A     原始数组
     * @param K     K的个数
     * @return      结果数量
     */
    public static int subarraysWithKDistinct(int[] A, int K) {
        return getMaxNum(A, K) - getMaxNum(A, K-1);
    }

    /**
     * 获取最多为 K 个不同整数的子数组数量
     * @param A     原始数组
     * @param K     K的个数
     * @return      结果数量
     */
    public static int getMaxNum(int[] A, int K){
        int len = A.length;
        int res = 0;
//        count表示是对于不同数字的计数,在[left-right)的区间内，有count个不同的数字，
        int count = 0;
        int left = 0;
        int right = 0;
//        定义hash数组，用A中的数字来做为map中的下标
        int[] map = new int[len+1];

        for (int i = 0; i < len; i++) {
//            右指针不断的向右移动，每次计算完一次，right自动++
//            如果A[right]在map中作为下标对应数值为0，表示该数字目前只出现了1次，count++
//            如果数值不为0，表示该数字目前已经是多次出现，count不变
            if (map[A[right++]]++ == 0) {
                count++;
            }
//            如果count>K,表示不同的数字已经超过了预期，此时需要移动左指针
            while (count > K) {
//                开始计算左指针，计算完毕，左指针自动向右移动
//                如果A[left]在map中作为下标对应数值先减1之后的结果不为0，则表示还有多次出现
//                如果数值为0，表示当前left下标对应的数字，已经从[left，right)区间中移出完毕，此时count--
                if (--map[A[left++]] == 0) {
                    count--;
                }
            }
//            right指针每向右移动一次，都会计算count和K的大小差，也就是计算当前[left,right)中的不同整数个数
//            如果有超过K，则会进行left指针的移动，同时，当前right对应的区间[left,right)内K个不同整数的子数组个数新增的数量为right-left
            res += right - left;
        }
        return res;
    }

}
