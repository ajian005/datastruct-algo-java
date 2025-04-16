package com.leetcode.algorithm;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 230. Kth Smallest Element in a BST  https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=selected-coding-interview
 Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



 Example 1:


 Input: root = [3,1,4,null,2], k = 1
 Output: 1
 Example 2:


 Input: root = [5,3,6,2,4,null,null,1], k = 3
 Output: 3


 Constraints:

 The number of nodes in the tree is n.
 1 <= k <= n <= 104
 0 <= Node.val <= 104


 Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */

// Definition for a binary tree node.
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4() {}
    TreeNode4(int val) { this.val = val; }
    TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class KthSmallestElementInAbst_230_Medium {


    public int kthSmallest(TreeNode4 root, int k) {
        //List<Integer> list = new ArrayList<>();
        Deque<TreeNode4> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }



    @Test
    public void useCase01() {
        TreeNode4 node4 = constructTree();
        int count = kthSmallest(node4, 2);
        System.out.println("count=" + count);
    }

    public  TreeNode4 constructTree() {
        // 第一层
        TreeNode4 root = new TreeNode4(1);
        // 第二层
        root.left = new TreeNode4(2);
        root.right = new TreeNode4(3);
        // 第三层
        root.left.left = new TreeNode4(4);
        root.left.right = new TreeNode4(5);
        root.right.left = new TreeNode4(6);
        root.right.right = new TreeNode4(7);
        // 第四层
        root.left.left.left = new TreeNode4(8);
        root.left.left.right = new TreeNode4(9);
        root.left.right.left = new TreeNode4(10);
        root.left.right.right = new TreeNode4(11);
        root.right.left.left = new TreeNode4(12);
        root.right.left.right = new TreeNode4(13);
        root.right.right.left = new TreeNode4(14);
        root.right.right.right = new TreeNode4(15);
        return root;
    }
}