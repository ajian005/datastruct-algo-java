package com.leetcode.algorithm;

/**
 leetCode  将二叉搜索树转化为排序的双向链表
 Node 类：用来表示二叉树和双向链表的节点，包含节点的值以及左右指针。
 treeToDoublyList 方法：把二叉搜索树转换为双向链表。首先调用 inorder 方法来对树进行中序遍历，接着将链表的首尾相连。
 inorder 方法：以中序遍历的方式访问二叉树的节点，并且将节点连接成双向链表。
 main 方法：这是测试代码，构建了一个简单的二叉搜索树，调用 treeToDoublyList 方法进行转换，最后打印出双向链表的节点值。
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class BSTToDLL {
    private Node first;
    private Node last;

    public Node treeToDoublyList(Node node){
        if (node == null) {
            return null;
        }
        inorder(node);
        last.right = first;
        first.left = last;
        return first;
    }

    public void inorder(Node node) {
        if (node == null) {
            return ;
        }
        inorder(node.left);
        // 中序遍历处理逻辑位置
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;
        inorder(node.right);
    }


    public static void main(String[] args) {
        // 构建一个简单的二叉搜索树
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2, node1, node3);
        Node node5 = new Node(5);
        Node node4 = new Node(4, node2, node5);

        BSTToDLL solution = new BSTToDLL();
        Node head = solution.treeToDoublyList(node4);

        // 打印双向链表
        Node current = head;
        do {
            System.out.print(current.val + " ");
            current = current.right;
        } while (current != head);
    }
}
