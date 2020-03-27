package LinkedList;

import java.util.List;

/*
This is a follow up to AddTwoNumbers problem
Follow up: What if the the digits in the linked list are stored in non-reversed order? For example:

(3 \to 4 \to 2) + (4 \to 6 \to 5) = 8 \to 0 \to 7(3→4→2)+(4→6→5)=8→0→7
 */
public class AddTwoNumsNonReversedOrder {
    // Solution:
    //We need to add numbers from the most right digit to left digit.
    //Compared with last question, we can reverse two lists and add them.
    //And reverse our output is correct answer.

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);

        int carry = 0;

        while(l1 != null && l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum/10;
            int current = sum % 10;
            curr.next = new ListNode(current);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /*
    TC : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively,
    the algorithm above iterates at most \max(m, n)max(m,n) times.
    SC : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
     */
}
