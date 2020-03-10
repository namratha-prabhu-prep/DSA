package Sorting;

import java.util.Arrays;
import java.util.Queue;

public class QuickSort {
     // find a pivot point and sort the array such that elements to the left of the pivot point are smaller than the pivot and
    // elements to the right are larger than the pivot point.
    public void quickSort(int[] array, int start, int end) {
        if(start < end) {
            int pivotIndex = partition(array, start,end);
            quickSort(array, start, pivotIndex-1);
            // using pivotIndex+1 because pivotIndex has pivot element and we shouldn't move it
            quickSort(array, pivotIndex+1, end);
        }
    }

    public int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for(int i = start; i < end; i++) {
            if(array[i] <= pivot) {
                array = swap(array, i, pIndex);
                pIndex++;
            }
        }
        // swap the element at pIndex with the pivot (last element)
        swap(array, pIndex, end);
        return pIndex;
    }

    public int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[]{7,2,1,6,8,5,3,4};
        quickSort.quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
