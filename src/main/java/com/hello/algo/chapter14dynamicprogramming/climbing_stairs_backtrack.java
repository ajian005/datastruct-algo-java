package com.hello.algo.chapter14dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class climbing_stairs_backtrack {
    /**
     * 回溯
     */
    static void  backtrack(List<Integer> choices, int state, int n, List<Integer> res) {
        // 当爬到第n阶时，方案数量加1
        if (state == n) {
            res.set(0, res.get(0) + 1);
        }
        // 遍历所有选择
        for (Integer choice : choices) {
            // 剪枝：不允许越过第n阶
            if (state + choice > n) {
                continue;
            }
            // 尝试: 做出选择，更新状态
            backtrack(choices, state + choice, n, res);
            // 回退
        }
    }

    /**
     * 爬楼梯: 回溯
     */
    static int climbingStairsBacktrack(int n) {
        List<Integer>  choices = Arrays.asList(1, 2, 3);  // 可选择向上爬1阶 或 2阶
        int state = 0;  // 从第0阶开始爬
        List<Integer>  res = new ArrayList<>();
        res.add(0);     // 使用 res[0] 记录方案数量
        backtrack(choices, state, n, res);
        return res.get(0);
    }

    public static void main(String[] args) {
        int n = 19;
        int res = climbingStairsBacktrack(n);
        System.out.println(String.format("爬 %d 阶楼梯共有 %d 种方案", n, res));
    }

}