package com.data.struct.basic;

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
     * N叉树的遍历框架
     */
    class TreeNode{
        int val;
        TreeNode left, right;
    }


    /**
     * 你看二叉树的递归遍历方式和链表的递归遍历方式，相似不？再看看二叉树结构和单链表结构，相似不？如果再多几条叉，N 叉树你会不会遍历？
     * 二叉树框架可以扩展为 N 叉树的遍历框架：
     */
    public void

}