package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;
/**
 * IsomorphicStrings_205_Easy
 */
public class IsomorphicStrings_205_Easy {
    public IsomorphicStrings_205_Easy() {
    }
    public boolean isIsomorphic(String s, String t) {
        String a = isomorphicString(s);
        String b = isomorphicString(t);
        return a.equalsIgnoreCase(b);
    }

    private String isomorphicString(String s) {
        Map<Character, Integer>  map = new HashMap<>();
        int j = 0;
        char[] charArray = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char charValue = charArray[i];
            Integer index = map.get(charValue);
            if (index == null) {
                j++;
                sb.append(j);
                map.put(charValue, j);
            } else {
                sb.append(index);
            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        useCase1();
        useCase2();
        useCase3();
    }

    private static void useCase3() {
        IsomorphicStrings_205_Easy obj = new IsomorphicStrings_205_Easy();
        System.out.println(obj.isIsomorphic("paper", "title"));
    }

    private static void useCase2() {
        IsomorphicStrings_205_Easy obj = new IsomorphicStrings_205_Easy();
        System.out.println(obj.isIsomorphic("foo", "bar"));
    }

    private static void useCase1() {
        IsomorphicStrings_205_Easy obj = new IsomorphicStrings_205_Easy();
        System.out.println(obj.isIsomorphic("egg", "add"));
    }
}