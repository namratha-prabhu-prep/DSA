### Notes

####Stacks

- LIFO, all operations at one end called **top** (initially set top = -1)

- underflow, overflow - exceptions

- **Implementations**

  1. Simple Array based implementation
  2. Dynamic array based implementation
  3. Linked list implementation

- **Simple Array based implementation**

  - **TC** for all operations is **O(1)**
  - **TC** for push operation is **O(1)** if the array size is in bounds. 
  - **SC** is **O(n)**
  - Limitation is that max size of the stack must be defined and cannot be changed.

- **Dynamic array based implementation**

  - This implementation is overcome the limitation of simple array based impl.

  - If the array size is out of bounds, create a new array double the array size.

  - for n = 2 create array size = 4

    for n = 16 create array of size 32.

    this is basically **equal to 2n**. 

  - Therefore, **for n push operations** we are **doubling the array** **logn** **times**.

  - **TC** for n push operations is **O(n)** 

    because, T(n) = 1+2+4+8+ --- +n

    T(n) = O(n)

  - **TC** for all other operations is **O(1)**

  - **SC** is **O(n)**

  - **Limitation** is that too many doublings can cause memory overflow exception

- **Linked list implementation**

  - Push operatation is done by inserting element at the head (top).
  - Pop operation by removing element from head (top).
  - **TC** for all operations **O(1)**
  - **TC** for delete stack is **O(n)**
  - **SC** for n push operations is **O(n)**

- The **amortized time** of a push operation is the average time taken by a push over the series of operations i.e **T(n)/n**

  - For **Incremental**: O(n^2)/n = **O(n)**
  - For **Doubling**: O(n)/n = **O(1)**

---

####Queues

- FIFO
- Two pointers used:
  -  **front**: start element, deletions at front
  - **rear**: last element, Insertions at rear
- Enqueue (add), Dequeue (remove)
- Overflow, Underflow
- Operations: enqueue, dequeue, peek, isEmpty, size
- **Implementations**
  1. Simple Circular Array based implementation
  2. Dynamic Circular Array based implementation
  3. Linked list implementation 
- **Simple Circular Array based implementation**
  - Insertions are performed at the end and deletions at the front
  - So, the initial slots of the array would be empty and gets wasted. This is not efficient. 
  - **So use a circular array** where the last element and the first array elements are contiguous.
  - With this circular array, if there are any free slots at the beginning, the rear pointer can go to the next free slot. 
  - **TC** for all operations is O(1)
  - **SC** for n add operations is O(n)
  - **Limitation** is that size is fixed
- **Dynamic Circular Array based implementation**
  - **TC** is **O(1)**
  - **SC** is **O(n)**
- **Linked list implementation**
  - **TC** is **O(1)**
  - **SC** is **O(n)**

----

####Priority Queues

* Used to find max/min elements 

* processing is done based on priority instead of FIFO. Eg: Job scheduling, which is prioritized instead of serving in FIFO

* **Types**

  * **Ascending PQ**: If the item with smallest key has the highest priority (delete smallest element always)
  * **Descending PQ**If the item with largest key has the highest priority (delete max element always): 

* **Operations**

  * **Insert(key, data)**: Inserts data with key to PQ. Elements are ordered based on key
  * **Delete Min **/**Delete Max**
  * **GetMin**/**GetMax**

* **Auxiliary operations**

  * **Kth smallest/Kth largest**: returns Kth smallest/Kth largest key in PQ
  * **Size**
  * **Heap sort**: sorts the lemets in the PQ based on priority (key)

* **Implementations**

  | Implementation                                               | Insertion               | Deletion |
  | ------------------------------------------------------------ | ----------------------- | -------- |
  | Unordered Array Impl                                         | O(1)                    | O(n)     |
  | Unordered list Impl                                          | O(1)                    | O(n)     |
  | ordered Array Impl                                           | O(n) because of sorting | O(1)     |
  | ordered list Impl                                            | O(n) because of sorting | O(1)     |
  | Binary Search Trees Impl                                     | O(logn)                 | O(logn)  |
  | Balances BST impl                                            | O(logn)                 | O(logn)  |
  | Binary Heap impl<br /> (Search takes O(logn), <br />finding max/min takes O(1)) | O(logn)                 | O(logn)  |

----

####Heaps

* It is a tree with some special properties

* Basic requirements 

  1. Value of a node must be `>=` or `<=` the values of its children.

     This is also called as **heap property**

  2. All leaves should be at h or h-1 (complete binary tree)

  3. Heap should form a complete Btree

  A Heap uses *Complete Binary Trees* to avoid holes in the array. See the figure below to see the difference between that and an Incomplete Binary Tree:

  ```
  Complete BTree    
      11
     /   \
    5     2
   / \   / 
  6  17 14 
  
  Incomplete BTree
      11
     /   \
    5     2
     \   / 
     17 14 
  ```



  Below mentioned heap is an invalid heap, because 

  (11 > 5,2) (5 < 6,17) (2 < 14,13) All parent nodes must have the same property (> or <)

  ```
      11
     /   \
    5     2
   / \   / \
  6  17 14 13
  ```

