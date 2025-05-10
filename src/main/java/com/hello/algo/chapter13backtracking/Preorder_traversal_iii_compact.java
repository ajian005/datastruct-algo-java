package com.hello.algo.chapter13backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 13.1 回溯算法 https://www.hello-algo.com/chapter_backtracking/backtracking_algorithm/
 * 例题三: 在二叉树中搜索所有值为7的节点，请返回根节点到这些节点的路径，并要求路径中不包含值为3的节点。
 * 对于此题，我们前序遍历这棵树，并判断当前节点的值是否为 若是，则将该节点的值加入结果列表 res 之中。
 */
public class Preorder_traversal_iii_compact {
    private List<TreeNode> path;
    private List<List<TreeNode>> res;

    /* 前序遍历：例题三 */
    private void preOrder(TreeNode root, int targetValue) {
        if (root == null || root.val == 3) {
            return;
        }
        // 尝试
        path.add(root);
        //
        if (root.val == targetValue) {
            // 记录解
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left, targetValue);
        preOrder(root.right, targetValue);
        // 回退
        path.remove(path.size()-1);
    }

    @Test
    public void useCase01() {
        path = new ArrayList<>();
        res = new ArrayList<>();

        TreeNode node = constructTree();
        // 前序遍历
        res = new ArrayList<>();
        preOrder(node, 7);

        //System.out.println("\n输出所有值为 7 的节点");
        List<List<TreeNode>> vals = new ArrayList<>();
        System.out.println("\n输出所有根节点到节点 7 的路径，路径中不包含值为 3 的节点");
        for (List<TreeNode> path : res) {
            List<Integer> vals2 = new ArrayList<>();
            for (TreeNode node2 : path) {
                vals2.add(node2.val);
            }
            System.out.println(vals2);
        }
    }

    @Test
    public void useCase02() {
        path = new ArrayList<>();
        res = new ArrayList<>();
        TreeNode node = constructTree();
        // 前序遍历
        res = new ArrayList<>();
        preOrder(node, 17);

        System.out.println("\n输出所有值为 17 的节点");
        List<List<TreeNode>> vals = new ArrayList<>();
        for (List<TreeNode> nodeTemp : res) {
            //vals.add(nodeTemp);
            System.out.println(" ");
            for (TreeNode node2 : nodeTemp) {
                System.out.print(node2.val);
            }
        }
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