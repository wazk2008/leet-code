package com.leetcode.code;

import java.util.Stack;

public class Code678 {

    public static void main(String[] args) {
        String s = "(()*";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
                continue;
            }
            if (c == '*') {
                starStack.push(i);
                continue;
            }
            if (c == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else {
                    if (starStack.isEmpty()) {
                        return false;
                    } else {
                        starStack.pop();
                    }
                }
            }
        }

        if (starStack.size() < leftStack.size()) {
            return false;
        } else {
            while (!leftStack.isEmpty()) {
                Integer leftIdx = leftStack.pop();
                Integer starIdx = starStack.pop();
                if (leftIdx > starIdx) {
                    return false;
                }
            }
        }

        return true;
    }

}
