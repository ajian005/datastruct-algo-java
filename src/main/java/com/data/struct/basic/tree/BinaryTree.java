package com.data.struct.basic.tree;

/**
 * 定义一个二叉树
 */
public class BinaryTree {
    // Root of Binary Tree
    Node root;

    // Constructors
    BinaryTree(int key) {
        root = new Node(key);
    }
    BinaryTree(){
        root = null;
    }

    // Given a binary tree, print its nodes according to the
    // "bottom-up" postorder traversal.
    public void postorder(Node node) {
        if (node == null)
            return;

        // First recur on left subtree
        postorder(node.left);

        // Then recur on right subtree
        postorder(node.right);

        // Now deal with the node
        System.out.print(node.key + " ");
    }

    /**
     * Given a binary tree, print its nodes in inorder
     */
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        // First recur on left child
        inOrder(node.left);

        // then print the data of node
        System.out.println(node.key + " ");

        // Now recur on right child
        inOrder(node.right);
    }


    /**
     * Given a binary tree, print its nodes in preorder
     */
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        // First print data of node
        System.out.print(node.key + " ");

        // the recur on left subtree
        preOrder(node.left);

        // the recur on right subtree
        preOrder(node.right);
    }

    public BinaryTree createBinaryTree() {
        BinaryTree tree = new BinaryTree();
        /* Following is the tree after above statement
           1
          / \
        null null
        */
        // Create root
        tree.root = new Node(1);
        /* 2 and 3 become left and right children of 1
              1
             / \
            2   3
           / \ / \
       null null null null
       */
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
    /* 4 becomes left child of 2
               1
              / \
             2   3
            / \ / \
           4 null null null
          / \
        null null
        */
        tree.root.left.left = new Node(4);
        return tree;
    }

    /**
     * Class containing left and right child of current node and key value
     */
     class Node {
        int key;
        Node left, right;
        Node(int item) {
            key = item;
            left = right = null;
        }
    }
}