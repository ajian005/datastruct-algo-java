package com.hello.algo.chapter13backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
 * 13.1 回溯算法 https://www.hello-algo.com/chapter_backtracking/backtracking_algorithm/
 * 例题一:给定一棵二叉树，搜索并记录所有值为7的节点，请返回节点列表。
 * 对于此题，我们前序遍历这棵树，并判断当前节点的值是否为 若是，则将该节点的值加入结果列表 res 之中。
 */
public class Preorder_traversal_i_compact {
    private List<TreeNode> res;
    /* 前序遍历：例题一 */
    private void preOrder(TreeNode root, int targetValue) {
        if (root == null) {
            return;
        }
        if (root.val == targetValue) {
            res.add(root);
        }
        preOrder(root.left, targetValue);
        preOrder(root.right, targetValue);
    }



    @Test
    public void useCase01() {
        TreeNode node = constructTree();
        // 前序遍历
        res = new ArrayList<>();
        preOrder(node, 7);

        System.out.println("\n输出所有值为 7 的节点");
        List<Integer> vals = new ArrayList<>();
        for (TreeNode nodeTemp : res) {
            vals.add(nodeTemp.val);
        }
        System.out.println(vals);
    }

    @Test
    public void useCase02() {
        TreeNode node = constructTree();
        // 前序遍历
        res = new ArrayList<>();
        preOrder(node, 17);

        System.out.println("\n输出所有值为 7 的节点");
        List<Integer> vals = new ArrayList<>();
        for (TreeNode nodeTemp : res) {
            vals.add(nodeTemp.val);
        }
        System.out.println(vals);
    }


    public TreeNode constructTree() {
        // 第一层
        TreeNode root = new TreeNode(1);

        // 第二层
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 第三层
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 第四层
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        return root;
    }
}