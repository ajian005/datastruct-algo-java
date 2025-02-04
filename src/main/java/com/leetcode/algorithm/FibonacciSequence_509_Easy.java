package com.leetcode.algorithm;

import org.junit.Test;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * https://leetcode.cn/problems/fibonacci-number/description/
 * 普通递归 -> dp剪枝 -> 优化空间
 * native recursion --> memoization --> dp
 *
 * 类似题目:
 * LCR 126. 斐波那契数  https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/description/
 */
public class FibonacciSequence_509_Easy {
    /**
     * 斐波那契数 方法二：矩阵快速幂
     * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/solutions/976888/fei-bo-na-qi-shu-lie-by-leetcode-solutio-hbss/
     * 复杂度分析:
     *    时间复杂度：O(logn)。
     *    空间复杂度：O(1)。
     */
    @Test
    public void testFib6() {
        int fibValue = fib6(100);
        System.out.println(fibValue);
    }
        static final int MOD = 1000000007;

        public int fib6(int n) {
            if (n < 2) {
                return n;
            }
            int[][] q = {{1, 1}, {1, 0}};
            int[][] res = pow(q, n - 1);
            return res[0][0];
        }

        public int[][] pow(int[][] a, int n) {
            int[][] ret = {{1, 0}, {0, 1}};
            while (n > 0) {
                if ((n & 1) == 1) {
                    ret = multiply(ret, a);
                }
                n >>= 1;
                a = multiply(a, a);
            }
            return ret;
        }

        public int[][] multiply(int[][] a, int[][] b) {
            int[][] c = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
                }
            }
            return c;
        }
    /**
     * 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
     */
    @Test
    public void testFib5() {
        int fibValue = fib5(100);
        System.out.println(fibValue);
    }

    public int fib5(int n) {
        int mod = 1000000007;
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = a + b;
            sum = sum % mod;
            a = b;
            b = sum;
        }
        return a;
    }


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