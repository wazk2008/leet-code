package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

public class Code412 {

    public static void main(String[] args) {

    }

    public List<String> fizzBuzz(int n) {
        List res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0) {
                sb.append("Fizz");
            }
            if (i%5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            res.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return res;
    }

}
