package com.data.struct.basic;

import org.junit.Test;

/**
 * 链表遍历框架，兼具迭代和递归结构
 */
public class LinkedListTraverseCommon {
    /**
     * 非递归的链表遍历
     */
    public void linkedListTraverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.getNext()) {
            // 迭代访问 p.val
            System.out.println("listNode.val=" + p.getVal());
        }
    }

    /**
     * 递归的链表遍历
     */
    public void recursionLinkedListTraverse(ListNode head) {
        // 递归访问 head.val
        if (head == null) {
            return;
        }
        System.out.println("listNode.val=" + head.getVal());
        recursionLinkedListTraverse(head.getNext());
    }

    private ListNode getLinkedList() {
        ListNode node5 = new ListNode();
        node5.setVal(5);
        node5.setNext(null);

        ListNode node4 = new ListNode();
        node4.setVal(4);
        node4.setNext(node5);

        ListNode node3 = new ListNode();
        node3.setVal(3);
        node3.setNext(node4);

        ListNode node2 = new ListNode();
        node2.setVal(2);
        node2.setNext(node3);

        ListNode head = new ListNode();
        head.setVal(1);
        head.setNext(node2);
        return head;
    }

    /**
     * test递归的链表遍历
     */
    @Test
    public void TestRecursionLinkedListTraverse() {
        recursionLinkedListTraverse(getLinkedList());
    }


    /**
     * 测试非递归的链表遍历
     */
    @Test
    public void TestlinkedListTraverse() {
        linkedListTraverse(getLinkedList());
    }

    /**
     * 基本的单链表结构
     */
    public static class ListNode {
        private int val;
        private ListNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}