package com.leetcode.algorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal  https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * Example 2:
 * Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * Output: [4,2,6,5,7,1,3,9,8]
 * Explanation:
 *
 * Example 3:
 * Input: root = []
 * Output: []

 * Example 4:
 *
 * Input: root = [1]
 *
 * Output: [1]
 *
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
// Definition for a binary tree node.
class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5() {}
    TreeNode5(int val) { this.val = val; }
    TreeNode5(int val, TreeNode5 left, TreeNode5 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInorderTraversal_94_Medium {
    public List<Integer> inorderTraversal(TreeNode5 root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode5> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }


    public List<Integer> inorderTraversal2(TreeNode5 root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalInner(root, list);
        return list;
    }

    public void inorderTraversalInner(TreeNode5 root, List<Integer> response) {
        if (root == null) {
            return;
        }
        inorderTraversalInner(root.left, response);
        response.add(root.val);
        inorderTraversalInner(root.right, response);
    }

    @Test
    public void useCase01() {
        TreeNode5 node5 = constructTree();
        List<Integer> list =  inorderTraversal(node5);
        System.out.println(list);
    }

    public  TreeNode5 constructTree() {
        // 第一层
        TreeNode5 root = new TreeNode5(1);

        // 第二层
        root.left = new TreeNode5(2);
        root.right = new TreeNode5(3);

        // 第三层
        root.left.left = new TreeNode5(4);
        root.left.right = new TreeNode5(5);
        root.right.left = new TreeNode5(6);
        root.right.right = new TreeNode5(7);

        // 第四层
        root.left.left.left = new TreeNode5(8);
        root.left.left.right = new TreeNode5(9);
        root.left.right.left = new TreeNode5(10);
        root.left.right.right = new TreeNode5(11);
        root.right.left.left = new TreeNode5(12);
        root.right.left.right = new TreeNode5(13);
        root.right.right.left = new TreeNode5(14);
        root.right.right.right = new TreeNode5(15);
        return root;
    }
}