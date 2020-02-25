package StacksAndQueues.queues;

import java.util.Arrays;

public class DynamicCircularArrayQueue {
    int front, rear, size;
    int[] queue;
    int capacity = 16;

    // Create a queue with a default size
    public DynamicCircularArrayQueue(){
        queue = new int[capacity];
        this.front = this.rear = this.size = 0;
    }

    // Take capacity as input
    public DynamicCircularArrayQueue(int CAPACITY){
        this.capacity = CAPACITY;
        this.queue = new int[capacity];
        this.front = this.rear = this.size = 0;
    }

    // Check if the queue is empty
    public boolean  isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    // Check if the queue is full
    public boolean isFull(){
        if(size == capacity){
            return true;
        }
        return false;
    }

    // Insert an element to the queue
    public void enQueue(int data){
        if(isFull()){
            expand();
        }
        queue[rear] = data;
        rear = (rear+1) % capacity;
        size++;
    }

    // deQueue
    public void deQueue() throws IllegalStateException{
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty: Underflow");
        }
        queue[front] = Integer.MIN_VALUE;
        front = (front+1) % capacity;
        size--;
    }

    // Expand the array in case it becomes full
    public void expand(){
        int[] newQueue = new int[size * 2];
        // copy items from old queue to new
        for(int i = front; i <= rear; i++){
            newQueue[i - front] = queue[i % capacity];
        }
        queue = newQueue;
        capacity *= 2;
        front = 0;
        rear = size - 1;
    }

    // Shrink the queue if the size of the queue is more than 3/4th empty
//    public void shrink(){
//        int[] newQueue = new int[capacity/2];
//        for(int i = front; i <= rear; i++){
//            newQueue[i] = queue[(front % capacity)];
//        }
//        queue = newQueue;
//        capacity /= 2;
//        front = 0;
//        rear = size - 1;
//    }

    // Print the queue
    @Override
    public String toString(){
        String result = "[";
        for(int i = 0; i < size; i++){
            result += Integer.toString(queue[(front + i) % capacity]);
            if(i < size - 1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        DynamicCircularArrayQueue dynamicQueue = new DynamicCircularArrayQueue();
        dynamicQueue.enQueue(1);
        dynamicQueue.enQueue(3);
        dynamicQueue.enQueue(5);
        dynamicQueue.enQueue(7);
        dynamicQueue.enQueue(9);
        System.out.println(dynamicQueue.toString());
        System.out.println(dynamicQueue.capacity);
    }
}
