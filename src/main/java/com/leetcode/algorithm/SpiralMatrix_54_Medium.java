package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
  54. Spiral Matrix https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=selected-coding-interview
  Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100



 */
public class SpiralMatrix_54_Medium {
    /**
     * 可以将矩阵看成若干层，首先输出最外层的元素，其次输出次外层的元素，直到输出最内层的元素。
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = columns - 1;
        List<Integer> list = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // 从左到右遍历上侧元素，依次为 (top,left) 到 (top,right)。
            for (int column = left; column <= right; column++) {
                list.add(matrix[top][column]);
            }
            // 从上到下遍历右侧元素，依次为 (top+1,right) 到 (bottom,right)。
            for (int row = top+1; row <= bottom; row++) {
                list.add(matrix[row][right]);
            }
            // 如果 left<right 且 top<bottom，则从右到左遍历下侧元素，依次为 (bottom,right−1) 到 (bottom,left+1)，
            // 以及从下到上遍历左侧元素，依次为 (bottom,left) 到 (top+1,left)。
            if (left < right && top < bottom) {
                // 从右到左遍历下侧元素，依次为 (bottom,right−1) 到 (bottom,left+1)
                for (int column = right-1; column >= left + 1; column--) {
                    list.add(matrix[bottom][column]);
                }
                // 从下到上遍历左侧元素，依次为 (bottom,left) 到 (top+1,left)
                for (int row = bottom; row >= top + 1; row--) {
                    list.add(matrix[row][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return list;
    }

    @Test
    public void useCase01() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralOrder(matrix);
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(9);
        arrayList.add(8);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(5);
        Assert.assertTrue("矩阵是否相等", arrayList.equals(result));
    }

    @Test
    public void useCase02() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(12);
        arrayList.add(11);
        arrayList.add(10);
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        Assert.assertTrue("矩阵是否相等", arrayList.equals(result));
    }
}