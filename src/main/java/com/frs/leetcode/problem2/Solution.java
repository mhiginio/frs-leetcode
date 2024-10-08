package main.java.com.frs.leetcode.problem2;

class Solution {

    private static final Movement[] DIRECTIONS = new Movement[]{
        new Movement(-1, 0),
        new Movement(1, 0),
        new Movement(0, 1),
        new Movement(0, -1)
    };

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (isLand(grid, row, col)) {
                    result++;
                    fillIsland(grid, row, col);
                }
            }
        }
        return result;
    }

    private static boolean isLand(char[][] grid, int row, int col) {
        return grid[row][col] == '1';
    }

    private void fillIsland(char[][] grid, int row, int col) {
        if (isOutOfRange(grid, row, col) || !isLand(grid, row, col)) {
            return;
        }
        grid[row][col] = '-';
        for (Movement direction : DIRECTIONS) {
            fillIsland(grid, row + direction.row(), col + direction.column());
        }
    }

    private boolean isOutOfRange(char[][] grid, int row, int col) {
        return row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
    }

    public record Movement(int row, int column) {

    }
}