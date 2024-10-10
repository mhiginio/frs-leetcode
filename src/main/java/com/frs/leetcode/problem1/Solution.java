package main.java.com.frs.leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (lastSeen.getOrDefault(current, -1) >= left) {
                // Update the max length and move left to the next value of the repeated character
                maxLength = Math.max(maxLength, right - left);
                left = lastSeen.get(current) + 1;
            }
            lastSeen.put(current, right);
        }
        return Math.max(maxLength, s.length() - left);
    }
}
