package Heaps;

import java.util.Arrays;

/*
TC: O(nlogn), because, buildHeap func takes O(n),
heapify takes O(logn) each time and heapify func is called K times, there fore heapify takes O(klogn).
Therfore the TC is O(nlogn), since k <= n
 */
public class FindKSmallestElements {
    public static int[] findKSmallest(int[] arr,int k) {

        int[] result = new int[k];
        int size = arr.length;

        for(int i = 0; i < k; i++) {
            buildHeap(arr, size);
            result[i] = arr[0];
            arr[0] = arr[--size];
        }
        return result;
    }

    public static void buildHeap(int[] arr, int size) {
        for(int i = (size-1)/2; i >= 0; i--) {
            minHeapify(arr, i, size);
        }
    }

    public static void minHeapify(int[] arr, int index, int size) {
        int minimum = index;
        while(index < size/2) {
            int left = (2*index)+1;
            int right = (2*index)+2;
            if(left < size && arr[left] < arr[index]) {
                minimum = left;
            }
            if(right < size && arr[right] < arr[minimum]) {
                minimum = right;
            }
            if(index != minimum) {
                int temp = arr[index];
                arr[index] = arr[minimum];
                arr[minimum] = temp;
                index= minimum;
            } else break;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findKSmallest(new int[]{9,4,7,1,-2,6,5}, 6)));
    }
}
