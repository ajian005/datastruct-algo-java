package com.leetcode.algorithm;

/**
 415. Add Strings  https://leetcode.cn/problems/add-strings/description/?envType=study-plan-v2&envId=selected-coding-interview

 Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 You must also not convert the inputs to integers directly.

 Example 1:
 Input: num1 = "11", num2 = "123"
 Output: "134"

 Example 2:
 Input: num1 = "456", num2 = "77"
 Output: "533"

 Example 3:
 Input: num1 = "0", num2 = "0"
 Output: "0"

 Constraints:
 1 <= num1.length, num2.length <= 104
 num1 and num2 consist of only digits.
 num1 and num2 don't have any leading zeros except for the zero itself.

 */
public class AddStrings_415_Easy {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int carray = 0;
        int baseZero = 48;
        for (int i =num1Array.length-1,j=num2Array.length-1; i >= 0 && j >= 0; i--,j--) {
            int value1 = (int)num1Array[i] % baseZero;
            int value2 = (int)num2Array[j] % baseZero;
            int sum = (value1 + value2 + carray);
            carray =  sum / 10;
            int count = sum % 10;
            sb.append(count);
        }
        int diff = num1Array.length - num2Array.length;
        if (diff > 0) {
            for (int i = diff; i > 0; i--) {
                int value1 = (int)num1Array[i-1] % baseZero;
                int sum = (value1 + carray);
                carray =  sum / 10;
                int count = sum % 10;
                sb.append(count);
            }
        } else if (diff < 0){
            int diff2 = num2Array.length - num1Array.length;
            for (int i = diff2; i > 0; i--) {
                int value1 = (int)num2Array[i-1] % baseZero;
                int sum = (value1 + carray);
                carray =  sum / 10;
                int count = sum % 10;
                sb.append(count);
            }
        }
        if (carray > 0) {
            sb.append(carray);
        }
        String result = sb.reverse().toString();
        return result;
    }

    public static void main(String[] args) {
        //useCase1();
        // useCase2();
        // useCase3();
        useCase4();
    }

    /**
     *
     Example 2:
     Input: num1 = "456", num2 = "77"
     Output: "533"
     */
    private static void useCase2() {
        AddStrings_415_Easy obj = new AddStrings_415_Easy();
        System.out.println(obj.addStrings("456", "77"));
    }

    private static void useCase1() {
        AddStrings_415_Easy obj = new AddStrings_415_Easy();
        System.out.println(obj.addStrings("11", "123"));
    }

    /**
     Example 3:
     Input: num1 = "0", num2 = "0"
     Output: "0"
     */

    private static void useCase3() {
        AddStrings_415_Easy obj = new AddStrings_415_Easy();
        System.out.println(obj.addStrings("0", "0"));
    }

    private static void useCase4() {
        AddStrings_415_Easy obj = new AddStrings_415_Easy();
        System.out.println(obj.addStrings("9", "99"));
    }

}