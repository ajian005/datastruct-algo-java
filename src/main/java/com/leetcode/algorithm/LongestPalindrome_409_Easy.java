package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 *
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 *
 * 相关标签
 * Greedy   Hash Table   String
 */
public class LongestPalindrome_409_Easy {

    public int longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char charValue = charArray[i];
            Integer count = map.get(charValue);
            if (count == null) {
                map.put(charValue, 1);
            } else {
                map.put(charValue, count+1);
            }
        }
        Iterator<Map.Entry<Character, Integer>>  iterator = map.entrySet().iterator();
        int length = 0;
        boolean isOddNumber = false;
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            // 偶数都累加
            if (entry.getValue() % 2 == 0) {
                length = length + entry.getValue();
            } else {
                // 奇数大于2的数据-1
                if (entry.getValue() > 1) {
                    length = length + (entry.getValue() - 1);
                }
                isOddNumber = true;
            }
        }
        // 若奇数存在 + 1;
        if (isOddNumber) {
            length = length + 1;
        }
        return length;
    }

    public static void main(String[] args) {
        //useCase1();
        //useCase2();
        //useCase3();
        //useCase4();
        //useCase5();
        //useCase6();
        useCase7();
    }

    private static void useCase1() {
        LongestPalindrome_409_Easy obj = new LongestPalindrome_409_Easy();
        System.out.println(obj.longestPalindrome("abccccdd"));
    }

    private static void useCase2() {
        LongestPalindrome_409_Easy obj = new LongestPalindrome_409_Easy();
        System.out.println(obj.longestPalindrome("a"));
    }

    private static void useCase3() {
        LongestPalindrome_409_Easy obj = new LongestPalindrome_409_Easy();
        String xxx = "Aa";
        System.out.println(obj.longestPalindrome(xxx));
        System.out.println(xxx.length());
    }

    private static void useCase4() {
        LongestPalindrome_409_Easy obj = new LongestPalindrome_409_Easy();
        String xxx = "Aaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaweqrqwerqwerewqrwqerqwerqwerewrqwewqrwqerwerweqr";
        System.out.println(obj.longestPalindrome(xxx));
        //System.out.println(xxx.length());
    }

    private static void useCase5() {
        LongestPalindrome_409_Easy obj = new LongestPalindrome_409_Easy();
        String xxx = "aaBBBCCC";
        System.out.println(obj.longestPalindrome(xxx));
        System.out.println(xxx.length());
    }

    private static void useCase6() {
        LongestPalindrome_409_Easy obj = new LongestPalindrome_409_Easy();
        String xxx = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(obj.longestPalindrome(xxx));
        System.out.println(xxx.length());
    }


    private static void useCase7() {
        LongestPalindrome_409_Easy obj = new LongestPalindrome_409_Easy();
        String xxx = "bb";
        System.out.println(obj.longestPalindrome(xxx));
        //System.out.println(xxx.length());
    }
}