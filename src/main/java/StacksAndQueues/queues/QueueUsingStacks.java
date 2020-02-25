package StacksAndQueues.queues;

import java.util.Queue;
import java.util.Stack;

public class QueueUsingStacks {

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Stack<Node> s1 = new Stack();
    Stack<Node> s2 = new Stack();

    public void push(int data){
        Node newNode = new Node(data);
        s1.push(newNode);
    }

    public Stack<Node> getS2(){
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
                System.out.println("getS2: " + s2.peek().data);
            }
        }
        return s2;
    }

    public int pop(){
        getS2();
        int data = Integer.MIN_VALUE;
        if(!s2.empty()){
            data = s2.pop().data;
        }
        return data;
    }

    public int peek(){
        getS2();
        int data = s2.peek().data;
        return data;
    }

    public boolean empty(){
        getS2();
        if(s2.size() == 0){
            return true;
        }
        return false;
    }

    public void printQueue(){
        Stack<Node> s = getS2();
        while(s != null){
            if(!s.empty()){
                System.out.println(s.pop().data);
            }
        }
    }
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.printQueue();
//        System.out.println("Peek " + queue.peek());
//        queue.push(3);
//        System.out.println("Peek " + queue.peek());
//        System.out.println("Pop " + queue.pop());
//        System.out.println(queue.empty());
//        System.out.println("Pop " + queue.pop());
//        System.out.println(queue.empty());
//        queue.printQueue();
    }

}
