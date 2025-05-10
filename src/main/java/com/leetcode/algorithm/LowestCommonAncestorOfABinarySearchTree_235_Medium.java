package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree  https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=study-plan-v2&envId=selected-coding-interview
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 */
public class LowestCommonAncestorOfABinarySearchTree_235_Medium {
    Map<Integer, TreeNode3> parents = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public TreeNode3 lowestCommonAncestor(TreeNode3 root, TreeNode3 p, TreeNode3 q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parents.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q =  parents.get(q.val);
        }
        return null;
    }

    /**
     * 二叉树深度遍历
     * @param root
     */
    public void dfs(TreeNode3 root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parents.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            dfs(root.right);
        }
    }

    @Test
    public void useCase001() {
        TreeNode3 node3 = constructTree();
        TreeNode3 node = lowestCommonAncestor(node3,new TreeNode3(9), new TreeNode3(15));
        Assert.assertEquals(1, node.val);
    }

    @Test
    public void useCase002() {
        TreeNode3 node3 = constructTree();
        TreeNode3 node = lowestCommonAncestor(node3,new TreeNode3(8), new TreeNode3(9));
        Assert.assertEquals(4, node.val);
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
