package com.leetcode.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 */
public class FindMedianFromDataStream_295_Hard2 {
    PriorityQueue<Integer> maxQueue = null;
    PriorityQueue<Integer> minQueue = null;
    public FindMedianFromDataStream_295_Hard2() {
        maxQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        minQueue = new PriorityQueue<Integer>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        if (maxQueue.size() == minQueue.size()) {
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        } else {
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        int size = maxQueue.size() + minQueue.size();
        int remainder = size % 2;
        //int consult = size / 2;
        int zero = 0;
        if (zero == remainder) {
            return ((double)minQueue.peek() + (double)maxQueue.peek())/2;
        } else {
            return (double)maxQueue.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream_295_Hard2 obj = new FindMedianFromDataStream_295_Hard2();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

}