package com.leetcode.code;

/**
 * @ClassName Code43
 * @Author ZK
 * @Description
 * @Date 2021/1/27 10:28
 * @Version 1.0
 **/
public class Code43 {

    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "567";
        multiply(num1, num2);
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();

//        做乘法
        int[] ans = new int[len1 + len2];
        for (int i = len1-1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = len2-1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int m = a * b;
//                int index = (len1 + len2 - 1) - (len1-1 - i) - (len2-1 - j);
                int index =  i + j + 1;
                if (m > 9) {
                    ans[index] += m%10;
                    ans[index-1] += m/10;
                } else {
                    ans[index] += m;
                }
            }
        }

//        计算依次相加进位
        int n = 0;
        for (int i = ans.length-1; i >= 0; i--) {
            int cur = ans[i] + n;
            ans[i] = cur%10;
            n = cur / 10;
        }

//        最后转成string
        StringBuilder sb = new StringBuilder();
        int index = ans[0] == 0 ? 1 : 0;
        for (int i = index; i < ans.length; i++) {
            sb.append(ans[i]);
        }


        return sb.toString();
    }

}
