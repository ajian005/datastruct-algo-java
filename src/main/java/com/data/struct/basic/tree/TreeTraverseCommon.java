package com.data.struct.basic.tree;

import org.junit.Test;

/**
 * 二叉树遍历框架，典型的非线性递归遍历结构：
 */
public class TreeTraverseCommon {
    /**
     * 基本的二叉树节点
     */
    class TreeNode{
        int val;
        TreeNode left, right;
    }

    /**
     * 二叉树遍历框架，典型的非线性递归遍历结构：
     * @param root
     */
    public void treeTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历
        // 前序遍历TreeNode.val
        treeTraverse(root.left);
        // 中序遍历
        System.out.println("中序遍历TreeNode.val=" + root.val);
        treeTraverse(root.right);
        // 后续遍历
        // 后序遍历TreeNode.val
    }

    /**
     * 测试二叉树
     *         6
     *        / \
     *       3   8
     *      / \ / \
     *     1  5 7  9
     */
    @Test
    public void testTreeTraverse() {
        TreeNode node1 = new TreeNode();
        node1.val = 1;
        TreeNode node5 = new TreeNode();
        node5.val = 5;
        TreeNode node3 = new TreeNode();
        node3.val = 3;
        node3.left  = node1;
        node3.right = node5;

        TreeNode node7 = new TreeNode();
        node7.val = 7;
        TreeNode node9 = new TreeNode();
        node9.val = 9;
        TreeNode node8 = new TreeNode();
        node8.val = 8;
        node8.left  = node7;
        node8.right = node9;

        TreeNode node6 = new TreeNode();
        node6.val = 6;
        node6.left  =  node3;
        node6.right =  node8;

        treeTraverse(node6);
    }

    /**
     * N叉树的遍历框架
     */
    class NTreeNode{
        int val;
        NTreeNode[] children;
    }

    /**
     * 你看二叉树的递归遍历方式和链表的递归遍历方式，相似不？再看看二叉树结构和单链表结构，相似不？如果再多几条叉，N 叉树你会不会遍历？
     * 二叉树框架可以扩展为 N 叉树的遍历框架：
     */
    public void nTreeTraverse(NTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("NTreeNode.val=" + root.val);
        NTreeNode[] children = root.children;
        if (children == null) {
            return;
        }
        for (NTreeNode child : root.children) {
            if (child == null) {
                continue;
            }
            nTreeTraverse(child);
        }
    }

    /**
     * 测试N叉树
     *         6
     *        / \
     *       3   8
     *      / \ / \ \
     *     1  5 7  9 11
     */
    @Test
    public void testNTreeTraverse() {
        NTreeNode nTreeNode6 = new NTreeNode();
        nTreeNode6.val = 6;
        NTreeNode nTreeNode3 = new NTreeNode();
        nTreeNode3.val = 3;
        NTreeNode nTreeNode8 = new NTreeNode();
        nTreeNode8.val = 8;
        NTreeNode[] child3_8 = {nTreeNode3, nTreeNode8};
        nTreeNode6.children = child3_8;

        NTreeNode nTreeNode1 = new NTreeNode();
        nTreeNode1.val = 1;
        NTreeNode nTreeNode5 = new NTreeNode();
        nTreeNode5.val = 5;

        nTreeNode3.val = 3;
        NTreeNode[] child1_5 = {nTreeNode1, nTreeNode5};
        nTreeNode3.children = child1_5;

        NTreeNode nTreeNode7 = new NTreeNode();
        nTreeNode7.val = 7;
        NTreeNode nTreeNode9 = new NTreeNode();
        nTreeNode9.val = 9;
        NTreeNode nTreeNode11 = new NTreeNode();
        nTreeNode11.val = 11;

        nTreeNode8.val = 8;
        NTreeNode[] child7_9_11 = {nTreeNode7, nTreeNode9, nTreeNode11};
        nTreeNode8.children = child7_9_11;

        nTreeTraverse(nTreeNode6);
    }
}