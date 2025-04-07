package com.leetcode.algorithm;

/**
 151. Reverse Words in a String
 Given an input string s, reverse the order of the words.
 A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 Return a string of the words in reverse order concatenated by a single space.
 Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 Example 1:
 Input: s = "the sky is blue"
 Output: "blue is sky the"

 Example 2:
 Input: s = "  hello world  "
 Output: "world hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.

 Example 3:
 Input: s = "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 Constraints:
 1 <= s.length <= 104
 s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 There is at least one word in s.

 Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
public class ReverseWordsInAString_151_Medium {

    public String reverseWords(String s) {
        String blank = " ";
        String[]  splits = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = splits.length-1; i >= 0; i--) {
            String temp = splits[i];
            if (!blank.equalsIgnoreCase(temp) && temp != null && temp.length() > 0) {
                sb.append(splits[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        useCase1();
        useCase2();
        useCase3();
    }

    private static void useCase1() {
        ReverseWordsInAString_151_Medium obj = new ReverseWordsInAString_151_Medium();
        System.out.println(obj.reverseWords("the sky is blue"));
    }

    private static void useCase2() {
        ReverseWordsInAString_151_Medium obj = new ReverseWordsInAString_151_Medium();
        System.out.println(obj.reverseWords("  hello world  "));
    }

    private static void useCase3() {
        ReverseWordsInAString_151_Medium obj = new ReverseWordsInAString_151_Medium();
        System.out.println(obj.reverseWords("a good   example"));
    }
}
