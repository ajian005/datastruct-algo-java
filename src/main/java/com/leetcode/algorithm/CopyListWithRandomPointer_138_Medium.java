package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

class RadomNode {
    public int value;
    // 下一个节点
    public RadomNode next;
    // 随机节点
    public RadomNode randomNode;
    public RadomNode(int value) {
        this.value = value;
    }
}

/**
 * Copy List with Random Pointer
 * 138.随机链表的复制
 */
public class CopyListWithRandomPointer_138_Medium {
    public static void main(String[] args) {
        CopyListWithRandomPointer_138_Medium object = new CopyListWithRandomPointer_138_Medium();
        object.test();
    }

    public void test() {
        System.out.println("Hello World!");
        // 输出链表信息
        RadomNode head = getRandomList();
        printList(head);

        printRandomList(head);

        System.out.println("Copy List:");
        // 输出Copy的列表；
        RadomNode copyHead = copyRandomList(head);
        printList(copyHead);
        printRandomList(copyHead);

    }

    /**
     * 创建一个随机节点列表
     */
    private RadomNode getRandomList() {
        RadomNode head = new RadomNode(1);
        head.next = new RadomNode(2);
        head.next.next = new RadomNode(3);
        head.next.next.next = new RadomNode(4);
        head.next.next.next.next = new RadomNode(5);
        head.randomNode = head.next.next;
        head.next.randomNode = head.next.next.next;
        head.next.next.randomNode = head.next.next.next;
        head.next.next.next.randomNode = head.next.next;
        head.next.next.next.next.randomNode = head;
        return head;
    }

    /**
     * 打印列表
     */
    public void printList(RadomNode head) {
        RadomNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public RadomNode copyRandomList2(RadomNode head) {
        RadomNode dummy = new RadomNode(-1);
        RadomNode pre = dummy;
        RadomNode current = head;
        while (current  != null) {
            pre.next = new RadomNode(current.value);
            pre.next.randomNode = new RadomNode(current.randomNode.value);
            pre = pre.next;
            current = current.next;
        }
        return dummy.next;
    }

    public RadomNode copyRandomList(RadomNode head) {
        // 创建一个HashMap来存储原始节点和复制节点的映射关系
        Map<RadomNode, RadomNode> map = new HashMap<>();
        RadomNode current = head;
        while (current != null) {
            RadomNode copyNode = new RadomNode(current.value);
            map.put(current, copyNode);
            current = current.next;
        }

        current = head;
        while (current != null) {
            // 遍历原始链表，为每个节点创建一个复制节点，并保存映射关系
            RadomNode copyNode = map.get(current);
            copyNode.next = map.get(current.next);

            // 遍历复制链表，为每个复制节点设置随机节点的映射关系
            copyNode.randomNode = map.get(current.randomNode);
            current = current.next;
        }
        return map.get(head);
    }


    /**
     * 打印随机节点列表
     */
    public void printRandomList(RadomNode head) {
        RadomNode current = head;
        while (current != null) {
            System.out.print("Node:" + current.value);
            if (current.randomNode != null) {
                System.out.println(" Random:" + current.randomNode.value);
            }
            current = current.next;
        }
    }
}
