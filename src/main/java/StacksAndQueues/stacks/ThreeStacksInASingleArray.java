package StacksAndQueues.stacks;

import java.util.Arrays;

public class ThreeStacksInASingleArray {
    int numberOfStacks;
    int stackCapacity; // Capacity of each stack
    int[] arrayOfStacks;
    int[] sizes;

    public ThreeStacksInASingleArray(int capacity, int numberOfStacks){
        this.stackCapacity = capacity;
        this.numberOfStacks = numberOfStacks;
        arrayOfStacks = new int[stackCapacity * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    // IsFull
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    // IsEmpty
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    // Push
    public void push(int stackNum, int data) throws IllegalStateException{
        if (isFull(stackNum)){
            System.out.println("Stack is full: StackOverFlow exception");
            throw new IllegalStateException();
        }
        sizes[stackNum]++;
        arrayOfStacks[getTopIndex(stackNum)] = data;
    }

    // Pop
    public int pop(int stackNum){
        if (isEmpty(stackNum)){
            System.out.println("Stack is empty: UnderFlow");
            return 0;
        }
        int data = arrayOfStacks[getTopIndex(stackNum)];
        arrayOfStacks[getTopIndex(stackNum)] = 0;
        sizes[stackNum]--;
        return data;
    }

    // Get the index of the top of the stack
    private int getTopIndex(int stackNum){
        int offset = stackNum * stackCapacity;
        System.out.println("offset " + offset);
        int size = sizes[stackNum];
        System.out.println("size " + size);
        return offset + size - 1; // This is the top value
    }

    public static void main(String[] args) {
        ThreeStacksInASingleArray threeStackArray = new ThreeStacksInASingleArray(3, 3);
        threeStackArray.push(0, 1);
        threeStackArray.push(0, 3);
        threeStackArray.push(0, 5);
        // threeStackArray.push(0, 7);
        System.out.println(Arrays.toString(threeStackArray.arrayOfStacks));
    }
}
