package com.data.struct.basic.linkList;

import org.checkerframework.checker.units.qual.N;

/**
 * 双向链表在 Java 中并没有直接的实现，但是可以通过定义节点类和链表类来实现。下面是一个简单的双向链表实现示例：
 * 我们定义了一个DoubleLinkedList类，其中包含一个私有内部类Node，用于表示链表中的节点。
 * DoubleLinkedList类实现了双向链表的基本操作，包括添加节点、删除节点、查找节点和显示链表等。
 */
public class DoublelyLinkedList {
    /**
     * 实现一个节点
     */
    private class Node {
        // 节点数据
        private int data;
        // 前一个节点
        private Node prev;
        // 后一个节点
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    // 链表头节点
    Node head;
    // 链表尾节点
    Node tail;

    // 构造函数
    public DoublelyLinkedList() {
        // 创建头节点
        head = new Node(-1);
        // 创建尾节点
        tail = new Node(-1);
        // 将头结点和尾节点连接起来
        head.next  = tail;
        tail.prev  = head;
    }

    /**
     * 队尾添加新节点
     */
    public void addToHead(int data) {
        // 创建新节点

        // 如果链表为空，则将新节点作为头节点和尾节点
        if (isEmpty()) {

        } else {
            // 将新节点添加到链表尾部

            // 更新尾节点为新节点
        }
    }

    /**
     * 队首添加新节点
     */
    public void addToTail(int data) {
        // 创建新节点
        Node newNode = new Node(data);
        // 如果链表为空，则将新节点作为头节点和尾节点
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            // 将新节点添加到链表尾部
            tail.next = newNode;
            newNode.prev = tail;
            // 更新尾节点尾新节点
            tail = newNode;
        }
    }

    /**
     * 按索引位置插入新节点
     */
    public void addToIndex(int index, int data) {

    }

    /**
     * 删除指定的节点
     */
    public void remove(int data) {
        // 如果链表为空, 则返回
        if (isEmpty()) {
            return;
        }
        // 查找要删除的节点
        Node node = find(data);
        // 如果找到节点，则删除节点
        if (node  != null) {
            // 如果节点是头节点或尾节点，则更新头节点或尾节点
            if (node == head) {
                head = head.next;
            } else if (node == tail) {
                tail = tail.prev;
            }
            // 删除节点
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * 在队头删除节点
     */
    public void removeToHead() {

    }

    /**
     * 在队尾删除节点
     */
    public void removeToTail() {

    }

    /**
     * 查询节点
     */
    public Node find(int data) {
        // 如果链表为空，则返回 null
        if (isEmpty()) {
            return null;
        }
        // 从链表头节点开始查找
        Node node = head.next;
        while (node != null) {
            // 如果找到节点,则返回节点
            if (node.data == data) {
                return node;
            }
            // 移动到下一个节点
            node = node.next;
        }
        // 如果未找到节点，则返回 null
        return null;
    }

    /**
     * 判断是不是空链表
     */
    public boolean isEmpty() {
        // 如果头节点的下一个节点为尾节点，则链表为空;
        return ((head == null) );
    }

    /**
     * 显示遍历链表
     */
    public void display() {
        // 如果链表为空，则返回
        if (isEmpty()) {
            return;
        }
        // 从链表头节点开始遍历
        Node node = head.next;
        while (node != null) {
            // 输出节点数据
            System.out.print(node.data + " ");
            // 移动到下一个节点
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建双向链表对象
        DoublelyLinkedList dll = new DoublelyLinkedList();
        // 添加节点
        dll.addToTail(10);
        dll.addToTail(20);
        dll.addToTail(30);
        dll.addToTail(40);
        // 删除节点
        dll.remove(20);
        // 查找节点
        Node node = dll.find(30);
        if (node!= null) {
            System.out.println("找到节点: " + node.data);
        } else {
            System.out.println("未找到节点");
        }
        // 显示链表
        dll.display();
    }
}