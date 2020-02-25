package StacksAndQueues.stacks;

import java.util.Stack;

// Design a stack which, in addition to push and pop, also has a method min, which gives the minimum element
// and the TC of all three methods should be O(1)
public class GiveMinElementInTheStack1 extends Stack<Integer> {
    // Solution: Use an additional stack to keep track of the min element.
    Stack<Integer> stack2;
    public GiveMinElementInTheStack1() {
        stack2 = new Stack<Integer>();
    }

    public void push(int data){
        if (data <= getMinElement()){
            stack2.push(data);
        }
        super.push(data);
    }

    public Integer pop(){
        int data = super.pop();
        if (data == getMinElement()){
            stack2.pop();
        }
        return data;
    }

    public int getMinElement(){
        if(stack2.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        GiveMinElementInTheStack1 min = new GiveMinElementInTheStack1();
        min.push(1);
        min.pop();
        min.push(3);
        min.push(5);
        min.push(7);
        System.out.println("Min element: " + min.getMinElement());
    }
}
