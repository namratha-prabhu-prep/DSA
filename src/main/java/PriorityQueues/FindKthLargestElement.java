package PriorityQueues;

import java.util.PriorityQueue;

public class FindKthLargestElement {
    PriorityQueue<Integer> pq;
    int k;

    public FindKthLargestElement(int k, int[] arr) {
        pq = new PriorityQueue<>();
        this.k = k;
        int res = 0;

        for (int i : arr) {
            res = add(i);
        }
        System.out.println(res);
    }

    public int add(int num) {
        // Checking if pq.size() < k because we just need k largest elements and we return the kth largest
        if(pq.size() < k) {
            pq.offer(num);
        }
        // In a PQ, the elements are ordered in the natural order, i.e smallest elements are at the
        // head and largest at the rear. So even if the order of adding
        // is 3,1,2 => in the queue it would be 1,2,3
        // So when we peek we are looking at the smallest element in the queue and we remove that element
        // if the num to be added is greater than the peeked element. So at the end of the above for loop,
        // pq would have 3 largest elements in order.
        else if(pq.peek() < num) {
            pq.poll();
            pq.offer(num);
        }
        // we return the element at head because until k-1 position we add all the elements, starting
        // Kth position we start comparing the element at the Kth position with the element at head,
        // if the element at head is smaller than the element at the Kth position we add the element at
        // Kth position to the PQ. At any given time the Kth largest element will be at the head.
        return pq.peek();
    }

    public static void main(String[] args) {
        FindKthLargestElement kthLargestElement = new FindKthLargestElement(2, new int[]{0,1,2,3});
    }
}
