package com.leetcode.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 6. Zigzag Conversion https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=selected-coding-interview
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string s, int numRows);

 Example 1:
 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"

 Example 2:
 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"

 Explanation:
 P     I    N
 A   L S  I G
 Y A   H R
 P     I

 Example 3:
 Input: s = "A", numRows = 1
 Output: "A"

 Constraints:
 1 <= s.length <= 1000
 s consists of English letters (lower-case and upper-case), ',' and '.'.
 1 <= numRows <= 1000
 */
public class ZigzagConversion_6_Medium {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer[] rows = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuffer();
        }
        char[] charArray = s.toCharArray();
        int curRow = 0;
        boolean goingDown = false;
        for (int i = 0; i < charArray.length; i++) {
            rows[curRow].append(charArray[i]);
            //  当前行curRow为0或numRows -1时，箭头发生反向转折
            if (curRow == 0 || curRow == (numRows-1)) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1: -1;
        }
        // 从上到下遍历行
        StringBuffer stringBuffer = new StringBuffer();
        for (StringBuffer sb : rows) {
            stringBuffer.append(sb);
        }
        return stringBuffer.toString();
    }

    public String convert2(String s, int numRows) {
        char[] charArray = s.toCharArray();
        int mod = numRows + 1;
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();

        for (int i = 0; i < charArray.length; i++) {
            if (i % mod == 0) {
                sb1.append(charArray[i]);
            } else if (i % mod == 1 || i % mod == 3) {
                sb2.append(charArray[i]);
            } else if (i % mod == 2) {
                sb3.append(charArray[i]);
            }
        }
        return  sb1.append(sb2).append(sb3).toString();
    }


    @Test
    public  void useCase01() {
        String result = convert("PAYPALISHIRING", 3);
        Assert.assertEquals("字符串相等", "PAHNAPLSIIGYIR", result);
    }

    @Test
    public  void useCase02() {
        String result = convert("PAYPALISHIRING", 4);
        Assert.assertEquals("字符串相等", "PINALSIGYAHRPI", result);
    }

    @Test
    public  void useCase03() {
        String result = convert("A", 1);
        Assert.assertEquals("字符串相等", "A", result);
    }
}