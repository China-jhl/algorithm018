package com.most.av.videoapp.algorithm;

public class Land {
    public int numIslands(char[][] grid) {
        int landNum = 0;
        if (grid != null && grid.length > 0) {
            for (int rol = 0; rol < grid.length; rol++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[rol][col] == '1') {
                        landNum++;
                        dfs(grid, rol, col);
                    }
                }
            }
        }

        return landNum;
    }

    private void dfs(char[][] grid, int rol, int col) {
        if (rol < 0 || col < 0 || rol >= grid.length || col >= grid[0].length
                || grid[rol][col] == '0') return;
        grid[rol][col] = '0';
        dfs(grid, rol, col - 1);
        dfs(grid, rol, col + 1);
        dfs(grid, rol + 1, col);
        dfs(grid, rol - 1, col);
    }
}
