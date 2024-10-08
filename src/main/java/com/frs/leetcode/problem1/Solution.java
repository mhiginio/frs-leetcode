package main.java.com.frs.leetcode.problem1;

import java.util.Arrays;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int['z' - 'a' + 1];
        Arrays.fill(lastSeen, -1);
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            int lastSeenIdx = s.charAt(right) - 'a';
            if (lastSeen[lastSeenIdx] >= left) {
                maxLength = Math.max(maxLength, right - left);
                left = lastSeen[lastSeenIdx] + 1;
            }
            lastSeen[lastSeenIdx] = right;
        }
        return Math.max(maxLength, s.length() - left);
    }
}
