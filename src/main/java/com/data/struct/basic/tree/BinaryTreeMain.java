package com.data.struct.basic.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTreeDemo = new BinaryTree();
        BinaryTree binaryTree = binaryTreeDemo.createBinaryTree();
        binaryTreeDemo.preOrder(binaryTree.root);
    }

    @Test
    public void BinaryTreeMaxDepth() {
        BinaryTree binaryTreeDemo = new BinaryTree();
        BinaryTree binaryTree = binaryTreeDemo.createBinaryTree();
        int maxDepth = binaryTree.maxDepth(binaryTree.root);
        Assert.assertEquals("二叉树最大高度", 3, maxDepth);
    }
}
