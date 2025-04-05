package com.leetcode.algorithm;

/**
 * 155. 最小栈
 */
public class MinStack_155_Medium {
    private int value;
    private int[] stack;
    private int size = 1000;
    private int count = -1;
    private int min = Integer.MAX_VALUE;
    public MinStack_155_Medium() {
        stack = new int[size];
        count = 0;
    }

    public void push(int val) {
        if (count < size) {
            stack[count] = val;
            if (val < min) {
                min = val;
            }
            count++;
        } else {
            System.out.println("栈已满");
        }
    }

    public void pop() {
        int tempMin = Integer.MAX_VALUE;
        for (int i = 0; i < count-1; i++) {
            if (stack[i] < tempMin) {
                tempMin = stack[i];
            }
        }
        min = tempMin;
        stack[count-1] = 0;
        count--;
    }

    public int top() {
        return stack[count-1];
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        //testCase1();
        //testCase2();
        //testCase3();
        testCase4();
    }

    private static void testCase4() {
        MinStack_155_Medium minStack = new MinStack_155_Medium();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    private static void testCase3() {
        MinStack_155_Medium minStack = new MinStack_155_Medium();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    private static void testCase2() {
        MinStack_155_Medium minStack = new MinStack_155_Medium();
        minStack.push(-1);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    private static void testCase1() {
        MinStack_155_Medium minStack = new MinStack_155_Medium();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
