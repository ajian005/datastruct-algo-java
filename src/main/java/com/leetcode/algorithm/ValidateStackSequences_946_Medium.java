package com.leetcode.algorithm;

import java.util.Stack;

/**
 946. Validate Stack Sequences  https://leetcode.cn/problems/validate-stack-sequences/description/?envType=study-plan-v2&envId=selected-coding-interview
 Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

 Example 1:
 Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 Output: true

 Explanation: We might do the following sequence:
 push(1), push(2), push(3), push(4),
 pop() -> 4,
 push(5),
 pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

 Example 2:
 Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 Output: false

 Explanation: 1 cannot be popped before 2.

 Constraints:
 1 <= pushed.length <= 1000
 0 <= pushed[i] <= 1000

 All the elements of pushed are unique.
 popped.length == pushed.length
 popped is a permutation of pushed.
 */
public class ValidateStackSequences_946_Medium {
    Stack<Integer>  pushStack = null;
    Stack<Integer>  popStack = null;

    public ValidateStackSequences_946_Medium() {
        pushStack = new Stack<>();
        popStack = new Stack<>();

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            pushStack.push(pushed[i]);
            while (!pushStack.empty() && pushStack.peek() == popped[j]) {
                pushStack.pop();
                j++;
            }
        }
        if (pushStack.empty()) {
            return true;
        }
        return false;
    }

    public boolean validateStackSequences3(int[] pushed, int[] popped) {
        int k = 0;
        for (int i = 0; i < popped.length; i++) {
            int poppedTop = popped[i];
            int index = 0;
            for (int j = index; j < pushed.length; j++) {
                if (j > 0 && poppedTop == pushed[j-1]) {
                    index = j-1;
                    ++k;
                    break;
                } else if (poppedTop == pushed[j]) {
                    ++k;
                    index = j;
                    break;
                } else {
                    if (i != 0) {
                        return false;
                    }
                }
            }
        }
        if (k == popped.length) {
            return true;
        }
        return false;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        for (int i = popped.length-1; i >= 0; i--) {
            popStack.push(popped[i]);
        }
        int j = 0;
        pushStack.push(pushed[0]);
        int k = 0;
        for (int i = 0; i < (pushed.length + popped.length); i++) {
            if ((j >= pushed.length && popStack.empty()) || pushStack.empty()) {
                break;
            }
            int top1 = popStack.peek();
            int top2 = pushStack.peek();
            if (top1 == top2) {
                popStack.pop();
                pushStack.pop();
                ++k;
            } else {
                if (j >= pushed.length) {
                    return false;
                }
                pushStack.push(pushed[j++]);
            }
        }
        if (k == pushed.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
             useCase01();
             useCase02();
             useCase03();
    }

    private static void useCase01() {
        ValidateStackSequences_946_Medium obj = new ValidateStackSequences_946_Medium();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(obj.validateStackSequences(pushed, popped));
    }

    private static void useCase02() {
        ValidateStackSequences_946_Medium obj = new ValidateStackSequences_946_Medium();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        System.out.println(obj.validateStackSequences(pushed, popped));
    }

    private static void useCase03() {
        ValidateStackSequences_946_Medium obj = new ValidateStackSequences_946_Medium();
        int[] pushed = {1,0};
        int[] popped = {1,0};
        System.out.println(obj.validateStackSequences(pushed, popped));
    }
}
