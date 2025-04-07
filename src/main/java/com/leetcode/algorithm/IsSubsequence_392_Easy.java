package com.leetcode.algorithm;

/**
 Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 of the characters without disturbing the relative positions of the remaining characters.
 (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 Input: s = "abc", t = "ahbgdc"
 Output: true

 Example 2:
 Input: s = "axc", t = "ahbgdc"
 Output: false

 Constraints:
   0 <= s.length <= 100
   0 <= t.length <= 104
 s and t consist only of lowercase English letters.

 Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
 and you want to check one by one to see if t has its subsequence.
 In this scenario, how would you change your code?
 */
public class IsSubsequence_392_Easy {

    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int tLeftIndex = 0;
        boolean[] booleanValues = new boolean[s.length()];
        for (int i = 0; i < sArray.length; i++) {
            char charValue = sArray[i];
            for (int j = 0; j < tArray.length; j++) {
                char innerCharValue = tArray[j];
                if (tLeftIndex <= j) {
                    if (charValue == innerCharValue) {
                        booleanValues[i] = true;
                        tLeftIndex = j+1;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < booleanValues.length; i++) {
            if (booleanValues[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        useCase1();
        useCase2();
    }

    private static void useCase1() {
        IsSubsequence_392_Easy obj = new IsSubsequence_392_Easy();
        System.out.println(obj.isSubsequence("abc", "ahbgdc"));
    }

    private static void useCase2() {
        IsSubsequence_392_Easy obj = new IsSubsequence_392_Easy();
        System.out.println(obj.isSubsequence("axc", "ahbgdc"));
    }

}