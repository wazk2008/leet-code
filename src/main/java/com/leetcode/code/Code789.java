package com.leetcode.code;

public class Code789 {
    public static void main(String[] args) {

    }

    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] origin = {0, 0};
        int distance = getDistance(origin, target);
        for (int[] ghost : ghosts) {
            int ghostDistance = getDistance(ghost, target);
            if (ghostDistance <= distance) {
                return false;
            }
        }
        return true;
    }

    private static int getDistance(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }

}
