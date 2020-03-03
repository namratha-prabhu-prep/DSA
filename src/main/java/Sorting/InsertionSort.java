package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public int[] sort(int[] arr) {
        int i, j, temp;
        for(i = 1; i < arr.length; i++) {
            j = i - 1;
            temp = arr[i];
            while(j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        /* TC: In worst case, where arr[i] in each case is smaller than arr[j]
         * for loop runs n times
         * while loop runs n-1 times
         * So, T(n) = O(n*n-1);
         */

        return arr;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.sort(new int[]{8,6,4})));
    }
}
