package Heaps;

import java.util.Arrays;

public class MinHeap {
    int[] heap;
    int size;
    int maxSize;

    public MinHeap(int capacity) {
        this.size = 0;
        this.maxSize = capacity;
        this.heap = new int[maxSize+1];
        this.heap[0] = Integer.MIN_VALUE;
    }

    public int parent(int pos) {
        return pos/2;
    }

    public int leftChild(int pos) {
        return 2*pos;
    }

    public int rightChild(int pos) {
        return 2*pos + 1;
    }

    public void swap(int pos, int parentPos1) {
        int temp = heap[pos];
        heap[pos] = heap[parentPos1];
        heap[parentPos1] = temp;
    }

    public void insert(int element) {
        if(size >= maxSize) {
            System.out.println("Heap is full");
        } else {
            heap[++size] = element;
            int current = size;
            while (heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }
    }

    public boolean isLeaf(int pos) {
        if(pos >= size/2 && pos <= size){
            return true;
        } else return false;
    }

    public void minHeapify(int pos) {
        if(!isLeaf(pos)){
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
                if(heap[leftChild(pos)] < heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public int extractMin() {
        int popped = heap[1];
        heap[1] = heap[size];
        heap[size--] = 0;
        minHeapify(1);
        return popped;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(4);

        System.out.println(Arrays.toString(minHeap.heap));
        minHeap.extractMin();
        System.out.println(Arrays.toString(minHeap.heap));
    }
}
