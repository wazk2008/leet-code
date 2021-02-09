package com.leetcode.code;

/**
 * @ClassName Code1208
 * @Author ZK
 * @Description
 * @Date 2021/2/5 14:03
 * @Version 1.0
 **/
public class Code1208 {

    public static void main(String[] args) {

        String s = "pxezla";
        String t = "loewbi";
        System.out.println(equalSubstring(s, t, 25));
//        getCost(s, t);
    }

    public static void getCost(String s, String t){
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Math.abs(s.charAt(i) - t.charAt(i)));
        }
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();

//        定义最大开销
        int sumCost = 0;
        int left = 0;
        int right = -1;

        for (int i = 0; i < len; i++) {
            int curCost = Math.abs(s.charAt(i) - t.charAt(i));
//            窗口移动
            if(sumCost + curCost > maxCost){
                if (sumCost != 0) {
                    int leftCost = Math.abs(s.charAt(left) - t.charAt(left));
                    sumCost = sumCost - leftCost + curCost;
                }
                right++;
                left++;
            } else {    // 窗口扩张
                sumCost += curCost;
                right++;
            }
        }
        if (right < left) {
            return 0;
        } else {
            return right - left + 1;
        }
    }

}
