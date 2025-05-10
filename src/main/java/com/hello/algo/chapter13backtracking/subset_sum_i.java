package com.hello.algo.chapter13backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法：子集和 I
 */
public class subset_sum_i {

    /* 回溯算法：子集和 I */
    static void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack(state, target - choices[i], choices, i, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }


    /* 求解子集和 I */
    static List<List<Integer>> subsetSumI(int[] nums, int target) {
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        Arrays.sort(nums); // 对 nums 进行排序
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, nums, start, res);
        return res;
    }


    @Test
    public void useCase01() {
        int[] nums = { 3, 4, 5 };
        int target = 9;

        List<List<Integer>> res = subsetSumI(nums, target);

        System.out.println("输入数组 nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("所有和等于 " + target + " 的子集 res = " + res);
    }
}
