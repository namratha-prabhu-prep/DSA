package Heaps;

import java.util.Arrays;

public class MaxHeap {
    int[] heap;
    int size;
    int maxSize;

    public MaxHeap(int capacity){
        this.size = 0;
        this.maxSize = capacity;
        this.heap = new int[maxSize+1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    public int parent(int pos){
        return pos/2;
    }

    public int leftChild(int pos){
        return 2*pos;
    }

    public int rightChild(int pos){
        return 2*pos+1;
    }

    public boolean isLeaf(int pos) {
        if(pos >= size/2 && pos <= size) {
            return true;
        } else return false;
    }

    public void swap(int parPos, int pos){
        int temp = heap[pos];
        heap[pos] = heap[parPos];
        heap[parPos] = temp;
    }

    public void insert(int element) {
        if(size >= maxSize){
            System.out.println("Heap is full");
        } else {
            heap[++size] = element;
            int current = size;
            while(heap[parent(current)] < heap[current]){
                swap(parent(current), current);
                current = parent(current);
            }
        }
    }

    public void maxHeapify(int pos) {
        if(!isLeaf(pos)){
            if(heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
                if(heap[leftChild(pos)] > heap[rightChild(pos)]) {
                    swap(leftChild(pos), pos);
                    maxHeapify(leftChild(pos));
                } else {
                    swap(rightChild(pos), pos);
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public int extractMax(){
        int popped = heap[1];
        heap[1] = heap[size];
        heap[size--] = 0;
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(25);
        maxHeap.insert(50);
        System.out.println(Arrays.toString(maxHeap.heap));
        maxHeap.extractMax();
        System.out.println(Arrays.toString(maxHeap.heap));
    }

}
