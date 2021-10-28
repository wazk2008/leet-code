package com.leetcode.code;

import java.util.HashSet;
import java.util.Set;

public class Code869 {

    public static void main(String[] args) {

    }

    Set<String> set = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        init();
        return set.contains(count(n));
    }

    public void init(){
        for (int i = 1; i <= 1e9; i<<=1) {
            set.add(count(i));
        }
    }

    // 计算n中每个字符出现的次数
    public String count(int n){
        char[] arr = new char[10];
        while (n > 0) {
            arr[n%10]++;
            n /= 10;
        }
        return new String(arr);
    }

}
