package main.java.com.frs.leetcode.problem3;

class RecursiveSolution {

    private int numberOfRows;
    private int numberOfColumns;
    private int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        numberOfRows = dungeon.length;
        numberOfColumns = dungeon[0].length;
        memo = new int[numberOfRows][numberOfColumns];
        return solve(dungeon, 0, 0);
    }

    private int solve(int[][] dungeon, int row, int col) {
        int result;
        if (row >= numberOfRows || col >= numberOfColumns) {
            return 10000;
        }
        if (memo[row][col] > 0) {
            return memo[row][col];
        }
        if (row == numberOfRows - 1 && col == numberOfColumns - 1) {
            result = 1 - dungeon[row][col];
        } else {
            result = Math.min(solve(dungeon, row + 1, col), solve(dungeon, row, col + 1)) - dungeon[row][col];
        }
        memo[row][col] = Math.max(1, result);
        return memo[row][col];
    }
}
