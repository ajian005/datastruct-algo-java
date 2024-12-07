package com.leetcode.algorithm;

import org.junit.Test;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * https://leetcode.cn/problems/fibonacci-number/description/
 */
public class FibonacciSequence_509_Easy {
    /**
     * 动态规划 dp状态压缩：
     * 509. 斐波那契数（动态规划，清晰图解）
     * https://leetcode.cn/problems/fibonacci-number/solutions/2361746/509-fei-bo-na-qi-shu-dong-tai-gui-hua-qi-so8h/
     */
    @Test
    public void testFib4() {
        int fibValue = fib4(7);
        System.out.println(fibValue);
    }

    public int fib4(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 动态规划
     * dp 数组的迭代解法
     */
    @Test
    public void testFib3() {
        int fibValue = fib3(7);
        System.out.println(fibValue);
    }

    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int [] dp = new int [n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    /**
     * 带备忘录的递归解法
     */
    @Test
    public void testFib2() {
        int fibValue = fib2(7);
        System.out.println(fibValue);
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 备忘录全初始化为0
        int [] memo = new int [n + 1];
        int res = helper(memo, n);
        return res;
    }

    int helper(int [] memo, int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 已经计算过
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 暴力递归法
     */
    @Test
    public void testFib() {
        int fibValue = fib(7);
        System.out.println(fibValue);
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fibN = fib(n-1) + fib(n-2);
        return fibN;
    }
}