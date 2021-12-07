package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

public class Code1034 {

    public static void main(String[] args) {

    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> border = new ArrayList<>();
        int originalColor = grid[row][col];
        visited[row][col] = true;
        // 找边界
        dfs(grid, row, col, visited, border, originalColor);
        for (int[] ints : border) {
            grid[ints[0]][ints[1]] = color;
        }
        return grid;
    }

    private void dfs (int[][] grid, int x, int y, boolean[][] visited, List<int[]> border, int originalColor) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean isBorder = false;
        for (int i = 0; i < 4; i++) {
            int nx = direction[i][0] + x, ny = direction[i][1] + y;
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBorder = true;
            } else if (!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(grid, nx, ny, visited, border, originalColor);
            }
        }
        if (isBorder) {
            border.add(new int[]{x, y});
        }
    }

    private void border (int[][] grid, int originalColor) {

    }



}
