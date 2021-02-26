package com.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName: Code1178
 * @Author: ZK
 * @Date: 2021/2/26 23:21
 * @Version: 1.0
 */
public class Code1178 {

    public static void main(String[] args) {
        String str = "abcd";
        int mask = getBitMask(str);
        System.out.println(mask);
    }

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();

//        words状态压缩
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int key = getBitMask(word);
            if (Integer.bitCount(key) <= 7) {
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }

        for (String puzzle : puzzles) {
            int count = 0;

//            枚举每一个puzzle的所有子集
            // 第一个字符必须存在，先获取第一个字符的二进制码
            int first = getBitMask(puzzle.substring(0, 1));
            // 获取后面字符串的二进制码
            int mask = getBitMask(puzzle.substring(1));
            int subset = mask;
            // 枚举后面字符串子集
            while (subset != 0) {
                int key = first | subset;
                if (map.containsKey(key)) {
                    count += map.get(key);
                }
                subset = (subset - 1) & mask;
            }
            // 后面字符串为空的情况
            if (map.containsKey(first)) {
                count += map.get(first);
            }

            res.add(count);
        }

        return res;
    }

//    word状态压缩
    public static int getBitMask(String word){
        int mask = 0;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            mask |= 1 << (c-'a');
        }
        return mask;
    }

}
