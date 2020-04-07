package Strings;

import java.util.*;

/*
49. Group Anagrams
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // This approach uses the hashable count of each string, where
        // aabbbccc would be represented as #2#3#3#0...#0
        // TC: O(n * k), n is the number of strings in the array, k is the max length of the string
        // SC: O(n * k), because we have n number of strings and with each string has max k chars
        Map<String, List<String>> map = new HashMap();
        int[] count = new int[26];

        for(String s : strs) {
            StringBuilder sb = new StringBuilder("");
            Arrays.fill(count, 0);

            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            for(int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            if(!map.containsKey(sb.toString())) map.put(sb.toString(), new ArrayList());
            map.get(sb.toString()).add(s);
        }

        return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagramsAlternate(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr); // Takes O(klogk), k being the length of string
            String sorted = String.valueOf(chArr);
            if(!map.containsKey(sorted)) map.put(sorted, new ArrayList());
            map.get(sorted).add(s);
        }
        // TC: O(n) * O(klogk)
        return new ArrayList(map.values());
    }
}
