package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 287. Find the Duplicate Number  https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=study-plan-v2&envId=selected-coding-interview
 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。

 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。

 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。



 示例 1：

 输入：nums = [1,3,4,2,2]
 输出：2
 示例 2：

 输入：nums = [3,1,3,4,2]
 输出：3
 示例 3 :

 输入：nums = [3,3,3,3,3]
 输出：3




 提示：

 1 <= n <= 105
 nums.length == n + 1
 1 <= nums[i] <= n
 nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次


 进阶：

 如何证明 nums 中至少存在一个重复的数字?
 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 */
public class FindTheDuplicateNumber_287_Medium {

    public int findDuplicate(int[] nums) {
        int temp = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            index = nums[temp];
            if (index == -1) {
                return temp;
            }
            temp = nums[index];
            nums[index] = -1;
            if (temp == -1) {
                return index;
            }
        }
        return -1;
    }

    @Test
    public void useCase01() {
        int[] nums = {1,3,4,2,2};
        int result = findDuplicate(nums);
        Assert.assertEquals(2, result);
    }

    @Test
    public void useCase02() {
        int[] nums = {3,1,3,4,2};
        int result = findDuplicate(nums);
        Assert.assertEquals(3, result);
    }

    @Test
    public void useCase03() {
        int[] nums = {3,3,3,3,3};
        int result = findDuplicate(nums);
        Assert.assertEquals(3, result);
    }

    @Test
    public void useCase04() {
        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        int result = findDuplicate(nums);
        Assert.assertEquals(9, result);
    }

}
