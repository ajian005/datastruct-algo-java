package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * 124. 二叉树中的最大路径和 https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 *
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 *
 * 提示：
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeMaxPathSum_124_Hard {
    /**
     *  * 示例 1：
     *  *
     *  *
     *  * 输入：root = [1,2,3]
     *  * 输出：6
     *  * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
     */
    @Test
    public void testcase1_maxPathSum() {
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 2;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 3;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 1;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        int maxPathSum = maxPathSum(treeNode1);
        System.out.println("maxSum=" + maxSum);
        Assert.assertEquals("输出：6", 6, maxSum);
    }

    /**
     *  * 示例 2：
     *  * 输入：root = [-10,9,20,null,null,15,7]
     *  * 输出：42
     *  * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
     */
    @Test
    public void testCase2_maxPathSum() {
        TreeNode treeNode15 = new TreeNode();
        treeNode15.val = 15;
        TreeNode treeNode7 = new TreeNode();
        treeNode7.val = 7;
        TreeNode treeNode20 = new TreeNode();
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        treeNode20.val = 20;

        TreeNode treeNode9 = new TreeNode();
        treeNode9.val = 9;
        TreeNode treeNodeNegative10 = new TreeNode();
        treeNodeNegative10.val = -10;
        treeNodeNegative10.left = treeNode9;
        treeNodeNegative10.right = treeNode20;

        int maxPathSum = maxPathSum(treeNodeNegative10);
        System.out.println("maxSum=" + maxSum);
        Assert.assertEquals("输出：42", 42, maxSum);
    }

    private int maxSum = Integer.MIN_VALUE;

    /**
     * 二叉树中的最大路径和()
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxPathSumInner(root);
        return maxSum;
    }


    public int maxPathSumInner(TreeNode root) {
        // 到树的叶子节点则返回val=0
        if (root == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int maxPathSumLeft  = Integer.max(0, maxPathSumInner(root.left));
        int maxPathSumRight = Integer.max(0, maxPathSumInner(root.right));

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int maxPathSum = root.val + maxPathSumLeft + maxPathSumRight;

        // 更新答案
        maxSum = Math.max(maxSum, maxPathSum);
        // 返回节点的最大贡献值 当前节点 + 最大的left或right
        return root.val + Integer.max(maxPathSumLeft, maxPathSumRight);
    }

    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}