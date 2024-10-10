package main.java.com.frs.leetcode.problem2;

import java.util.LinkedList;
import java.util.Queue;

class IterativeSolution {

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
                Position position = new Position(row, col);
                if (isLand(grid, position)) {
                    result++;
                    fillIsland(grid, position);
                }
            }
        }
        return result;
    }

    private void fillIsland(char[][] grid, Position position) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (isOutOfRange(grid, current) || !isLand(grid, current)) {
                continue;
            }
            grid[current.row()][current.col()] = '-';
            for (Movement direction : DIRECTIONS) {
                queue.add(new Position(current.row() + direction.row(), current.col() + direction.column()));
            }
        }

    }

    private static boolean isLand(char[][] grid, Position position) {
        return grid[position.row()][position.col()] == '1';
    }

    private boolean isOutOfRange(char[][] grid, Position position) {
        return position.row() < 0 || position.col() < 0 || position.row() >= grid.length || position.col() >= grid[0].length;
    }

    public record Movement(int row, int column) {

    }

    public record Position(int row, int col) {

    }
}