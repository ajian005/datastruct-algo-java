package com.leetcode.algorithm;

/**
 https://leetcode.cn/problems/rotate-string/description/?envType=study-plan-v2&envId=selected-coding-interview
 796. Rotate String
 Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 A shift on s consists of moving the leftmost character of s to the rightmost position.
 For example, if s = "abcde", then it will be "bcdea" after one shift.

 Example 1:
 Input: s = "abcde", goal = "cdeab"
 Output: true

 Example 2:
 Input: s = "abcde", goal = "abced"
 Output: false

 Constraints:
 1 <= s.length, goal.length <= 100
 s and goal consist of lowercase English letters.
 */
public class RotateString_796_Easy {
    public boolean rotateString(String s, String goal) {
      char[] charArray = s.toCharArray();
      for (int i = 0; i < charArray.length; i++) {
        char temp = charArray[0];
        for (int j = 0; j < charArray.length-1; j++) {
            charArray[j] = charArray[j+1];
            charArray[j+1] = temp;
        }

        if (new String(charArray).equalsIgnoreCase(goal)) {
          return true;
        }
      }
      return false;
    }

    public  static void main(String[] args) {
        useCase1();
        useCase2();
    }

    private static void useCase1() {
        RotateString_796_Easy obj = new RotateString_796_Easy();
        System.out.println(obj.rotateString("abcde", "cdeab"));
        //System.out.println(obj.rotateString("abcde", "abced"));
    }
    private static void useCase2() {
        RotateString_796_Easy obj = new RotateString_796_Easy();
        //System.out.println(obj.rotateString("abcde", "cdeab"));
        System.out.println(obj.rotateString("abcde", "abced"));
    }
}
