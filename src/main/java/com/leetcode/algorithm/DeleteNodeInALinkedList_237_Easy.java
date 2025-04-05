package com.leetcode.algorithm;

/**
 * 237. 删除链表中的节点
 */
public class DeleteNodeInALinkedList_237_Easy {

    public static void main(String[] args) {
        DeleteNodeInALinkedList_237_Easy object = new DeleteNodeInALinkedList_237_Easy();
        ListNode listNode = object.getLinkedList();
        System.out.println("Original List:");
        object.printLinkedList(listNode);
        int val = 4;
        ListNode deletedListNode = object.deleteNode(listNode, val);
        System.out.println("After deleting node with value " + val + ":");
        object.printLinkedList(deletedListNode);
    }


    public ListNode getLinkedList(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        return head;
    }

    public ListNode deleteNode(ListNode node) {
        node.next = node.next.next;
        node.val = node.next.val;
        return node;
    }

    public ListNode deleteNode(ListNode node, int value) {
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode pre = dummy;
        if (pre.next == null) {
            return dummy.next;
        }
        while (pre.next != null) {
            if (pre.next.val == value) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return dummy.next;
    }

    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

}