package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code1052
 * @Author: ZK
 * @Date: 2021/2/23 21:59
 * @Version: 1.0
 */
public class Code1052 {

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        int x = 3;
        System.out.println(maxSatisfied(customers, grumpy, x));
    }

//    思路：先把所有不生气的累加起来，然后滑动窗口，加上滑动窗口中生气的人数
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        int len = customers.length;
//        1.先把所有不生气的累加起来
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
//        2.把起始窗口中的生气人数加起来，几座extra
        int extra = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
        }
//        3.窗口滑动，移除左边为生气的人数，加上右边为生气的人数
        int max = sum + extra;
        for (int i = X; i < len; i++) {
//            移除左边为生气的人数
            if (grumpy[i-X] == 1) {
                extra -= customers[i-X];
            }
//            加上右边为生气的人数
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
//            每次取max，获取最大值
            max = Math.max(max, sum+extra);
        }

        return max;
    }

}
