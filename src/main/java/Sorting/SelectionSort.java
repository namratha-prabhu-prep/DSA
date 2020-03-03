package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public int[] sort(int[] arr) {
        int min = 0;

        for(int i = 0; i < arr.length-1; i++) {
            /* Eg: arr = {1,4,2,0}, i = 0 < 3
            1) i = 0, min = 0,
            j = 1, 1 > 4
            j = 2, 1 > 2
            j = 3, 1 > 0 {min = j}
            therefore min = 3 [Min value is arr[min] which is 0]
            swap values 0 (index 3) and 1 (index 0)
            swap(arr, 0, 3) => {0,4,2,1}

             */
            min = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(arr, i , min);
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
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.sort(new int[]{1, 4, 2, 0})));
    }
}
