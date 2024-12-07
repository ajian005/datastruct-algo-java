package com.leetcode.algorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * 322. 零钱兑换 https://leetcode.cn/problems/coin-change/description/
 * 题解: Java 递归、记忆化搜索、动态规划 https://leetcode.cn/problems/coin-change/solutions/137661/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
 * Java 递归
 */
public class CoinChange_322_Medium {
    /**
     * 动态规划2
     * 官方答案 零钱兑换 https://leetcode.cn/problems/coin-change/solutions/132979/322-ling-qian-dui-huan-by-leetcode-solution/
     */
    @Test
    public void testCoinChange4_dynamicProgram() {
        int [] coins = {1, 2, 3};
        int res3 = coinChangeDynamicProgram(coins, 500000);
        System.out.println(res3);
    }

    /**
     * coinChangeDynamicProgram
     * 动态规划
     */
    public int coinChangeDynamicProgram(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                // 只考虑金额大于或等于零的
                if (i-coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 动态规划1
     * 动态规划从 memo[0] 开始，从下到上
     */
    @Test
    public void testCoinChange3() {
        int [] coins = {1, 2, 3};
        int res3 = coinChange3(coins, 500000);
        System.out.println(res3);
    }
    public int coinChange3(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo1 = new int[amount+1];
        memo1[0] = 0;
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0 && memo1[i-coins[j]] < min){
                    min = memo1[i-coins[j]] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo1[i] = min;
        }
        return memo1[amount] == Integer.MAX_VALUE ? -1 : memo1[amount];
    }


    /**
     * 记忆化搜索  ========================================================================
     */
    @Test
    public void testCoinChange2() {
        int [] coins = {1, 2, 3};
        int res2 = coinChange2(coins, 500);
        System.out.println(res2);
    }
    int[] memo;
    public int coinChange2(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return findWay2(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay2(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = findWay2(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }


    /**
     * Java 递归版 -=============================================
     */
    int res = Integer.MAX_VALUE;
    @Test
    public void testCoinChange() {
        int [] coins = {1, 2, 3};
        coinChange(coins, 20);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }

        findWay(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    /**
     *
     * @param coins  表示不同面额的硬币
     * @param amount 表示总金额
     * @param count  凑成总金额所需的 最少的硬币个数  如果没有任何一种硬币组合能组成总金额，返回 -1 。
     */
    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res, count);
        }

        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }

}
