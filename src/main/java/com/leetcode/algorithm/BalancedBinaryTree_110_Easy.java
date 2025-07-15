package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/balanced-binary-tree/description/?envType=study-plan-v2&envId=selected-coding-interview
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 *
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 *
 * Example 3:
 * Input: root = []
 * Output: true
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 *   -104 <= Node.val <= 104
 */
public class BalancedBinaryTree_110_Easy {
    public boolean isBalanced(TreeNode root) {
        if (height(root) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            int maxHeight = Integer.max(leftHeight, rightHeight) + 1;
            return maxHeight;
        }
    }

    public boolean isBalancedV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalancedV2(root.left) && isBalancedV2(root.right);
    }

    public int heightV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxHeight = Integer.max(heightV2(root.left), heightV2(root.right)) + 1;
        return maxHeight;
    }

    @Test
    public void useCase01() {
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node9, node20);
        boolean flag = isBalanced(node3);
        Assert.assertEquals("isBalanced", true, flag);
    }

    @Test
    public void useCase02() {
        TreeNode node1 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node1, node2);
        TreeNode node4 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(2, node3, node4);
        TreeNode node6 = new TreeNode(2, null, null);
        TreeNode node7 = new TreeNode(1, node5, node6);

        boolean flag = isBalanced(node7);
        Assert.assertEquals("isBalanced", false, flag);
    }

    @Test
    public void useCase03() {
        TreeNode node1 = null;
        boolean flag = isBalanced(node1);
        Assert.assertEquals("isBalanced", true, flag);
    }

    @Test
    public void test_isBalanced() {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(3, node3, node6);
        boolean flag = isBalanced(node5);
        Assert.assertEquals("isBalanced", false, flag);
    }
}