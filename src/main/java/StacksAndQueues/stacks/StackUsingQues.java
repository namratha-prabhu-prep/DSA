package StacksAndQueues.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int theTop = top;
        while(q1.size() > 0){
            top = q1.remove();
            q2.add(top);
        }
        q2.remove();
        Queue<Integer> temp = q2;
        //Queue<Integer> temp = q1;
        q2 = q1;
        q1 = temp;

        // q2 = temp;
        return theTop;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQues st = new StackUsingQues();
        st.push(1);
        st.push(2);
        System.out.println(st.top());
        // System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.q2.peek());
        System.out.println(st.empty());
    }
}
