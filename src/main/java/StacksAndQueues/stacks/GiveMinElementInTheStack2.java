package StacksAndQueues.stacks;

// // Design a stack which, in addition to push and pop, also has a method min, which gives the minimum element
//// and the TC of all three methods should be O(1)
public class GiveMinElementInTheStack2 {
    // Solution: To use a variable min in the Node and save the min element in thar variable for each Node
    class Node {
        int data;
        int min;
        Node next;
        public Node(int data, int min){
            this.data = data;
            this.min = min;
        }
    }

    Node head;

    // Push
    public void push(int data){
        if (head == null){
            head = new Node(data, data);
        } else {
            Node newNode = new Node(data, Math.min(data, head.min));
            newNode.next = head;
            head = newNode;
        }
    }

    // Pop
    public void pop(){
        if(head != null){
            head = head.next;
        }
    }

    // Peek
    public int peek(){
        if(head == null){
            return -1;
        }
        return head.data;
    }

    // getMin
    public int getMin(){
        if (head != null){
            return head.min;
        } else return -1;
    }

    public static void main(String[] args) {
        GiveMinElementInTheStack2 stack = new GiveMinElementInTheStack2();
        stack.push(7);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        System.out.println("Min element: " + stack.getMin());
        stack.pop();
        System.out.println("Min element: " + stack.getMin());
    }
}
