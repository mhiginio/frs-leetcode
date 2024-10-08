package main.java.com.frs.leetcode.problem2;

class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    result++;
                    fillIsland(grid, row, col);
                }
            }
        }
        return result;
    }

    private void fillIsland(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '-';
        fillIsland(grid, row - 1, col);
        fillIsland(grid, row + 1, col);
        fillIsland(grid, row, col - 1);
        fillIsland(grid, row, col + 1);
    }
}