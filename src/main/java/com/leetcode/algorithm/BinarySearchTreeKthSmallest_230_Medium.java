package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点root和一个整数k，请你设计一个算法查找其中第k个最小元素（从1开始计数）。
 *
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 * 二叉搜素数:二叉查找树（Binary Search Tree）:（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。二叉搜索树作为一种经典的数据结构，它既有链表的快速插入与删除操作的特点，又有数组快速查找的优势；
 * 所以应用十分广泛，例如在文件系统和数据库系统一般会采用这种数据结构进行高效率的排序与检索操作。 [1]
 *
 * 成员变量+中序遍历 哈哈
 */
public class BinarySearchTreeKthSmallest_230_Medium {
    /**
     *  * 示例 1：
     *  * 输入：root = [3,1,4,null,2], k = 1
     *  * 输出：1
     */
    @Test
    public void testcase1_kthSmallest() {
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node1, node4);
        int k = kthSmallest(node3, 1);
        Assert.assertEquals("k = 1", 1, k);
    }

    /**
     *  * 示例 2：
     *  * 输入：root = [5,3,6,2,4,null,null,1], k = 3
     *  * 输出：3
     */
    @Test
    public void testcase2_kthSmallest() {
        TreeNode node1 = new TreeNode(1, null, null);

        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4, null, null);

        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(3, node3, node6);
        int k = kthSmallest(node5, 3);
        Assert.assertEquals("k = 3", 3, k);
    }


    private int index=0;
    private TreeNode ans;

    public int kthSmallest(TreeNode root, int k) {
        midRead(root,k);
        return ans.val;
    }

    private void midRead(final TreeNode root, int k) {
        if(root==null){
            return;
        }
        midRead(root.left,k);
        if(++index==k){
            ans=root;
            return;
        }
        midRead(root.right,k);
    }
}