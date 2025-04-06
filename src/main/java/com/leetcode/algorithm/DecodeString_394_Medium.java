package com.leetcode.algorithm;
/**
 * 394. 字符串解码
 */
public class DecodeString_394_Medium {

    public String decodeString(String s) {
        char leftFlag = '[';
        char rightFlag = ']';
        char [] chars = s.toCharArray();
        boolean isFlag = false;
        StringBuffer sb = new StringBuffer();
        int count = 0;
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char charValue = chars[i];
            boolean isDigit = isDigit(charValue);
            if (isDigit) {
                count = (int)charValue - 48;
            }
            if (leftFlag == charValue) {
                isFlag = true;
            }
            if (rightFlag == charValue) {
                isFlag = false;
                if (count > 0) {
                    str = sb.substring(1);
                    for (int j = 0; j < count-1; j++) {
                        stringBuffer.append(str);
                    }
                }
            }
            if (isFlag) {
                sb.append(charValue);
            } {
                if (rightFlag != charValue && leftFlag != charValue && !isDigit) {
                    stringBuffer.append(charValue);
                }
            }
        }

        System.out.println("stringBuffer=" + stringBuffer);
        return s;
    }

    /**
     * 判断是否为数字 查ASCII码，可以知道
     * @return
     */
    private boolean isDigit(char inputChar) {
        int intValue = (int)inputChar;
        if (intValue >= 48 && intValue <= 57) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // testcase1();
        testcase2();
    }

    private static void testcase1() {
        DecodeString_394_Medium decodeString_394_medium = new DecodeString_394_Medium();
        String s = "abc3[cd]xyz";
        String s1 = decodeString_394_medium.decodeString(s);
    }

    private static void testcase2() {
        DecodeString_394_Medium decodeString_394_medium = new DecodeString_394_Medium();
        String s = "3[a]2[bc]";
        String s1 = decodeString_394_medium.decodeString(s);
    }
}