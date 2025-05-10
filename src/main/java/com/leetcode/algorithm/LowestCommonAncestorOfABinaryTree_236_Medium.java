package com.leetcode.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 236. Lowest Common Ancestor of a Binary Tree  https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=selected-coding-interview
 *
 */

//Definition for a binary tree node.
class TreeNode3 {
   int val;
   TreeNode3 left;
   TreeNode3 right;
   TreeNode3(int x) { val = x; }
}

public class LowestCommonAncestorOfABinaryTree_236_Medium {
    private Map<Integer,TreeNode3> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode3 treeNode3) {
        if (treeNode3 == null) {
            return;
        }
        if (treeNode3.left != null) {
            parent.put(treeNode3.left.val, treeNode3);
            dfs(treeNode3.left);

        }
        if (treeNode3.right != null) {
            parent.put(treeNode3.right.val, treeNode3);
            dfs(treeNode3.right);
        }
    }

    @Test
    public void useCase001() {
        TreeNode3 node3 = constructTree();
    }


    public TreeNode3 lowestCommonAncestor(TreeNode3 root, TreeNode3 p, TreeNode3 q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }


    public TreeNode3 lowestCommonAncestor2(TreeNode3 root, TreeNode3 p) {
        if (root == null) {
            return null;
        }
         lowestCommonAncestor2(root.left, p);
         lowestCommonAncestor2(root.right, p);
        if (root.val == p.val) {
            return root;
        }
        return root;
    }


    @Test
    public void useCase01() {
        TreeNode3 node = constructTree();
    }

    public  TreeNode3 constructTree() {
        // 第一层
        TreeNode3 root = new TreeNode3(1);

        // 第二层
        root.left = new TreeNode3(2);
        root.right = new TreeNode3(3);

        // 第三层
        root.left.left = new TreeNode3(4);
        root.left.right = new TreeNode3(5);
        root.right.left = new TreeNode3(6);
        root.right.right = new TreeNode3(7);

        // 第四层
        root.left.left.left = new TreeNode3(8);
        root.left.left.right = new TreeNode3(9);
        root.left.right.left = new TreeNode3(10);
        root.left.right.right = new TreeNode3(11);
        root.right.left.left = new TreeNode3(12);
        root.right.left.right = new TreeNode3(13);
        root.right.right.left = new TreeNode3(14);
        root.right.right.right = new TreeNode3(15);
        return root;
    }

}