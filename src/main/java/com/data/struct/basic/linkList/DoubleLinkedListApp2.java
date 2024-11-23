package com.data.struct.basic.linkList;

/**
 * 定义双向链表节点
 */
class DoubleLinkedNode<T> {
    T data;
    DoubleLinkedNode<T> next;
    DoubleLinkedNode<T> prev;
    DoubleLinkedNode(T t) {
        this.data = t;
        next = null;
        prev = null;
    }
}

/**
 * 定义双向链表
 */
class DoubleLinkedList2<T> {
    DoubleLinkedNode<T> head = null;
    /**
     * 队列尾部添加节点
     */
    public void addToTail(T data) {
        if (head == null) {
            head = new DoubleLinkedNode<T>(data);
        } else {
            DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data);
            DoubleLinkedNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    /**
     * 打印节点列表
     */
    public void display() {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}

public class DoubleLinkedListApp2 {
    public static void main(String[] args) {
        DoubleLinkedList2<String> list2 = new DoubleLinkedList2<>();
        list2.addToTail("1");
        list2.addToTail("2");
        list2.addToTail("3");
        list2.addToTail("4");
        list2.addToTail("5");
        list2.display();
    }
}