package StacksAndQueues.stacks;

class MyQueue {
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    Node tail;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.head = null;
        this.tail = null;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Node newNode = new Node(x);
        if(empty()){
            newNode.next = head;
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()){
            return -1;
        }
        Node current = head;
        Node prev = null;
        if(current.next == null){
            head = tail = null;
            return current.data;
        }
        while(current.next != null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        tail = prev;
        return current.data;
    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            return -1;
        }
        return tail.data;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(head == null && tail == null) return true;
        return false;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        //queue.push(2);
        System.out.println("Peek: " + queue.peek());
        System.out.println("Pop: " + queue.pop());
        System.out.println("isEmpty: " + queue.empty());
    }
}
