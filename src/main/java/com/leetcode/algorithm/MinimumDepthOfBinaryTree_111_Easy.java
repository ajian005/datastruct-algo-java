package com.leetcode.algorithm;

/**
 * Definition for a binary tree node.
 */

class TreeNodev {
     int val;
    TreeNodev left;
    TreeNodev right;
    TreeNodev() {}
    TreeNodev(int val) { this.val = val; }
    TreeNodev(int val, TreeNodev left, TreeNodev right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class MinimumDepthOfBinaryTree_111_Easy {
    // 记录最小深度（根节点到最近的叶子节点的距离）
    private int minDepth = Integer.MAX_VALUE;
    // 记录当前遍历到的节点深度
    private int currentDepth = 0;

    public int minDepth(TreeNodev root) {
        if (root == null) {
            return 0;
        }
        // 从根节点开始 DFS 遍历
        traverse(root);
        return minDepth;
    }

    private void traverse(TreeNodev root) {
        if (root == null) {
            return;
        }

        // 前序位置进入节点时增加当前深度
        currentDepth++;

        // 如果当前节点是叶子节点，更新最小深度
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, currentDepth);
        }
        traverse(root.left);
        traverse(root.right);

        // 后序位置离开节点时减少当前深度
        currentDepth--;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree_111_Easy obj = new MinimumDepthOfBinaryTree_111_Easy();
        TreeNodev root = new TreeNodev();
        root.val = 3;
        TreeNodev rootLeft = new TreeNodev();
        rootLeft.val = 9;
        root.left = rootLeft;
        TreeNodev rootRight = new TreeNodev();
        rootLeft.val = 20;
        root.right = rootRight;
        rootLeft.left = null;
        rootLeft.right = null;

        TreeNodev rootRightLeft = new TreeNodev();
        rootRightLeft.val = 15;
        TreeNodev rootRightRight = new TreeNodev();
        rootRightRight.val = 7;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        int minDepth = obj.minDepth(root);
        System.out.println("minDepth=" + minDepth);
    }

}