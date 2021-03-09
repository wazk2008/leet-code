package com.leetcode.code;

import java.util.Stack;

/**
 * @ClassName Code1047
 * @Author ZK
 * @Description
 * @Date 2021/3/9 10:40
 * @Version 1.0
 **/
public class Code1047 {

    public static void main(String[] args) {
        String S = "abbaca";
        System.out.println(removeDuplicates2(S));
    }

    /**
     * 使用栈解决，判断每一个字符和栈顶字符是否一样，一样则出栈，否则入栈
     * @param S
     * @return
     */
    public static String removeDuplicates(String S) {
        int len = S.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        if (len == 1) {
            return sb.toString();
        }


        for (int i = 0; i < len; i++) {
            char curChar = S.charAt(i);

            if (stack.isEmpty() || stack.peek()!=curChar) {
                stack.push(curChar);
            } else {
                stack.pop();
            }

        }

        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    /**
     * 不使用栈，直接使用StringBuilder
     * 判断当前字符和sb中的最后一个字符是否一致
     * 如果一致，则移出sb中的最后一个字符
     * 如果不一致，则添加到sb的末尾
     * @param S
     * @return
     */
    public static String removeDuplicates1(String S) {
        int len = S.length();
        StringBuilder sb = new StringBuilder();
        if (len == 1) {
            return sb.toString();
        }

        for (int i = 0; i < len; i++) {
            char curChar = S.charAt(i);

            if (sb.length() == 0 || sb.charAt(sb.length()-1)!=curChar) {
                sb.append(curChar);
            } else {
                sb = sb.deleteCharAt(sb.length()-1);
            }

        }

        return sb.toString();
    }

    /**
     * 使用数组来记录不一样的字符，使用index来记录最后一个有效元素（不一样元素）的位置
     * 判断数组中最后一个有效元素是否和当前元素一致
     * 如果一致，则数组index--
     * 如果不一致，则将当前字符放置到数组++index的位置
     * @param S
     * @return
     */
    public static String removeDuplicates2(String S) {
        int len = S.length();
        char[] res = new char[len];

        int index = -1;

        for (int i = 0; i < len; i++) {
            char curChar = S.charAt(i);

            if (index >= 0 && res[index]==curChar) {
                index--;
            } else {
                res[++index] = curChar;
            }
        }

        return new String(res, 0, index+1);
    }


}
