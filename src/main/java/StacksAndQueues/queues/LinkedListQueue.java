package StacksAndQueues.queues;

public class LinkedListQueue {
    int length;
    Node front, rear;

    public LinkedListQueue(){
        this.length = 0;
        front = rear = null;
    }
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // isEmpty
    public boolean isEmpty(){
        if(front == null){
            return true;
        }
        return false;
    }

    // enQueue
    public void enQueue(int data){
        Node newNode = new Node(data);
        // If the queue is empty, then both rear and front are equal to newNode
        if(isEmpty()){
            front = rear = newNode;
        }
        // Point rear.next to newNode and set rear equal to newNode
        else {
            rear.next = newNode;
            rear = newNode;
        }
        length++;
    }

    // deQueue
    public void deQueue() throws IllegalStateException {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty: Underflow");
        }
        // Delete the node that front is pointing to and set front to front.next
        Node temp = front;
        front = front.next;
        temp.next = null;
        length--;
        if(isEmpty()){
            rear = null;
        }
    }

    // Print the queue
    @Override
    public String toString(){
        String result = "[";
        Node current = front;
        while(current != null){
            result += current.data;
            if(current.next != null){
                result += " -> ";
            }
            current = current.next;
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        LinkedListQueue LLQueue = new LinkedListQueue();
        LLQueue.enQueue(1);
        LLQueue.enQueue(3);
        LLQueue.enQueue(5);
        LLQueue.enQueue(7);
        LLQueue.enQueue(9);
        LLQueue.deQueue();
        System.out.println(LLQueue.toString());
    }
}
