package main.java.com.frs.leetcode.problem3;

class Solution {

    private int numberOfRows;
    private int numberOfColumns;
    private int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {
        numberOfRows = dungeon.length;
        numberOfColumns = dungeon[0].length;
        dp = new int[numberOfRows][numberOfColumns];
        fillBaseCases(dungeon);
        solveProblem(dungeon);
        return dp[0][0];
    }

    private void fillBaseCases(int[][] dungeon) {
        dp[numberOfRows - 1][numberOfColumns - 1] = Math.max(1, 1 - dungeon[numberOfRows - 1][numberOfColumns - 1]);
        for (int col = numberOfColumns - 2; col >= 0; col--) {
            dp[numberOfRows - 1][col] = Math.max(1, dp[numberOfRows - 1][col + 1] - dungeon[numberOfRows - 1][col]);
        }
        for (int row = numberOfRows - 2; row >= 0; row--) {
            dp[row][numberOfColumns - 1] = Math.max(1, dp[row + 1][numberOfColumns - 1] - dungeon[row][numberOfColumns - 1]);
        }
    }

    private void solveProblem(int[][] dungeon) {
        for (int col = numberOfColumns - 2; col >= 0; col--) {
            for (int row = numberOfRows - 2; row >= 0; row--) {
                int bestPath = Math.min(dp[row + 1][col], dp[row][col + 1]);
                dp[row][col] = Math.max(1, bestPath - dungeon[row][col]);
            }
        }
    }
}
