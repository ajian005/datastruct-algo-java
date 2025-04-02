package com;

import com.leetcode.algorithm.LinkNodee;
import com.leetcode.algorithm.ListNode;
/**
 * 两个数 如3 + 4 = 7
 * 用两个链表二进制表示这两数并进行计算
 */
public class BinaryDataComputClass {
    public static void main(String[] args) {
        BinaryDataComputClass object = new BinaryDataComputClass();
        object.linkNodeeProcess();
    }

    private void linkNodeeProcess() {
        LinkNodee linkNodee1 = getLinkNodee1();
        System.out.println("打印linkNodee1=");
        printLinkNodee(linkNodee1);
        LinkNodee linkNodee2 = getLinkNodee2();
        System.out.println("打印linkNodee2=");
        printLinkNodee(linkNodee2);

        LinkNodee linkNodee3 = reverseLinkNodee(linkNodee1);
        System.out.println("打印linkNodee1的反转=");
        printLinkNodee(linkNodee3);

        LinkNodee linkNodee4 = reverseLinkNodee(linkNodee2);
        System.out.println("打印linkNodee2的反转=");
        printLinkNodee(linkNodee4);


        LinkNodee linkNodee5 = addTwoNumbers(linkNodee3, linkNodee4);
        System.out.println("打印linkNodee 链表之和=");
        printLinkNodee(linkNodee5);

    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    private LinkNodee reverseLinkNodee(LinkNodee head) {
        LinkNodee pre = null;
        LinkNodee current = head;
        while (current != null) {
            LinkNodee tempNext = current.getNext();
            current.setNext(pre);
            pre = current;
            current = tempNext;
        }
        return pre;
    }


    private  LinkNodee getLinkNodee2() {
        // 链表2
        LinkNodee head1 = new LinkNodee(1);
        LinkNodee node2 = new LinkNodee(1);
        head1.setNext(node2);
        LinkNodee node3 = new LinkNodee(1);
        node2.setNext(node3);
        LinkNodee head4 = new LinkNodee(1);
        node3.setNext(head4);
        return head1;
    }

    private static LinkNodee getLinkNodee1() {
        //链表1
        LinkNodee head1 = new LinkNodee(1);
        LinkNodee node2 = new LinkNodee(1);
        head1.setNext(node2);
        LinkNodee node3 = new LinkNodee(1);
        node2.setNext(node3);
        LinkNodee node4 = new LinkNodee(1);
        node3.setNext(node4);
        return head1;
    }

    private void printLinkNodee(LinkNodee head) {
        LinkNodee current = head;
        while (current != null) {
            System.out.print(current.getData() + "-->");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public  LinkNodee addTwoNumbers(LinkNodee l1, LinkNodee l2) {
        LinkNodee linkNodee1 = l1;
        LinkNodee linkNodee2 = l2;
        LinkNodee head = null;
        LinkNodee current = new LinkNodee(-1);
        head = current;
        int charry = 0;
        while (linkNodee1 != null || linkNodee2 != null || charry != 0) {
            LinkNodee newNode = new LinkNodee(0);
            int data1 = getLinkNodeeData(linkNodee1);
            int data2 = getLinkNodeeData(linkNodee2);
            int sum = data1 + data2 + charry;
            charry = sum / 2;
            newNode.setData(sum % 2);
            current.setNext(newNode);
            current = current.getNext();
            if (linkNodee1 != null) {
                linkNodee1 = linkNodee1.getNext();
            }
            if (linkNodee2 != null) {
                linkNodee2 = linkNodee2.getNext();            }
        }
        head = head.getNext();
        return head;
    }

    private int getLinkNodeeData(LinkNodee l1) {
        if (l1 == null) {
            return 0;
        }
        return l1.getData();
    }
}