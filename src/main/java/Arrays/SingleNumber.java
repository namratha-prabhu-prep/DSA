package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
136. Single Number
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:
Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    /*
    Approach 1: Solution using bit manipulation
    If we take XOR of zero and some bit, it will return that bit
    a ⊕ 0 = a
    If we take XOR of two same bits, it will return 0
    a ⊕ a = 0
    a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
    TC: O(n)
    SC: O(1)
    */
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum ^= i;
        }
        return sum;
    }

    /*
    Approach 2: Solution using hash table
    TC: O(n)
    SC: O(n)
     */
    public int singleNumberUsingMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int num = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) num = entry.getKey();
        }
        return num;
    }
}
