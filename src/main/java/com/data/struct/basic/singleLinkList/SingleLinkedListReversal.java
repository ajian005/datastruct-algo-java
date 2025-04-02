package com.data.struct.basic.singleLinkList;

/**
 * 单链表反转
 */

// 链表节点定义
class ListNode {
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode next;
    public int val;
}

public class SingleLinkedListReversal {

    public static void main(String[] args) {
        SingleLinkedListReversal reversal = new SingleLinkedListReversal();
        reversal.test();
    }

    public void test() {
        // 创建一个示例链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Original List:");
        printListNode(head);

        // 反转链表
        ListNode reversedHead = reverseList(head);

        // 打印反转链表
        System.out.println("Reversed List:");
        printListNode(reversedHead);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNext = current.next;
            current.next = pre;
            pre = current;
            current = tempNext;
        }
        return pre;
    }

    public void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "-->");
            current = current.next;
        }
        System.out.println("null");
    }
}