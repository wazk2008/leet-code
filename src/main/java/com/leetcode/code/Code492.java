package com.leetcode.code;

public class Code492 {

    public static void main(String[] args) {

    }

    public int[] constructRectangle(int area) {
        int width = (int)Math.sqrt(area);
        while (area%width != 0) {
            width--;
        }
        return new int[]{width, area/width};
    }

}
