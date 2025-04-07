package com.leetcode.algorithm;

import java.text.Collator;
import java.util.*;

/**
 15. 3Sum
 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 Notice that the solution set must not contain duplicate triplets.

 Example 1:
 Input: nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]

 Explanation:
 nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 The distinct triplets are [-1,0,1] and [-1,-1,2].

 Notice that the order of the output and the order of the triplets does not matter.

 Example 2:
 Input: nums = [0,1,1]
 Output: []
 Explanation: The only possible triplet does not sum up to 0.

 Example 3:
 Input: nums = [0,0,0]
 Output: [[0,0,0]]
 Explanation: The only possible triplet sums up to 0.

 Constraints:
    3 <= nums.length <= 3000
 -105 <= nums[i]     <= 105

 */
public class Sum3_15_Medium {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> listSet = new HashSet<>();
        int length = nums.length;
        int x = 0;
        for (int i = x; i < length; i++) {
            for (int j = x+1; j < length; j++) {
                for (int k = x+2; k < length; k++) {
                List<Integer> threeSum = new ArrayList<>();
                    if ((nums[i] + nums[j] + nums[k] == 0) && (i != j) && (i != k) && (j != k )) {
                        threeSum.add(nums[i]);
                        threeSum.add(nums[j]);
                        threeSum.add(nums[k]);
                        threeSum.sort(Comparator.naturalOrder());
                        listSet.add(threeSum);
                    }
                }
            }
        }
        Iterator iterator = listSet.iterator();
        List<List<Integer>> listList = new ArrayList<>();
        while (iterator.hasNext()) {
            List<Integer> threeSum =  (List<Integer>)iterator.next();
            listList.add(threeSum);
        }
        return listList;
    }

    public static void main(String[] args) {
        useCase1();
        useCase2();
        useCase3();
    }

    private static void useCase1() {
        Sum3_15_Medium obj = new Sum3_15_Medium();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(obj.threeSum(nums));
    }

    private static void useCase2() {
        Sum3_15_Medium obj = new Sum3_15_Medium();
        int[] nums = {0,1,1};
        System.out.println(obj.threeSum(nums));
    }

    private static void useCase3() {
        Sum3_15_Medium obj = new Sum3_15_Medium();
        int[] nums = {0,0,0};
        System.out.println(obj.threeSum(nums));
    }
}