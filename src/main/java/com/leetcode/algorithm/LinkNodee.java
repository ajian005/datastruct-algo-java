package com.leetcode.algorithm;

/**
 * 链表节点
 */
public class LinkNodee {


    private int data;

    private LinkNodee next;
    public LinkNodee(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    /**
     * 指向下一个节点
     * @param next
     */
    public void setNext(LinkNodee next) {
        this.next = next;
    }

    public LinkNodee getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}
