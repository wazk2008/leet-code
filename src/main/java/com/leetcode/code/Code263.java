package com.leetcode.code;

/**
 * @Description:
 * @ClassName: Code263
 * @Author: ZK
 * @Date: 2021/4/10 22:56
 * @Version: 1.0
 */
public class Code263 {

    public static void main(String[] args) {
        System.out.println(isUgly(0));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while(n != 1){
            if (n % 5 == 0) {
                n /= 5;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 5) {
                n >>= 1;
            } else {
                return false;
            }
        }
        return true;
    }

}
