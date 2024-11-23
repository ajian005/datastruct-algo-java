package com.data.struct.basic.tree;

/**
 * 定义链表节点
 */
class ListNode3 {
    int val;
    ListNode3 prev;
    ListNode3 next;
    ListNode3(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class TreeNode3 {
    int val;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * 定义链表转二叉树
 * 将双向链表转换为二叉树通常有多种方法，但最常见的是使用特定的规则来确保生成的二叉树是平衡的。
 * 一个简单且常用的规则是将链表中的节点按顺序分成两半，然后将中间的节点作为根，左半部分的节点构成左子树，右半部分的节点构成右子树。
 * 这种方法通常用于构造平衡的二叉搜索树（BST），但不是唯一的方法。
 * 在这个示例中，sortedListToBST 方法接收一个有序双向链表的头节点，并返回转换后的二叉搜索树的根节点。
 * 该方法使用递归和快慢指针技术来找到链表的中间节点，并以此作为二叉树的根。
 * 然后，它递归地对链表的左半部分和右半部分执行相同的操作，
 * 以构造左子树和右子树。
 * 最后，它断开了链表中的连接，以防止内存泄漏。
 */
class DoublyLinkedListToBinaryTree{
    public TreeNode3 sortedListToBST(ListNode3 head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode3(head.val);
        }
        // 找到链表的中间节点
        ListNode3 mid = findMiddle(head);
        // 创建树节点
        TreeNode3 root =  new TreeNode3(mid.val);
        // 如果链表不止一个节点，则递归构造左右子树
        if (head != mid) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(mid.next);
        // 断开链表中的连接，防止循环引用
        mid.prev = null;
        mid.next = null;
        return root;
    }


    // 使用快慢指针找到链表的中间节点
    private ListNode3 findMiddle(ListNode3 head) {
        ListNode3 prevPtr = null;
        ListNode3 slowPtr = head;
        ListNode3 fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        // 断开链表，返回中间节点
        if (prevPtr != null) {
            prevPtr.next = null;
        }
        return slowPtr;
    }

    // 付诸方法: 打印二叉树(中序遍历)
    public void printTree(TreeNode3 root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

}

public class DoublyLinkedListToBinaryTreeApp {
    public static void main(String[] args) {
        // 创建一个有序双向链表: 1 <-> 2 <-> 3 <-> 4 <-> 5
        ListNode3 head = new ListNode3(1);
        head.next = new ListNode3(2);
        head.next.prev = head;
        head.next.next = new ListNode3(3);
        head.next.next.prev = head.next;
        head.next.next.next = new ListNode3(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new ListNode3(5);
        head.next.next.next.next.prev = head.next.next.next;

        DoublyLinkedListToBinaryTree converter = new DoublyLinkedListToBinaryTree();
        TreeNode3 root = converter.sortedListToBST(head);
        // 打印转换后的二叉树（中序遍历）
        converter.printTree(root); // 输出应该是有序的，例如: 1 2 3 4 5
    }
}
