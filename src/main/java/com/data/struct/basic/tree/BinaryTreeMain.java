package com.data.struct.basic.tree;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTreeDemo = new BinaryTree();
        BinaryTree binaryTree = binaryTreeDemo.createBinaryTree();
        binaryTreeDemo.preOrder(binaryTree.root);
    }
}