* Elements of a Heap are not sorted. Largest ior smallest element is always placed at the top depending on what kind of heap we are using.

* Types of Heaps

  1. **Min heap**: value of a node should be <= to values of its children

  2. **Max heap**: value of a node should be >= to values of its children

  3. **Binary heap**: 

     * Each node can have up to 2 children

     * It is implemented using arrays (unlike BTs where BTs are implemented using stack)

     * Heaps are complete binary trees, so there wont be any wastage of memory locations

     * Can perform `insert()`, `delete()`, `extractmax()`, and `decreaseKey()` operations in O(logn) time

     * Variations of Binary heaps: 

       1. Binomial heap
       2. Fibonacci heap

       These variations can perform `union()` in O(logn) time where as Binary heap takes O(n)

* **Why heaps are implemented using arrays and not trees? [like BTree using stacks]**

  1. Lower memory usage(no need to store 3 pointer)
  2. Easier memory management i.e just one object is allocated instead of n
  3. Better locality of reference (Items in heap are relatively closer together in memory)
  4. Using arrarys is a good choice if we know that data is constant
  5. If the heap size grows deeper, then this array has to be copied to a larger array and this is time expensive.

* **Finding the parent of a node**

  * For a node at `ith` location, its parent is at `(i-1)/2` location

    i.e Node at i = parent at ((i-1)/2) location.

    ```
        17
       /   \
     13     6
     / \   / \
    1   4 2   5
    ```

    In the above example, if we consider node 6, it is at i=2, therefore its parent would be at (2-1)/2 = 1/2 = 0 i.e 0th location, which is node 17.

    **important**: All of the parent nodes are present in the first half of the array with the last parent at n/2th position(in this case at 2nd index) 

    **Above heap placement in array**

    | 0    | 1    | 2    | 3    | 4    | 5    | 6    |
    | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
    | 17   | 13   | 6    | 1    | 4    | 2    | 5    |

* **Finding children of a node**

  * For a parent node at `ith` location,
    * **Left child** will be at **(2i+1)** location
    * **Right child** will be at **(2i+2)** location

* Main operations on a heap

  1. **getMin()/getMax()**
  2. **extractMin()/extractMax()**
  3. **insert()/delete()**

* **Max element** in max heap is always at root, i.e at arry[0]

* **Heapifying an element**

  The process of adjusting the  location of the inserted element in to heap and make it a heap again is called **heapifying**

  * In a max heap, to heapify an element,
    * find the maximum of its children and swap it with current element
    * continue until heap property is satisfied at every node in the heap
    * In heapifying process, 
      1. **Percolate down**: The process of moving from top to bottom 
      2. **Percolate up**: The process of moving from bottom to up
  * **TC** of heapifying is **O(logn)**
  * **SC** is **O(1)**
  * If we are dealing with a n number of input elements to be inserted and heapified, it takes **O(nlogn)** time in total, because each insert takes **O(logn)** time and n elements take **O(nlogn)**
  * *In a complete BTree of n nodes, there are n/2 leaf nodes and the leaf nodes always satisfies the heap property and no need to heapify them.*
  * *We just have to heapify the remaining n/2 non leaf nodes.* 

* **Deleting an element from a heap**

  * In a standard heap, deleting a max element is only allowed
  * So, deleting an element from a heap is just deleting the first element (root) from the heap
  * copy the root in to some variable
  * Then, copy the last element in to the root
  * Then **percolate down**
  * **TC** is **O(logn)**
  * **SC** is **O(1)**

* **Inserting an element in to a heap**

  * Increase the heap size
  * Keep new element at the end of the heap
  * Then **perolate up**
  * **TC** is **O(logn)**

  **MaxHeap Implementation**

  Refer <https://github.com/namratha-prabhu/DSA/blob/master/src/main/java/Heaps/MaxHeap.java>

  **MinHeap Implementation**

  Refer <https://github.com/namratha-prabhu/DSA/blob/master/src/main/java/Heaps/MinHeap.java>

* Deleting an element uses percolate down and inserting uses percolate up.

* **Where are heaps used?**

  1. **Order statistics**: For efficiently finding the smallest or largest element in an array.

  2. **Priority Queues**: PQ's can be efficiently implemented using Binary heap because it supports insert, delete, extractMax, decreaseKey operations in O(logn) time.

     We can use Binomoial Heaps and Fibonacci Heaps to perform union() in O(logn) time, where as Binary heap takes O(n) time.

  3. Heap implemented PQ's are used in Graph algos like **Prim's algo and Dijkstra's algo**. 

  4. **Sorting**: **HeapSort** is especially useful for sorting `arrays` because Heaps, unlike almost all other types of trees - are usually implemented in arrays, not as linked data structures!