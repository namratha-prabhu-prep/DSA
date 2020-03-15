package Heaps;

import java.util.Arrays;

public class MaxHeap {
    // Given a heap as an array convert it to a max heap
    public void buildMaxHeap(int[] arr, int size) {
        // we start the value of i = size-1/2 because to heapify we start from last element in the array
        for(int i =  (size-1)/2; i >= 0; i--) {
            maxHeapify(arr, i, size);
        }
    }

    public void maxHeapify(int[] heapArr, int index, int size) {
        // because after largest > size/2, it would be the leaf nodes,
        // because the last parent would be located at size/2
        int largest = index;
        while(largest < size/2) {
            int left = (2*index + 1);
            int right = (2*index + 2);
            // checking if the parent is smaller than left child.
            // If true assign the largest index as the left index
            if(left < size && heapArr[largest] < heapArr[left]) {
                largest = left;
            }
            // checking if the parent is smaller than right child.
            // If true assign the largest index as the right index.
            // At this point you would have checked if parent > left and parent > right
            // and left >= or <= right
            if(right < size && heapArr[largest] < heapArr[right]) {
                largest = right;
            }
            // if the largest is not the actual parent index you started, then swap with the parent index and
            // the largest child index
            if(largest != index) {
                int temp = heapArr[index];
                heapArr[index] = heapArr[largest];
                heapArr[largest] = temp;
                // So that we know th
                index = largest;
            }
            // if heap property is satisfied
            else break;
        }
    }
    public int extractMax(int[] heapArray){
        int popped = heapArray[0];
        heapArray[0] = heapArray[heapArray.length-1];
        heapArray[heapArray.length-1] = 0;
        buildMaxHeap(heapArray, heapArray.length);
        return popped;
    }
    // Tc for maxHeapify is O(logn)
    // TC for buildMaxHeap is
    // 1. for very loose upper bound it is O(nlogn) because,
    // heapify func is called n times and heapify func takes O(logn) time
    // 2. for more accurate tight upper bound the build heap func takes O(n) time.

    public static void main(String[] args) {
        int[] heapArray = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println("Before max heapifying "
                + Arrays.toString(heapArray));
        new MaxHeap().buildMaxHeap(heapArray, heapArray.length);
        System.out.println("After max heapifying "
                + Arrays.toString(heapArray));
        System.out.println("Extract max = " + new MaxHeap().extractMax(heapArray));
        System.out.println("After extract max "
                + Arrays.toString(heapArray));
    }

}
