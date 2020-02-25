package StacksAndQueues.stacks;

import java.util.Arrays;

public class SimpleArrayStackImplementation {
    static int MAX = 1000;
    static int top = -1;
    static int stack_arr[] = new int[MAX];

    // Push elements into the stack
    public static boolean push(int data){
        isFull();
        stack_arr[++top] =  data;
        return true;
    }

    // Pop elements from the stack
    public static int pop(){
        isEmpty();
        int x = stack_arr[top];
        stack_arr[top] = 0;
        --top;
        return x;
    }

    // Peek or get the value at top index
    public static int peek(){
        isEmpty();
        isFull();
        int x = stack_arr[top];
        return x;
    }

    // IsEmpty
    public static boolean isEmpty(){
        if(top < 0){
            System.out.println("Stack Underflow");
            return true;
        }
        return false;
    }

    // IsFull
    public static boolean isFull(){
        if(top >= (MAX - 1)){
            System.out.println("Stack Overflow");
            return true;
        }
        return false;
    }

    // Print the stack
    public static void printStack(int[] arr){
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        push(1);
        push(3);
        push(5);
        push(7);
        System.out.println("Pop: " + pop());
        System.out.println("Peek: " + peek());
         System.out.println(Arrays.toString(stack_arr));
        System.out.println("top: " + top);
    }
}
