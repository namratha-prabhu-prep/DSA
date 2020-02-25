package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public int[] sort(int[] arr) {
        int i, j, temp;
        for(i = 1; i < arr.length; i++) {
            j = i;
            temp = arr[i];
            while(j >= 1 && arr[j-1] > arr[i]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.sort(new int[]{8,6})));
    }
}
