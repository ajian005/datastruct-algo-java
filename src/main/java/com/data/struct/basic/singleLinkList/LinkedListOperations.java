package com.data.struct.basic.singleLinkList;

/**
 * 链表有哪些操作？
 * 在 Java 里，链表是一种常用的数据结构，常见的操作有以下这些：
 * 1. 定义链表节点类
 * 在 Java 中，首先要定义链表节点类，代码如下：
 * 2. 常见操作
 * 插入节点
 *   头部插入：把新节点插入到链表的头部。
 *   尾部插入：将新节点添加到链表的尾部。
 *   中间插入：在指定位置插入新节点。
 * 删除节点
 *   删除头部节点：移除链表的第一个节点。
 *   删除指定值节点：删除链表中值等于给定值的节点。
 * 查找节点
 *   按照给定的值查找链表中对应的节点。
 * 遍历链表
 *   从链表头节点开始，依次访问每个节点。
 * 获取链表长度
 * 统计链表中节点的数量。
 * 示例代码
 * 此代码定义了链表节点类 ListNode 和链表类 LinkedList，并在 Main 类的 main 方法中对链表的插入、删除、查找、遍历和获取长度等操作进行了测试。
 */

/*
class ListNode {
    public int value;
    public ListNode next;
}
*/

public class LinkedListOperations {
    private ListNode head;
    public LinkedListOperations() {
        this.head = null;
    }

    /**
     *  输入一个数组，转换为一条单链表
     */
    ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            cur.next = newNode;
            cur = newNode;
        }
        return dummy.next;
    }

    /**
     * 插入节点:头部插入：把新节点插入到链表的头部。
     */
    public void insertAtHead(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    /**
     * 插入节点:尾部插入：将新节点添加到链表的尾部。
     */
    public void insertAtTail(int value) {
        ListNode newNode = new ListNode(value);
        // 链表为空时，将新节点作为头节点
        if (head == null) {
            head = newNode;
        }
        // 链表不为空时，找到链表的最后一个节点，并插入新节点
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * 插入节点: 中间插入：在指定位置插入新节点。
     */
    public void insertAtMiddle(int value, int position) {
        if (position <= 0) {
            insertAtHead(value);
        } else {
            ListNode newNode = new ListNode(value);
            ListNode current = head;
            int currentPosition = 0;
            while (current != null && currentPosition < position - 1) {
                current = current.next;
                currentPosition++;
            }
            if (current != null) {
                newNode.next = current.next;
               current.next = newNode;
            }
        }
    }

    /**
     * 删除节点:删除头部节点  ：移除链表的第一个节点。
     */
    public void deleteAtHead() {
        if (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
        }
    }


    /**
     * 删除指定值节点：删除链表中值等于给定值的节点。
     */
    // 删除指定值节点
    public void deleteByValue(int val) {
        if (head == null) {
            return;
        }
        if (head.val == val) {
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null && current.next.val != val) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    /**
     * 查找节点 按照给定的值查找链表中对应的节点。
     */
    public ListNode findNode(int val) {
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     *  遍历链表 从链表头节点开始，依次访问每个节点。
     */
    public void printLinkedList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     *  获取链表长度  统计链表中节点的数量。
     */
    public int getLength() {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    /**
     * 链表的反转
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    /**
     * 打印链表
     */
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListOperations linkedList = new LinkedListOperations();
        // 创建一个数组
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = linkedList.createLinkedList(arr);
        System.out.print("输出新创建的列表");
        linkedList.printLinkedList(listNode);
    }
}