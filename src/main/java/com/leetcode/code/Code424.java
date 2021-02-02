package com.leetcode.code;

/**
 * @ClassName Code424
 * @Author ZK
 * @Description
 * @Date 2021/2/2 10:37
 * @Version 1.0
 **/
public class Code424 {

    public static void main(String[] args) {
        String str = "AABABBA";
        int i = characterReplacement(str, 1);
        System.out.println(i);
    }

    /**
     * 滑动窗口
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        int len = s.length();
//        使用hash表来存储每个字符的个数情况（26个大写英文字母，故数组长度为26）
        int[] map = new int[26];
//        窗口在滑动中最佳时期某个字符的最大个数
//        max+k保持窗口的最大情况
        int max = 0;
//        初始情况下窗口位于[0,0]的位置
        int left = 0;
        int right = 0;

//        遍历字符串
        for (right = 0; right < len; right++) {
//            对于当前字符进行计数
            int x = s.charAt(right) - 'A';
            map[x]++;
//            比较得到最大值
            max = Math.max(max, map[x]);
//            窗口移动
//            (right - left + 1) >  (max + k)   窗口移动；right++  left++
//            (right - left + 1) <= (max + k)   窗口扩张：right++  left不动
            if ( (right - left +1) > (max + k) ) {
//                将窗口中最左边的字符计数-1，因为当前字符即将从窗口中移除掉
                map[s.charAt(left) - 'A']--;
//                窗口移动
                left++;
            }
        }
//        循环完毕，right=len，恰好right-left表示窗口宽度
        return right-left;
    }

}
