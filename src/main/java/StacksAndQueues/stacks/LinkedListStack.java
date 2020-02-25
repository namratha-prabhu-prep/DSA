package StacksAndQueues.stacks;

import java.util.LinkedList;

public class LinkedListStack {
    Node head;

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Push
    public void push(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
        }
        else {
            new_node.next = head;
            head = new_node;
        }
    }

    // Pop
    public int pop(){
        if(head == null){
            System.out.println("Nothing to pop");
            return 0;
        }
        int popped = Integer.MIN_VALUE;
        popped = head.data;
        head = head.next;
        return popped;
    }

    // Peek
    public int peek(){
        if(head == null){
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        } else {
            return head.data;
        }
    }

    // IsEmpty
    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        return true;
    }

    // Print the stack
    public void printStack(Node head){
        Node current = head;
        System.out.println("Linked List Stack Implementation");
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args){
        LinkedListStack LLStack = new LinkedListStack();
        LLStack.isEmpty();
        LLStack.push(1);
        LLStack.push(3);
        LLStack.push(5);
        LLStack.push(7);
        LLStack.printStack(LLStack.head);
        LLStack.pop();
        LLStack.printStack(LLStack.head);
        System.out.println(Integer.MIN_VALUE);
    }
}
