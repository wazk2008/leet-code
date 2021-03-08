package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code132
 * @Author: ZK
 * @Date: 2021/3/8 22:16
 * @Version: 1.0
 */
public class Code132 {

    public static void main(String[] args) {
        String s = "aab";
        minCut(s);

    }

//    动态规划
//    1。先用dp数组来保存子串 [i, j] 是否为回文串
//    2。再用f{j}函数来表示 j 下标对应结尾的字符串的最小分割次数
//        需要考虑 j 是否会独立占用一次分割
//        先按照需要独立占用一次分割来计算，然后遍历到 j 的位置，判断是否有对应的 [i, j] 形成回文串，也就是 f[j] = Math.min(f[j], f[i-1]+1);
    public static int minCut(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();

//        动态规划，设置dp数组来保存子串 [i, j] 是否为回文串
        boolean[][] st = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
//                当 [i, j] 只有一个字符时，必然是回文串
                if (i == j) {
                    st[i][j] = true;
                } else {
//                    当 [i, j] 长度为 2 时，满足 cs[i] == cs[j] 即回文串
                    if (j-i == 1) {
                        st[i][j] = cs[i]==cs[j];
                    } else {
//                        当 [i, j] 长度超过 2 时，满足 cs[i]==cs[j] && f[i+1][j-1]==true 即回文串
//                        st[i][j] = cs[i]==cs[j] && cs[i+1]==cs[j-1];
                        st[i][j] = cs[i]==cs[j] && st[i+1][j-1];
                    }
                }
            }
        }

//        设：f{i}函数 代表下标为 i 的字符为结尾的最小分割次数
        int[] f = new int[len];
        for (int j = 1; j < len; j++) {
//            如果 [0, j] 为一个回文串，则无序分割
            if (st[0][j]) {
                f[j] = 0;
            } else {
//                如果 [0, j] 不是一个回文串，那么则依赖于 f[j-1]，即 f[j] = f[j-1]+1
//                注意：此时 j 是需要独立的占用一个分割次数,例如："aabbc"，j=4, f[j] = f[j-1]+1
//                备注：此时先按照 j 需要独立占用一个分割次数来计算，下边进行 min 计算
                f[j] = f[j-1] + 1;

//                但是：如果 j 不需要独立占用一个分割次数，例如："aabb", j=3, f[j]=f[j-1]+1 则错误
//                此时则需要与前边的某个 i 形成区间 [i, j]，使得 [i, j] 回文
                for (int i = 0; i < j; i++) {
                    if (st[i][j]) {
                        f[j] = Math.min(f[j], f[i-1]+1);
                    }
                }
            }
        }

        return f[len-1];
    }

}
