package com.leetcode.algorithm;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 */
public class ImplementQueueUsingStacks_232_Easy {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public ImplementQueueUsingStacks_232_Easy() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }

    public int peek() {
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        // testCase1();
        // testCase2();
        testCase3();
    }
    private static void testCase3() {
        ImplementQueueUsingStacks_232_Easy object = new ImplementQueueUsingStacks_232_Easy();
        object.push(1);
        object.push(2);
        object.push(3);
        object.push(4);
        System.out.println(object.pop());
        object.push(5);
        System.out.println(object.pop());
        System.out.println(object.pop());
        System.out.println(object.pop());
        System.out.println(object.pop());

    }

    private static void testCase2() {
        ImplementQueueUsingStacks_232_Easy object = new ImplementQueueUsingStacks_232_Easy();
        object.push(1);
        System.out.println(object.empty());
    }

    private static void testCase1() {
        ImplementQueueUsingStacks_232_Easy object = new ImplementQueueUsingStacks_232_Easy();
        object.push(1);
        object.push(2);
        System.out.println(object.peek());
        System.out.println(object.pop());
        System.out.println(object.empty());
    }
}
