package com.leetcode.code;

import java.util.Arrays;

/**
 * @Description:
 * @ClassName: Code395
 * @Author: ZK
 * @Date: 2021/2/27 00:22
 * @Version: 1.0
 */
public class Code395 {

    public static void main(String[] args) {
        String s = "aaaabbcccdeee";
        System.out.println(longestSubstring(s, 3));

        String[] split = "aaaabbbccddeeebff".split("[bd]");
        System.out.println(Arrays.toString(split));

    }

    public static int longestSubstring(String s, int k) {
        int res = 0;
        int len = s.length();
//        统计所有的字母出现个数
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c-'a']++;
        }
//        将每个不符合题意的字符加入到分隔符中
        boolean flag = true;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < 26; i++) {
//            不满足题意，字符添加到分隔符sb中
            if (map[i]>0 && map[i]<k) {
                flag = false;
                sb.append((char)(i+'a'));
            }
        }
        sb.append("]");
//        如果当前字符串不用分割，则全部满足题意，直接返回len
        if (flag) {
            return len;
        }
//        将字符串进行分割，对于每个分割的子串依次进行递归判断
        String[] strs = s.split(sb.toString());
        for (String str : strs) {
            if ("".equals(str)) {
                continue;
            }
            res = Math.max(longestSubstring(str, k), res);
        }

        return res;
    }

}
