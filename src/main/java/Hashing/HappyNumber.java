package Hashing;

import java.util.HashSet;
import java.util.Set;

/*
202. Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class HappyNumber {
    /*
    Use hsh set to detect cycles. I.e sometimes some number after summing up gives a number we have already seen
    So in that case we know that it will not reach 1 and hence not a happy number.
    We dont have to worry about numbers not reaching 1 and which doesnt have cycles because,

    1. For a number with 3 digits, it is impossible to go larger than 243. This means it have to either get
    stuck in a cycle below 243 or go down to 1.
    2. Number with 4 or more digits will always lose a digit at each step until they are down to 3 digits,
    because for 9999 (largest 4 digit number), the
    nxt number is 324 (reduced 4 digits to 3) and for 9999 next is 324.

    So we know that at worst, the algo might cycle around all the numbers under 243 and then go back to one
    its already been to a cycle or go to 1. But it wont go indefinitely. So we can rule out this option.

    Hashset takes O(1) time to check if it has that number, where as other ds like arrays and lists take O(n).
    TC: O(logn) SC: O(logn)
    logn because number of digits in a number n is logn
    Refer this for TC: https://leetcode.com/problems/happy-number/solution/
    */
    // Approach 1: Using hash Set
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1) {
            n = getNextNum(n);
            if(set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
        }
        return true;
    }

    /*
    Approach 2: Using floyd's cycle finding algorithm (slow and fast runner technique)

    The chain we get by repeatedly calling getNext(n) is an implicit LinkedList. Implicit means
    we don't have actual LinkedNode's and pointers, but the data does still form a LinkedList structure.
    The starting number is the head "node" of the list, and all the other numbers in the chain are nodes.
    The next pointer is obtained with our getNext(n) function above.

    TC: O(logn)
    1. If there is no cycle, then the fast runner will get to 1, and the slow runner will get halfway to 1.
    Because there were 2 runners instead of 1, we know that at worst, the cost was O(2 * log n) = O(logn).

    2. Once both pointers are in the cycle (which will take constant time to happen) the fast runner will get
    one step closer to the slow runner at each cycle. Once the fast runner is one step behind the slow runner,
    they'll meet on the next step. Imagine there are kk numbers in the cycle.
    If they started at k - 1 places apart (which is the furthest apart they can start),
    then it will take k - 1 steps for the fast runner to reach the slow runner,
    which again is constant for our purposes. Therefore, the dominating operation is still calculating the next
    value for the starting n, which is O(logn)

    SC: O(1)
    */
    public boolean isHappyUsingRunnerTechnique(int n) {
        int slow = n;
        int fast = getNextNum(n);
        while(fast != 1 && slow != fast) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));
        }
        return fast == 1;
    }

    public int getNextNum(int n) {
        int sum = 0;
        while(n > 0) {
            int d = n % 10;
            n = n/10;
            sum += d*d;
        }
        return sum;
    }


}
