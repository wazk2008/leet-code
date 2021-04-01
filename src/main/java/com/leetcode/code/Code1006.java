package com.leetcode.code;

import java.util.Stack;

/**
 * @Description:
 * @ClassName: Code1006
 * @Author: ZK
 * @Date: 2021/4/1 22:53
 * @Version: 1.0
 */
public class Code1006 {

    public static void main(String[] args) {
        int N = 10;
        System.out.println(clumsy(N));
    }

//    用栈，最直接的思路与方法
    public static int clumsy(int N) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
//        第一个数字先入栈
        stack.push(N);

        for (int i = 1; i < N; i++) {
//            得到第2,3,4...个数字
            int cur = N - i;
//            如果是第2个数字，相乘
            if (i % 4 == 1) {
                stack.push(stack.pop() * cur);
//                如果是第3个数字，相除
            } else if (i % 4 == 2) {
                stack.push(stack.pop() / cur);
//                如果是第4个数字，入栈
            } else if (i % 4 == 3) {
                stack.push(cur);
//                如果是第5个数字，相反数入栈
            } else if (i % 4 == 0) {
                stack.push(-cur);
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

//    数学公式推导
//    如下是大佬的推导过程
//    https://leetcode-cn.com/problems/clumsy-factorial/solution/gong-shi-tui-dao-ji-suan-ji-bai-liao-100-xkbv/
    public static int clumsy1(int N) {
        if (N == 1 || N == 2) {
            return N;
        }
        if (N == 3) {
            return 6;
        }
        if (N == 4) {
            return 7;
        }
//        以上是特殊情况，如下是数学公式推导
        if (N % 4 == 0) {
            return N + 1;
        }else if (N % 4 == 1 || N % 4 == 2) {
            return N + 2;
        } else {
            return N -1;
        }
    }

}
