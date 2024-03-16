package com.data.struct.basic.linkList;

/**
 * 链表
 */
public class LinkList {
    private Link first;  // ref to first link on list
    // constructor
    public void LinkList() {
        first = null;
    }
    // true if list is empty
    public boolean isEmpty() {
        return (first == null);
    }

    // insert at start of list
    public void insertFirst(int id, double dd) {
        // make new link
        Link newLink = new Link(id, dd);
        // ? newlinke --> old first
        newLink.next  = first;
        // 为啥不是这样: newLink.next  = first.next;
        // first --> newLink
        first = newLink;
    }

    // delete from item assumes list not empty
    public Link deleteFirst() {
        // save reference to link
        Link temp = first;
        // delete it: first --> old next
        first = first.next;
        return temp;
    }

    // find link with given key
    public Link find(int key) {
        Link current = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void displayList() {
        System.out.println("List (first --> last): ");
        // start at beginning of list
        Link current = first;
        while (current != null) {
            current.displayLink();
            // move to next link
            current = current.next;
        }
        System.out.println(" ");
    }
}