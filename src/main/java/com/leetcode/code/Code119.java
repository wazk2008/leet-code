package com.leetcode.code;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code119
 * @Author ZK
 * @Description
 * @Date 2021/2/13 22:38
 * @Version 1.0
 **/
public class Code119 {

    public static void main(String[] args) {
//        int num = getNum(8, 0);
//        System.out.println(num);

        System.out.println(getRow(10));


    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < rowIndex/2+1; i++) {
            res.add(getNum(rowIndex, i));
        }
        int len = res.size();
        for (int i = 0; i < len; i++) {
            res.get(i);
        }
        len = (rowIndex&1)==1 ? res.size() : res.size()-1;
        for (int i = len-1; i >= 0; i--) {
            res.add(res.get(i));
        }

        return res;
    }

    public static int getNum(int n, int r){
        BigInteger sum = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int i = n-r+1; i <= n; i++) {
//            sum *= i;
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        for (int i = 2; i <= r; i++) {
//            c *= i;
            c = c.multiply(BigInteger.valueOf(i));
        }
        return Integer.valueOf(sum.divide(c).toString());
    }

}
