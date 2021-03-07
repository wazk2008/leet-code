package com.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @ClassName: Code131
 * @Author: ZK
 * @Date: 2021/3/7 22:25
 * @Version: 1.0
 */
public class Code131 {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }

    public static List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, len, stack, res);
        return res;
    }

    /**
     * dfs
     * @param chars     字符数组
     * @param index     起始下标
     * @param len       字符串长度
     * @param stack     栈，用来存储子串
     * @param res       存储所有的结果
     */
    public static void dfs(char[] chars, int index, int len, Stack<String> stack, List<List<String>> res){
        if (index == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < len; i++) {
//            判断当前子串是否回文
            if (!isHuiWen(chars, index, i)) {
                continue;
            }
//            如果回文，则添加到栈中
            stack.push(new String(chars, index, i-index+1));
            dfs(chars, i+1, len, stack, res);
//            回溯
            stack.pop();
        }
    }

    /**
     * 判断一个字符串是否回文
     * @param chars     字符数组
     * @param left      起始下标，包含
     * @param right     结束下标，包含
     * @return
     */
    public static boolean isHuiWen(char[] chars, int left, int right){
        while(left < right){
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
