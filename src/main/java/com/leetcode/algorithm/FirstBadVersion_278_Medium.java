package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 278. First Bad Version https://leetcode.cn/problems/first-bad-version/description/?envType=study-plan-v2&envId=selected-coding-interview
 You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

 Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

 Example 1:
 Input: n = 5, bad = 4
 Output: 4
 Explanation:
 call isBadVersion(3) -> false
 call isBadVersion(5) -> true
 call isBadVersion(4) -> true
 Then 4 is the first bad version.

 Example 2:
 Input: n = 1, bad = 1
 Output: 1

 Constraints:

 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion_278_Medium {
    public int firstBadVersion(int n) {
        if (n <=1) {
            boolean booleanValue = isBadVersion(n);
            if (booleanValue) {
                return n;
            } else {
                return -1;
            }
        }
        int badVersion = binarySearch(1, n);
        return badVersion;
    }

    public int binarySearch(int left, int right) {
        int mid = left + (right - left)/2;
        if (left == right) {
            boolean booleanValue = isBadVersion(mid);
            if (booleanValue) {
                return mid;
            } else {
                return -1;
            }
        }
        boolean returnValue = isBadVersion(mid);
        if (returnValue && (mid-1 >= left) && !isBadVersion(mid-1)) {
            return mid;
        } else if (!returnValue && (mid-1 >= left) && isBadVersion(mid-1)) {
            return mid-1;
        }
        // 在左半侧
        if (returnValue) {
            return  binarySearch(left, mid);
        } else {
            // 在右半侧
            return  binarySearch(mid+1, right);
        }
    }

    int BAD_VERSION = -1;

    boolean isBadVersion(int version){
        if (version >= BAD_VERSION) {
            return  true;
        }
        return false;
    }

    @Test
    public void useCase01() {
        BAD_VERSION = 4;
        int badVersion = firstBadVersion(5);
        Assert.assertEquals(BAD_VERSION, badVersion);
    }

    @Test
    public void useCase02() {
        BAD_VERSION = 1;
        int badVersion = firstBadVersion(1);
        Assert.assertEquals(BAD_VERSION, badVersion);
    }

    @Test
    public void useCase03() {
        BAD_VERSION = 2;
        int badVersion = firstBadVersion(2);
        Assert.assertEquals(BAD_VERSION, badVersion);
    }
}