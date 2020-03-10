### Short Notes

----

###### <u>Stacks</u>

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

----

######<u>Queues</u>

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

######<u>Priority Queues</u>

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

###### <u>Heaps</u>

