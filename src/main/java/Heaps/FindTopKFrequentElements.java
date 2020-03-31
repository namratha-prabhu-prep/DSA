package Heaps;

import java.util.*;
/*
347. Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class FindTopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberFreqMap = new HashMap<>();

        for(int i : nums) {
            numberFreqMap.put(i, numberFreqMap.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>
                        ((e1, e2) -> numberFreqMap.get(e1) - numberFreqMap.get(e2));

        for(int key : numberFreqMap.keySet()) {
            minHeap.add(key);
            if(minHeap.size() > k) {
                // This is because in this pq smallest elements would be at head and when the size
                // of the heap is > than k, we remove the smallest elements so that we can keep the
                // larger elements in the heap
                minHeap.poll();
            }
        }

        List<Integer> topKFreqList = new ArrayList<>(k);
        while(!minHeap.isEmpty()) {
            topKFreqList.add(minHeap.poll());
            Collections.reverse(topKFreqList);
        }
        return topKFreqList;
    }
    /*
    TC : O(Nlog(k)). The complexity of Counter method is O(N).
    To build a heap and output list takes O(Nlog(k)).
    Hence the overall complexity of the algorithm is (N + Nlog(k)) = O(N+Nlog(k))=O(Nlog(k)).
    SCy : O(N) to store the hash map.
     */
}
