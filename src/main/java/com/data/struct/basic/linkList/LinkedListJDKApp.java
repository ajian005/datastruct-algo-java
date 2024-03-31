package com.data.struct.basic.linkList;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 系统自带双向链表
 */
public class LinkedListJDKApp {

    /**
     * 链表头插入节点
     */
    @Test
    public void testFirstInsert() {
        Deque<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.addFirst("o");
    }

    /**
     * 链表指定位置插入节点
     */
    @Test
    public void testlinkBefore() {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(2,  "d");
    }

    /**
     * 链表尾插入节点
     */
    public void testEndInsert() {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
    }

    /**
     * 删除队尾节点
     */
    @Test
    public void testRemoveLast() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.removeLast();
    }

    /**
     * 删除队首节点
     */
    @Test
    public void testRemoveFirst() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.removeFirst();
    }

    /**
     * 删除指定节点
     */
    @Test
    public void testRemoveByElement() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove("b");
    }

    /**
     * 按对象遍历节点
     */
    @Test
    public void testGetByObject() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.indexOf("b");
    }

    /**
     * 按索引遍历节点
     */
    @Test
    public void testGetByIndex() {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.get(2);
    }

}