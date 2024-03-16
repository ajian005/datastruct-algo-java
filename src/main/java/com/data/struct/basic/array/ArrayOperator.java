package com.data.struct.basic.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数字基本操作
 */
public class ArrayOperator {
    /**
     * 找出数组中最大的元素
     */
    public double maxValueByArray(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 计算数组元素的平均值
     */
    public double average(double[] array) {
        int n = array.length;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        double average = sum / n;
        return average;
    }

    /**
     * 复制数组
     */
    public double[] copyArray(double[] array) {
        int n = array.length;
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            b[i] = array[i];
        }
        return b;
    }

    /**
     * 颠倒数组元素的顺序
     */
    public double[]  reverseArray(double[] array) {
        int n = array.length;
        for (int i = 0; i < n/2; i++) {
            double temp = array[i];
            array[i] = array[n-1-i];
            array[n-1-i] = temp;
        }
        return array;
    }

    /**
     * 矩阵相乘(方阵)
     * a[][] * b[][] = c[][]
     */
    public double[][] multiplication(double[][] a, double[][] b){
        int n = a.length;
        double[][] c = new double[2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 计算行i和列j的点乘
                for (int k = 0; k < n; k++) {
                    c[i][j] +=a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    @Test
    public void testcase1_multiplication() {
        double[][] a = {{1,2}, {3,4}};
        double[][] b = {{3,7}, {5,6}};
        double[][] c = multiplication(a,b);
        double d = 1.0;
        Assert.assertEquals("矩阵相乘(方阵) a[][] * b[][] = c[][]", d, c[0][0]);
        Assert.assertEquals("矩阵相乘(方阵) a[][] * b[][] = c[][] ", 1, c[0][0]);
    }







}