package com.hello.algo.chapter13backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法：全排列 I
 */
public class permutations_i {

    /**
     * 回溯算法：全排列 I
     * @return
     */
    public void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> resp) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            resp.add(new ArrayList<Integer>(state));
        }
        // 遍历所有选择
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素
            if (!selected[i]) {
                // 尝试：做出选择，更新状态
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack(state, choices, selected, resp);
                // 回退：撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size()-1);
            }
        }
    }


    public List<List<Integer>> permutationsI(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }

    @Test
    public void useCase01() {
        int[] nums = { 1, 2, 3 };

        List<List<Integer>> res = permutationsI(nums);

        System.out.println("输入数组 nums = " + Arrays.toString(nums));
        System.out.println("所有排列 res = " + res);
    }

}