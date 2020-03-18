package Heaps;

import java.util.Arrays;

public class FindKLargestElements {
    public static int[] findKLargest(int[] arr, int k) {
        int size = arr.length;
        if(k <= size) {
            int[] result = new int[k];
            for(int i = 0; i < k; i++) {
                buildHeap(arr, size);
                result[i] = arr[0];
                arr[0] = arr[--size];
            }
            return result;
        }
        return arr;
    }

    public static void buildHeap(int[] arr, int size) {
        for(int i = (size-1)/2; i >= 0; i--) {
            maxHeapify(arr, i, size);
        }
    }

    public static void maxHeapify(int[] arr, int index, int size) {
        int maxIndex = index;
        while(index < size/2) {
            int left = (2*index)+1;
            int right = (2*index)+2;
            if(left < size && arr[left] > arr[index]) {
                maxIndex = left;
            }
            if(right < size && arr[right] > arr[maxIndex]) {
                maxIndex = right;
            }
            if(index != maxIndex) {
                int temp = arr[index];
                arr[index] = arr[maxIndex];
                arr[maxIndex] = temp;
                index = maxIndex;
            } else break;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findKLargest(new int[]{9,4,7,1,-2,6,5}, 6)));

    }
}
