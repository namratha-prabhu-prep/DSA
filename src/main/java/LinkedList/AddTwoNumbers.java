package LinkedList;

/*
Problem: Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), p = l1, q = l2;
        ListNode curr = dummyHead;
        int carry = 0;

        // Since the numbers are stored in the reverse order,
        // we can start adding from the least significant digit (it is just normal math)
        // and carry forward the carry value.
        // Follow up: what if the digits are in non reverse order? We cannot add from
        // most significant digit towards least significant digit
        // See AddTwoNumsNonReversedOrder.java for solution
        while(p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            int current = sum % 10;
            curr.next = new ListNode(current);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    /*
    TC : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively,
    the algorithm above iterates at most \max(m, n)max(m,n) times.
    SC : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
     */
}
