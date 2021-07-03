package com.leetcode.code;

import java.util.Arrays;
import java.util.Comparator;

public class Code451 {

    public static void main(String[] args) {
        String s = "cccbbeaaaA";
        frequencySort(s);
    }

    public static String frequencySort(String s) {
        int len = 128;
        char[] chars = s.toCharArray();

//        定义一个二维数组
//        128行  2列
//        第一列：每个字符的ASCII值
//        第二列：每个字符出现的次数
        int[][] cnts = new int[len][2];
        for (int i = 0; i < len; i++) {
            cnts[i][0] = i;
        }
//        统计每个字符出现的次数
        for (char c : chars) {
            cnts[c][1]++;
        }

//        二维数组的排序
        Arrays.sort(cnts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                根据第二列次数的大小进行排序，排序的是当前的 cnts[][]
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = (char)cnts[i][0];
            int n = cnts[i][1];
            for (int j = 0; j < n; j++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
