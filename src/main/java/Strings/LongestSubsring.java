package Strings;

import java.util.HashMap;
import java.util.Map;

/*
problem: Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubsring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0, i = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                // we do this because i value would be after the first inserted duplicate charcter
                // and we don't have to repeat the the comparison again
                // Eg: s = "namratha", at i = 0 and j = 4 (i.e 'a'), the map already has an 'a'
                // at index 1 but the value stored with the key 'a' is 2, because while adding
                // characters to the map we increment the value of j.
                // so, i would be equal to 2, so it starts from i = 2 ('m') and j = 4
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // we do j-i+1 because, we added a character to the map here, but the
            // value of j will be incremented after this loop execution. So account for the
            // newly added character we add 1.
            maxLen = Math.max(maxLen, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return maxLen;
    }
}
