package com.leetcode.code;

import java.util.Stack;

/**
 * @Description:
 * @ClassName: Code150
 * @Author: ZK
 * @Date: 2021/3/20 13:54
 * @Version: 1.0
 */
public class Code150 {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    public static int evalRPN(String[] tokens) {
        int res = 0;
        int len = tokens.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.peek();
    }

    public static boolean isNumber(String str){
        return !("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str));
    }

}
