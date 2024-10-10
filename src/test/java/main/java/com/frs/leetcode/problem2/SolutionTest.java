package main.java.com.frs.leetcode.problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

//    private final Solution solution = new Solution();
    private final IterativeSolution solution = new IterativeSolution();

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("testSolution")
    void test(char[][] grid, int expected) {
        assertEquals(expected, solution.numIslands(grid));
    }


    private static Stream<Arguments> testSolution() {
        return Stream.of(
            Arguments.of(buildMap("""
                11110
                11010
                11000
                00000"""), 1),
            Arguments.of(buildMap("""
                11000
                11000
                00100
                00011"""), 3));
    }


    private static char[][] buildMap(String s) {
        String[] split = s.split("\n");
        int columns = split[0].length();
        char[][] map = new char[split.length][columns];
        for (int row = 0; row < split.length; row++) {
            if (split[row].length() != columns) {
                throw new IllegalArgumentException("Incorrect map. All rows should have the same sizes");
            }
            map[row] = split[row].toCharArray();
        }
        return map;
    }
}