package com.hello.algo.chapter13backtracking;

/**
 * 二叉树（binary tree）是一种非线性数据结构，代表“祖先”与“后代”之间的派生关系，体现了“一分为二”的分治逻辑。
 * 与链表类似，二叉树的基本单元是节点，每个节点包含值、左子节点引用和右子节点引用。
 */
/* 二叉树节点类 */
public class TreeNode {
    int val;            // 节点值
    TreeNode left;      // 左子节点引用
    TreeNode right;     // 右子节点引用
    TreeNode(int x) {
        val = x;
    }
}