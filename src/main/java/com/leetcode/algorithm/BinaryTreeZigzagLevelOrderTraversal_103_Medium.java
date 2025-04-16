package com.leetcode.algorithm;

/**
 * 103. 二叉树的锯齿形层序遍历 https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/?envType=study-plan-v2&envId=selected-coding-interview
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 */

import org.junit.Test;

import java.util.*;

class TreeNode2{
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode2() {}
      TreeNode2(int val) { this.val = val; }
      TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class BinaryTreeZigzagLevelOrderTraversal_103_Medium {
    /**
     * 树深度遍历
     * @param root
     */
     public void deepTraversal(TreeNode2 root) {
        if (root == null) {
            return;
        }
        // root前序遍历
        System.out.println(root.val);
        deepTraversal(root.left);
        // root中序遍历
        deepTraversal(root.right);
        // root后序遍历
     }

    /**
     * 树层序遍历
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode2 root) {
        List<List<Integer>> valueList = new ArrayList<List<Integer>>();
        if (root == null) {
            return valueList;
        }
        // 初始化队列，加入根节点
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode2 node2 = queue.poll();
                level.add(node2.val);
                if (node2.left != null) {
                    queue.offer(node2.left);
                }
                if (node2.right != null) {
                    queue.offer(node2.right);
                }
            }
            valueList.add(level);

        }
        System.out.println(valueList);
        return valueList;
    }

    /**
     * 二叉树的锯齿形层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode2 root) {
        List<List<Integer>> valueList = new ArrayList<List<Integer>>();
        if (root == null) {
            return valueList;
        }
        // 初始化队列，加入根节点
        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        int j = 0;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode2 node2 = queue.poll();
                level.add(node2.val);
                if (node2.left != null) {
                    queue.offer(node2.left);
                }
                if (node2.right != null) {
                    queue.offer(node2.right);
                }
            }
            j++;
            if (j % 2 == 0) {
                Collections.reverse(level);
            }
            valueList.add(level);
        }
        //System.out.println(valueList);
        return valueList;
    }

    @Test
    public void useCase001() {
        TreeNode2 node2 = constructTree();
        List<List<Integer>> listTemp = zigzagLevelOrder(node2);
        System.out.println("listTemp=" + listTemp);
    }


    @Test
    public void useCase0010(){
         TreeNode2 node2 = constructTree();
         deepTraversal(node2);
     }

    @Test
    public void useCase0011(){
        TreeNode2 node2 = constructTree();
        levelOrderTraversal(node2);
    }

    public  TreeNode2 constructTree() {
        // 第一层
        TreeNode2 root = new TreeNode2(1);

        // 第二层
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);

        // 第三层
        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);
        root.right.left = new TreeNode2(6);
        root.right.right = new TreeNode2(7);

        // 第四层
        root.left.left.left = new TreeNode2(8);
        root.left.left.right = new TreeNode2(9);
        root.left.right.left = new TreeNode2(10);
        root.left.right.right = new TreeNode2(11);
        root.right.left.left = new TreeNode2(12);
        root.right.left.right = new TreeNode2(13);
        root.right.right.left = new TreeNode2(14);
        root.right.right.right = new TreeNode2(15);
        return root;
    }
}