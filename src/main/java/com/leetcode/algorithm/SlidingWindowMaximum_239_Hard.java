package com.leetcode.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 239. Sliding Window Maximum
 You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
 the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 Return the max sliding window.

 Example 1:
 Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 Output: [3,3,5,5,6,7]
 Explanation:
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7      3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 Example 2:
 Input: nums = [1], k = 1
 Output: [1]

 Constraints:
 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 1 <= k <= nums.length
 */
public class SlidingWindowMaximum_239_Hard {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int leftPoint = 0; int rightPointer = k-1;
        int[] result = new int[nums.length-k+1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0]-o1[0] : o2[1]-o1[1];
            }
        });

        for (int j = leftPoint; j <= rightPointer; j++) {
            priorityQueue.offer(new int[] {nums[j], j});
        }
        int m = 1;
        result[0] = priorityQueue.peek()[0];
        for (int i =k; i < nums.length; i++) {
            priorityQueue.offer(new int[] {nums[i], i});
            leftPoint++;
            while (priorityQueue.peek()[1] < leftPoint) {
                priorityQueue.poll();
            }
            int max = priorityQueue.peek()[0];
            result[m++] = max;
        }
        return result;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int leftPoint = 0; int rightPointer = k-1;
        int[] result = new int[nums.length-k+1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int j = leftPoint; j < rightPointer; j++) {
            priorityQueue.offer(nums[j]);
        }
        int m = 0;
        for (int i =0; i < nums.length; i++) {
            if (rightPointer < nums.length) {
                priorityQueue.offer(nums[rightPointer]);
                rightPointer++;

                int max = priorityQueue.peek();
                result[m++] = max;

                priorityQueue.remove(nums[leftPoint]);
                leftPoint++;
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int leftPoint = 0; int rightPointer = k-1;
        int[] result = new int[nums.length-k+1];
        int m = 0;
        for (int i =0; i < nums.length ; i++) {
            if (rightPointer < nums.length) {
                //System.out.println("leftPointer=" + leftPoint + "rightPointer=" + rightPointer);
                int max = Integer.MIN_VALUE;
                for (int j = leftPoint; j <= rightPointer; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                    }
                }
                result[m++] = max;
                //System.out.println("max=" + max);
                leftPoint++;
                rightPointer++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //useCase01();
        useCase02();
        //useCase03();
    }

    private static void useCase01() {
        SlidingWindowMaximum_239_Hard obj = new SlidingWindowMaximum_239_Hard();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int [] result = obj.maxSlidingWindow(nums, k);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i < (result.length - 1)) {
                System.out.print(result[i]+",");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.print("]");
    }

    private static void useCase02() {
        SlidingWindowMaximum_239_Hard obj = new SlidingWindowMaximum_239_Hard();
        int[] nums = {1};
        int k = 1;
        int [] result = obj.maxSlidingWindow(nums, k);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i < (result.length - 1)) {
                System.out.print(result[i]+",");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.print("]");
    }

    private static void useCase03() {
        SlidingWindowMaximum_239_Hard obj = new SlidingWindowMaximum_239_Hard();
        int[] nums = {1,-1};
        int k = 1;
        int [] result = obj.maxSlidingWindow(nums, k);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i < (result.length - 1)) {
                System.out.print(result[i]+",");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.print("]");
    }
}