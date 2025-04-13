package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 59. Spiral Matrix II   https://leetcode.cn/problems/spiral-matrix-ii/description/?envType=study-plan-v2&envId=selected-coding-interview
 Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



 Example 1:
 Input: n = 3
 Output: [[1,2,3],[8,9,4],[7,6,5]]


 Example 2:
 Input: n = 1
 Output: [[1]]


 Constraints:
 1 <= n <= 20

 */
public class SpiralMatrixII_59_Medium {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rows = n;
        int columns = n;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        int k = 0;
        while (left <= right && top <= bottom) {
            // 从左到右遍历上侧元素，依次为 (top,left) 到 (top,right)。
            for (int column = left; column <= right; column++) {
                matrix[top][column] = ++k;
            }
            // 从上到下遍历右侧元素，依次为 (top+1,right) 到 (bottom,right)。
            for (int row = top+1; row <= bottom; row++) {
                matrix[row][right] = ++k;
            }
            // 如果 left<right 且 top<bottom，则从右到左遍历下侧元素，依次为 (bottom,right−1) 到 (bottom,left+1)，
            // 以及从下到上遍历左侧元素，依次为 (bottom,left) 到 (top+1,left)。
            if (left < right && top < bottom) {
                // 从右到左遍历下侧元素，依次为 (bottom,right−1) 到 (bottom,left+1)
                for (int column = right-1; column > left; column-- ) {
                    matrix[bottom][column] = ++k;
                }
                // 从下到上遍历左侧元素，依次为 (bottom,left) 到 (top+1,left)
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = ++k;
                }
            }
            //遍历完当前层的元素之后，将 left 和 top 分别增加 1，将 right 和 bottom 分别减少 1，进入下一层继续遍历，直到遍历完所有元素为止。
            left++;
            top++;
            right--;
            bottom--;
        }
        return matrix;
    }

    @Test
    public void useCase01() {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        int[][] matrixTemp = {{1,2,3},{8,9,4},{7,6,5}};
        Assert.assertArrayEquals("矩阵是否相等", matrixTemp, matrix);
    }

    @Test
    public void useCase02() {
        int n = 1;
        int[][] matrix = generateMatrix(n);
        int[][] matrixTemp = {{1}};
        Assert.assertArrayEquals("矩阵是否相等", matrixTemp, matrix);
    }

}