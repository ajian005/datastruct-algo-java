package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * 提示:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 *
 * 方法一：递归
 * 思路
 *
 * 对于任意一颗树而言，前序遍历的形式总是
 *
 * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
 * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
 *
 * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
 * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
 *
 * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
 *
 *细节
 *在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，但这样做的时间复杂度较高。我们可以考虑使用哈希表来帮助我们快速地定位根节点。对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。在构造二叉树的过程之前，我们可以对中序遍历的列表进行一遍扫描，就可以构造出这个哈希映射。在此后构造二叉树的过程中，我们就只需要 O(1)O(1)O(1) 的时间对根节点进行定位了。
 */
public class PreOrderAndInOrderBuildBinaryTree_105_Medium {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildBinaryTree(int[] preOrder, int[] inOrder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        // 已经完成
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preOrderRoot = preOrderLeft;
        // 在中序遍历中定位根节点
        int inOrderRoot = indexMap.get(preOrder[preOrderRoot]);

        // 先把根节点建立起来
        TreeNode root = new TreeNode(preOrder[preOrderRoot]);
        // 得到左子树中的节点数目
        int sizeLeftSubTree = inOrderRoot - inOrderLeft;
        // 递归第构造左子树，并连接到根节点
        // 先序遍历中「从左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildBinaryTree(preOrder, inOrder, preOrderLeft + 1, preOrderLeft + sizeLeftSubTree, inOrderLeft, inOrderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildBinaryTree(preOrder, inOrder, preOrderLeft + sizeLeftSubTree + 1, preOrderRight, inOrderRoot + 1, inOrderRight);
        return root;
    }

    /**
     * 从前序与中序遍历序列构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildBinaryTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    /**
     * 示例 1:
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     */
    @Test
    public void testcase1_buildTree() {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = buildTree(preOrder, inOrder);
        Assert.assertEquals("root", 3, root.val);
    }

    /**
     * 示例 2:
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     */
    @Test
    public void testcase2_buildTree() {
        int[] preOrder = {-1};
        int[] inOrder = {-1};
        TreeNode root = buildTree(preOrder, inOrder);
        Assert.assertEquals("root.val", -1, root.val);
    }

}