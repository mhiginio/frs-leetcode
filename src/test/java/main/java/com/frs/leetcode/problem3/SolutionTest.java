package main.java.com.frs.leetcode.problem3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0} should return {1}")
    @MethodSource("testSolution")
    void test(int[][] dungeon, int expected) {
        assertEquals(expected, solution.calculateMinimumHP(dungeon));
    }


    private static Stream<Arguments> testSolution() {
        return Stream.of(
                Arguments.of(buildMap("""
                        -2, -3, 3
                        -5,-10, 1
                        10, 30,-5"""), 7),
                Arguments.of(buildMap("0"), 1));
    }

    private static int[][] buildMap(String s) {
        String[] split = s.split("\n");
        int columns = split[0].split(",").length;
        int[][] map = new int[split.length][columns];
        for (int row = 0; row < split.length; row++) {
            String[] values = split[row].split(",");
            if (values.length != columns) {
                throw new IllegalArgumentException("Incorrect map. All rows should have the same sizes");
            }
            map[row] = Arrays.stream(values)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt).toArray();
        }
        return map;
    }

}