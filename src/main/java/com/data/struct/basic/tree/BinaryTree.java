package com.data.struct.basic.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Given a binary tree, print its nodes in levelorder
     */
    public void levelOrder1(Node node) {
        int hight = maxDepth(node);
        for (int i = 0; i <= hight; i++) {
            printCurrentLevel(node, i);
        }

    }

    /**
     * Print nodes at the current level 递归版
     * @param root
     * @param level
     */
    public void printCurrentLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.key + " ");
        } else if(level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

    /**
     * Given a binary tree.
     * Print its nodes in level order using array for implementing queue
     * @param root
     */
    public void printLevelOrderByQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // poll() removes the present head.
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    /**
     * Compute the "maxDepth" of a tree
     * -- the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    int maxDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            /* use the large one */
            if (lDepth > rDepth) {
                return lDepth + 1;
            } else {
                return rDepth + 1;
            }
        }
    }

    /**
     * insertion-in-a-binary-tree-in-level-order https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
     * function to insert element in binary tree
     * @return
     */
    public void insert(Node temp, int key) {
        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                q.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = new Node(key);
            } else {
                q.add(temp.right);

            }
        }
    }

    /**
     * Function to delete deepest element in binary tree
     * @return
     */
    public static void deleteDeepest(Node root, Node delNode) {
        Queue<Node>  q = new LinkedList<>();
        q.add(root);

        Node temp = null;

        // Do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp == delNode) {
                temp = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    q.add(temp.left);
                }
            }
        }
    }

    /**
     * Function to delete given element in binary tree
     * @return
     */
    public void delete(Node root, int key) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            } else {
                return;
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null, keyNode = null;

        // Do level order traveral until
        // we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.key == key) {
                keyNode = temp;
            }

            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }

            if (keyNode != null) {
                int x = temp.key;;
                keyNode.key = x;
                deleteDeepest(root, temp);
            }
        }
    }

    /**
     * Function to print the spiral traversal of tree
     */
    public void printSpiral(Node node) {
        int h = maxDepth(node);
        /**
         * ltr -> left to right.
         * If this variable is set then the given label is traversed from left to right
         */
        boolean ltr = false;
        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i, ltr);
            /**
             * Revert ltr traverse next level in opposite order
             */
            ltr = !ltr;
        }
    }

    /**
     * Print nodes at a given level
     * @return
     */
    public void printGivenLevel(Node node, int level, boolean ltr) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.key + " ");
        } else if (level > 1) {
            if (ltr != false) {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right, level - 1, ltr);
            } else {
                printGivenLevel(node.right, level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
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