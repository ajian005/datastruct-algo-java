package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 LeetCode 266. 回文排列这道题的需求如下：
 题目描述
 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。

     示例
     示例 1：
     输入: "code"
     输出: false
     解释：字符串 "code" 无论怎么重新排列都无法形成回文串。

     示例 2：
     输入: "aab"
     输出: true
     解释：字符串 "aab" 可以重新排列为 "aba"，是一个回文串。

     示例 3：
     输入: "carerac"
     输出: true
     解释：字符串 "carerac" 本身就是回文串，所以可以通过重新排列组合形成回文串。

 问题分析
 要判断一个字符串能否重新排列成回文串，关键在于分析字符串中各个字符的出现次数。对于一个回文串，有以下特性：
 如果字符串的长度是偶数，那么每个字符都必须出现偶数次。例如，在回文串 "abba" 中，'a' 出现 2 次，'b' 也出现 2 次。
 如果字符串的长度是奇数，那么只能有一个字符出现奇数次，其余字符都必须出现偶数次。例如，在回文串 "abcba" 中，'a' 出现 2 次，'b' 出现 2 次，'c' 出现 1 次。

 */
public class PalindromePermutation_266_Easy {

    private boolean isPalindromePermutation(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char charValue = charArray[i];
            Integer count = map.get(charValue);
            if (count == null) {
                map.put(charValue, 1);
            } else {
                map.put(charValue, count+1);
            }
        }
        int size = charArray.length;
        Iterator<Map.Entry<Character, Integer>> iterator =  map.entrySet().iterator();
        // 是偶数吗？
        boolean isEvenNumber = (size % 2 == 0);
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry =  iterator.next();
            if (isEvenNumber) {
                if (entry.getValue() % 2 != 0) {
                    return false;
                }
            } else {
                if (entry.getValue() % 2 != 0) {
                    count++;
                }
            }
        }
        if (count != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        userCase11();
        userCase12();
        userCase13();
    }

    private static void userCase13() {
        PalindromePermutation_266_Easy obj = new PalindromePermutation_266_Easy();
        System.out.println(obj.isPalindromePermutation("carerac"));
    }

    private static void userCase12() {
        PalindromePermutation_266_Easy obj = new PalindromePermutation_266_Easy();
        System.out.println(obj.isPalindromePermutation("aab"));
    }

    private static void userCase11() {
        PalindromePermutation_266_Easy obj = new PalindromePermutation_266_Easy();
        System.out.println(obj.isPalindromePermutation("code"));
    }

}