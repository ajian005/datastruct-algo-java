package com.leetcode.algorithm;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * 295. Find Median from Data Stream
 */
public class FindMedianFromDataStream_295_Hard {
    private LinkedList<Integer> list = null;
    private boolean isCompute = false;
    public FindMedianFromDataStream_295_Hard() {
        list = new LinkedList<>();
    }

    public void addNum(int num) {
        list.add(num);
        isCompute = true;
    }

    public double findMedian() {
        if (isCompute) {
            list.sort(Comparator.naturalOrder());
            isCompute = false;
        }
        int count = list.size();
        int remainder = count % 2;
        int consult = count / 2;
        int zero = 0;
        if (zero == remainder) {
           return ((double)list.get(consult-1) + (double)list.get(consult))/2;
        } else {
            return (double)list.get(consult);
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream_295_Hard obj = new FindMedianFromDataStream_295_Hard();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

}