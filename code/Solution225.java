package code;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 用队列实现栈
public class Solution225 {


}

class MyStack {
    Deque<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.stack = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.stack.addLast(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return this.stack.removeLast();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.stack.peekLast();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.stack.isEmpty();
    }
}


// 双队列
class MyStack1 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack1() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}