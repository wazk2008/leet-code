package com.leetcode.code;

/**
 * @ClassName Code58
 * @Author ZK
 * @Description
 * @Date 2021/2/4 9:59
 * @Version 1.0
 **/
public class Code58 {

    public static void main(String[] args) {
        String str = "hello world";
        int i = lengthOfLastWord(str);
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        int index = len-1;
        for (index = len-1; index >= 0; index--) {
            char curChar = s.charAt(index);
            if (curChar == ' ') {
                if (count == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                count++;
            }
        }
        if (index == -1) {
            count = 0;
        }
        return count;
    }

}
