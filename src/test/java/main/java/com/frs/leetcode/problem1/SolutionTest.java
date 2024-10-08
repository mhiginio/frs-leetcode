package main.java.com.frs.leetcode.problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {
    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("testData")
    void test(String s, int result) {
        assertEquals(result, solution.lengthOfLongestSubstring(s));
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbbbbbb", 1),
            Arguments.of("pwwkew", 3),
            Arguments.of("abcde", 5),
            Arguments.of("abcabcde", 5),
            Arguments.of("a".repeat(50000), 1),
            Arguments.of("abcdefghijklmnopqrst".repeat(5000), 20)
        );
    }

}