package com.data.struct.basic.linkList;

/**
 * 双链表
 * https://www.geeksforgeeks.org/introduction-to-linked-list-data-structure-and-algorithm-tutorial/
 * Output:
 * Original Linked list 10 8 4 2
 * Modified Linked list 8
 */
public class DoubleLinkedList {
    // head of list
    Node head;

    /**
     * Inserting At the Beginning of the list
     * Adding a node at the front of the list
     */
    public void insertFirst(int newData) {
        // 1. allocate node
        // 2. put in the data
        Node newNode = new Node(newData);

        // 3. Make next of new node as head and previous as NULL
        newNode.next = head;
        newNode.prev = null;

        // 4. change prev of head node to new node
        if (head != null) {
            head.prev = newNode;
        }

        // 5. move the head to point to the new node
        head = newNode;
    }

    /**
     * Given a node as prev_node, insert a new node after the given node
     */
    public void insertAfter(Node preNode, int newData) {
        // Check if the given prev_node is NULL
        if (preNode == null) {
            System.out.println("The given prevous node cannot be NULL ");
            return;
        }
        // 1. allocate node
        // 2. put in the data
        Node newNode = new Node(newData);

        // 3. make next of new node as next of preNode
        newNode.next = preNode.next;

        // 4. make the next of preNode as newNode
        newNode.prev = newNode;

        // 5. make prevNode as previous of newNode
        newNode.prev = preNode;

        // 6. change prevous of newNode's next node
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    /**
     * Add a node at the end of the list
     */
    public void append(int newData) {
        // 1. allocate node
        // 2. put in the data
        Node newNode = new Node(newData);

        /* used in step 5 */
        Node last = head;

        // 3.This newNode is going to be the last node, so make next of it as NULL
        newNode.next = null;

        // 4. if the Linked list is empty, then make the newNode as head
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return ;
        }

        // 5. Else traverse till the last node
        while (last.next != null) {
            last = last.next;
        }

        // 6. chage the next of last node
        last.next = newNode;

        // 7. make last node as previous of newNode
        newNode.prev = last;
    }

    /**
     * This function prints contents of linked list starting from the given node
     * @param node
     */
    public void printlist(Node node) {
        Node last = null;
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Function to delete a node in a Doubly Linked List.
     * head_ref --> pointer to head node pointer.
     * del --> data of node to be delete.
     * @param del
     */
    private void deleteNode(Node del) {
        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
    }

    /**
     * Function to delete the node at the given position in the doubly linked list
     */
    public void deleteNodeAtGivenPostion(int n) {
        /* if list in NULL or invalid position is given */
        if (head == null || n <= 0) {
            return;
        }

        Node current = head;
        int i;

        /**
         * traverse up to the node at position 'n' from the beginning
         */
        for (i = 1; current != null && i < n; i++) {
            current = current.next;
        }

        // if 'n' is greater than the number of nodes in the doubly linked list
        if (current == null) {
            return;
        }

        // delete the node pointed to by 'current'
        deleteNode(current);
    }


    // Driver Code
    public static void main(String[] args)
    {
        // Start with the empty list
        DoubleLinkedList dll = new DoubleLinkedList();

        // Insert 2. So linked list becomes 2->NULL
        dll.insertFirst(2);

        // Insert 4. So linked list becomes 4->2->NULL
        dll.insertFirst(4);

        // Insert 8. So linked list becomes 8->4->2->NULL
        dll.insertFirst(8);

        // Insert 10. So linked list becomes
        // 10->8->4->2->NULL
        dll.insertFirst(10);

        System.out.print("Original Linked list ");
        dll.printlist(dll.head);


        dll.deleteNode(dll.head); /*delete first node*/
        dll.deleteNode(dll.head.next); /*delete middle node*/
        dll.deleteNode(dll.head.next); /*delete last node*/

        System.out.print("\nModified Linked list ");
        dll.printlist(dll.head);
    }

    /**
     * Doubly Linked list Node
     */
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node (int d) {
            data = d;
        }
    }
}
