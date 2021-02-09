package com.leetcode.contest.week2;

/**
 * @Description:
 * @ClassName: Code5659
 * @Author: ZK
 * @Date: 2021/2/6 23:46
 * @Version: 1.0
 */
public class Code5659 {

    public static void main(String[] args) {
        String str = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
//        String str = "bbbbbbb";
        System.out.println(minimumLength(str));
    }

    public static int minimumLength(String s) {
        int len = s.length();
        int left = 0;
        int right = len-1;

        while(left < right){
            if (s.charAt(left) == s.charAt(right)) {
//                左指针右移
                left = getLeftIndex(s, left);
//                右指针左移
                right = getRightIndex(s, right);
            } else {
                break;
            }
        }
//        如果最后相等的恰好相邻，例如“aa”,那么left将大于right
        if (left > right) {
            return 0;
        }
//        如果最后相等的恰好中间还有一个，例如“aba”，那么left和right都将==b
//        如果最后相等的恰好中间右多个，例如“abcda”，那么left将远小于right
        return right - left + 1;
    }


    public static int getLeftIndex(String str, int curIndex){
        int len = str.length();
        for (int i = curIndex+1; i < len; i++) {
            if (str.charAt(i) != str.charAt(curIndex)){
                return i;
            }
        }
        return len;
    }

    public static int getRightIndex(String str, int curIndex){
        int len = str.length();
        for (int i = curIndex-1; i >= 0; i--) {
            if (str.charAt(i) != str.charAt(curIndex)) {
                return i;
            }
        }
        return -1;
    }

}
