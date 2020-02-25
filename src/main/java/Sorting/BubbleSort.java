package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] arr) {
        boolean isSorted = false;
        int lastUnSorted = arr.length - 1;

        while(!isSorted) {
            isSorted = true;
            /* This is added here instead of at the end because adding it
            there would make the code to exit the while loop after the for loop finishes.
            Eg: arr = {4,1,2,0}, i = 0 < 3
            1) i = 0, 4 > 1 {swap} => {1,4,2,0}
            2) i = 1, 4 > 2 {swap} => {1,2,4,0}
            3) i = 2, 4 > 0 {swap} => {1,2,0,4}
            This completes the first pass (first loop) and
            then if we add `isSorted = true` after the loop, code would exit out of the while loop,
            even though the array is not sorted
             */
            for(int i = 0; i < lastUnSorted; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr = swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            // This is because of after the first pass, the last element of the array would be the max
            // element of the array. Consider the above example, after the first pass
            // arr = {1,2,0,4}
            // So we just have to sort until index 2, so set lastUnSorted = 2
            lastUnSorted--;
        }
        return arr;
    }

    public int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sort(new int[]{4, 1, 2, 0})));
    }
}
