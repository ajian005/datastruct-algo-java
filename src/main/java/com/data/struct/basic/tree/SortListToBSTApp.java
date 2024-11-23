package com.data.struct.basic.tree;

/**
 * 首先，我们创建一个双向链表的基本结构。然后，我们将这个双向链表转换为一个排序的二叉搜索树。
 * 这种转换通常被称为“平衡链表转二叉搜索树”问题。
 * 1 实现一个双向链表功能
 * 2 实现一个双向链表转二叉树功能
 * 3 打印二叉树节点列表
 */

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }
}

/**
 *
 * 将双向链表转换为二叉搜索树
 * 为了将双向链表转换为二叉搜索树，我们可以首先找到链表的中点，然后使该中点作为根。
 * 递归地对中点左边的子链表和中点右边的子链表执行相同的操作，以构建左子树和右子树。
 * 这种方法确保生成的二叉搜索树是平衡的。
 * 首先，我们需要一个辅助方法来找到链表的中点：
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BSTree {
    /**
     * 找到链表的中点
     * @param start
     * @param end
     * @return
     */
    public Node findMiddle(Node start, Node end) {
        if (start == null) {
            return null;
        }
        Node slow = start;
        Node fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * // fixbug ?
     * @param head
     * @return
     */
    // fixme todo
    public TreeNode sortedListToBST(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.data);
        }
        Node mid = findMiddle(head, null);
        TreeNode root = new TreeNode(mid.data);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        // 断开链表连接，防止循环引用导致内存泄漏
        mid.prev.next = null;
        mid.next = null;
        return root;
    }

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.println(node.val);
        printTree(node.right);
    }
}


public class SortListToBSTApp {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        // 假设你有一个方法可以将二叉树打印出来，例如: printTree()
        BSTree bsTree = new BSTree();

        TreeNode root = bsTree.sortedListToBST(list.head);
        bsTree.printTree(root); // 这应该打印出平衡的二叉搜索树结构。
    }
}
