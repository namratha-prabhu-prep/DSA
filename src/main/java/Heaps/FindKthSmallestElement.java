package Heaps;

import java.util.PriorityQueue;

/*
Approach 1: Using min heap
This implementation can be referred at https://github.com/namratha-prabhu-prep/DSA/blob/master/src/main/java/Heaps/FindKSmallestElements.java
This approach basically calls the minHeapify function K times to get the Kth smallest element

TC: O(N + KlogN), because
1. To loop through the elements of the array and to build the min heap we need O(N) time for N elements
2. We call the minHeapify method K times because we want the Kth smallest element. Each heapify call takes O(logN),
and calling it K times takes O(KlogN)
3. In total it takes, O(N + KlogN)

SC: O(N), to store N elements in the min heap

Approach 2: Using max heap ************** This approach is implemented below
This implementation is using maxHeap, where we put the starting k elements into a max heap and compare the elements starting
from kth position onwards with the root of the max heap. If the root is greater than the number form the array,
then we remove the root and add the number from the array to the maxHeap. This is because we have to get the min elements.

TC: O(K + (N-K)logK), this is because
1. we need O(K) time to loop through K elements to build the max heap
2. we need O(logK) time to heapify the maxHeap each time. So in worst case, if rest of the elements in the array after
first k elements, i.e N-K elements are in descending order, then we might have to heapify the max heap after each comparison with the root.
In that case for N-K elements heapifying takes ((N-K)logK)
3. So in total it is O(K + (N-K)logK)

SC: O(K) for storing K elements in the heap

Approach 3:
 */
public class FindKthSmallestElement {
    public static int findKthSmallestNumber(int[] nums, int k) {
        // (n1, n2) -> n2 - n1, To sort the elements in the PriorityQueue in Descending order (maxHeap)
        // By default it is ascending order or do this (n1, n2) -> n1 - n2
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(pq.peek() > nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        int result = FindKthSmallestElement.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = FindKthSmallestElement.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = FindKthSmallestElement.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
