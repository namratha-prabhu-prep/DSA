package StacksAndQueues.queues;

import java.util.Arrays;

public class SimpleCircularArrayQueue {
    int[] queue;
    int front;
    int rear;
    int capacity;
    int size;
    public SimpleCircularArrayQueue(int capacity){
        queue = new int[capacity];
        // Or set rear = capacity - 1;
        this.front = this.size = this.rear = 0;
        this.capacity = capacity;
    }

    // IsFull
    public boolean isFull(){
        if(size == capacity){
            return true;
        }
        return false;
    }

    // IsEmpty
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    // EnQueue
    public void enQueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
        }
        size++;
        queue[rear] = data;
        rear = (rear + 1) % capacity;
    }

    // Delete an element from the Queue
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        int data = queue[(front % capacity)];
        queue[front] = Integer.MIN_VALUE;
        size--;
        return data;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        SimpleCircularArrayQueue saQueue = new SimpleCircularArrayQueue(5);
        saQueue.enQueue(1);
        saQueue.enQueue(3);
        saQueue.enQueue(5);
        saQueue.enQueue(7);
        saQueue.enQueue(9);
        saQueue.deQueue();
        System.out.println(Arrays.toString(saQueue.queue));;
    }
}
