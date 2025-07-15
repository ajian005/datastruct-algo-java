package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * 50. Pow(x, n)    https://leetcode.cn/problems/powx-n/description/?envType=study-plan-v2&envId=selected-coding-interview
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -104 <= xn <= 104
 */
public class Pow_50_Medium {

    public double myPow(double x, int n) {
        long N = n;
        return n > 0 ? quickMul(x, N) : 1.0/quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N/2);
        return (N % 2 == 0) ? y * y : y * y * x;
    }

    @Test
    public void useCase01() {
        double result = myPow(2.00000, 10);
        double expected = 1024.00000;
        Assert.assertEquals(expected, result, 0.1);
    }

    @Test
    public void useCase02() {
        double result = myPow(2.10000, 3);
        double expected = 9.261000;
        Assert.assertEquals(expected, result, 0.1);
    }

    @Test
    public void useCase03() {
        double result = myPow(2.00000, -2);
        double expected = 0.25000;
        Assert.assertEquals(expected, result, 0.1);
    }
}
