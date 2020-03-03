## Sorting
------
##### complete notes for bubble, selection, insertion sort

------
##### Comparison between bubble, selection, insertion sort

1. **_Insertion sort_** is used when 
   - the data is nearly sorted(due to its adaptiveness)
   - the input size is small (due to its low overhead)
     For these reasons and due to stability, insertion sort is used as a **_recursive base case 
     for higher overhead divide and conquer sorting algorithms, such as merge sort or quick sort_**
2. **_Bubble sort_** takes n^2/2 comparisons and n^2/2 swaps in both average and worst case.
3. ***Selection sort*** takes n^2/2 comparisons and n swaps.
4. **_Insertion sort_** takes n^2/4 comparisons and n^2/8 swaps in average case and in worst case
   they are double.
5. Insertion sort is almost linear for partially sorted input.
6. Selection sort best suits elements with bigger values and small keys.
----
