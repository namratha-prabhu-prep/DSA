package Sorting;

import java.util.Arrays;

// TC: O(nlogn), because
// 1. We can only split the array of size n, logn times. Therefore O(logn)
// 2. We have to iterate through all n elements to merge the arrays. Therefore O(n) from this step.
// Totally it is O(nlogn)

// SC: O(n) because we use two extra arrays each of size n/2, it is O(n/2 + n/2).
public class MergeSort {
    public int[] mergeSort(int[] array){
        int n = array.length;
        // base case
        if(n < 2) return null;
        int mid = n/2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n-mid];

        // Copy elements from array to left and right arrays
        for(int i = 0; i < mid; i++) {
            leftArr[i] = array[i];
        }

        for(int i = mid; i < n; i++){
            rightArr[i - mid] = array[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
        return merge(leftArr, rightArr, array);
    }

    public int[] merge(int[] leftArr, int[] rightArr, int[] array) {
        int nL = leftArr.length;
        int nR = rightArr.length;

        int left = 0, right = 0, main = 0;
        while(left < nL && right < nR) {
            if(leftArr[left] <= rightArr[right]){
                array[main] = leftArr[left];
                left++;
            } else {
                array[main] = rightArr[right];
                right++;
            }
            main++;
        }
        // After the above while loop either left or right would be out of bounds,
        // so copy the rest of the leftArr or rightArr into array. One of the below
        // two while loops will be executed and not both.
        while(left < nL){
            array[main] = leftArr[left];
            left++;
            main++;
        }
        while(right < nR){
            array[main] = rightArr[right];
            right++;
            main++;
        }
        return array;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] sortedArr = mergeSort.mergeSort(new int[]{2,4,1,6,8,5,3,7});
        System.out.println(Arrays.toString(sortedArr));
    }
}
