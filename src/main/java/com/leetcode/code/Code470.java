package com.leetcode.code;

public class Code470 {

    public static void main(String[] args) {

    }

    public static int rand10() {
        int first, second;
//        first生成的区间为：[1, 6]，奇数偶数各占3个，用来表达2的情况
        while ((first = rand7()) > 6);
//        second生成的区间为：[1, 5]，second*2之后用来表示[1，10]的情况
        while ((second = rand7()) > 5);
        return (first&1)==1 ? second : second+5;
    }

    public static int rand7(){return 0;}

}
