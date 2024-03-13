package com.data.struct.basic.maths;

import org.junit.Assert;
import org.junit.Test;

/**
 * 《算法第4版》第1章基础
 * 递归定义
 * 计算两个非负整数p和q的最大公约数:
 * 若q是0，则最大公约数为P.
 * 否则，将p除以q得到余数r, p和q的最大公约数即为q和r的最大公约数。
 */
public class gcd {
    public int gcd (int p, int q) {
        if (q == 0) {
            return p;
        } else {
            int r = p % q;
            int zi = gcd(q, r);
            return zi;
        }
    }

    @Test
    public void testCase1_gcd() {
       int gcdValue = gcd(5, 0);
        Assert.assertEquals("计算两个非负整数p和q的最大公约数", 5, gcdValue);
    }

    @Test
    public void testCase2_gcd() {
        int gcdValue = gcd(9, 3);
        Assert.assertEquals("计算两个非负整数p和q的最大公约数", 3, gcdValue);
    }

    @Test
    public void testCase3_gcd() {
        int gcdValue = gcd(10, 3);
        Assert.assertEquals("计算两个非负整数p和q的最大公约数", 1, gcdValue);
    }

    @Test
    public void testCase4_gcd() {
        int gcdValue = gcd(15, 3);
        Assert.assertEquals("计算两个非负整数p和q的最大公约数", 3, gcdValue);
    }

    @Test
    public void testCase5_gcd() {
        int gcdValue = gcd(12, 16);
        Assert.assertEquals("计算两个非负整数p和q的最大公约数", 4, gcdValue);
    }
}