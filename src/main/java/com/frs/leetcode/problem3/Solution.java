package main.java.com.frs.leetcode.problem3;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[][] dp = new int[rows][columns];
        for (int col = columns - 1; col >= 0; col--) {
            for (int row = rows - 1; row >= 0; row--) {
                int bestPath = 1;
                if (row + 1 < rows || col + 1 < columns) {
                    bestPath = Math.min(
                            row + 1 < rows ? dp[row + 1][col] : 10000,
                            col + 1 < columns ? dp[row][col + 1] : 10000);
                }
                dp[row][col] = Math.max(1, bestPath - dungeon[row][col]);
            }
        }

        return dp[0][0];
    }
}