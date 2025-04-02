package com;

/**
 *   打印三角形 如 n = 2
 *          /\
 *         /\/\
 */
public class StringProcessMain {

    public static void main(String[] args) {
        StringProcessMain main = new StringProcessMain();
        main.printTree(10);
    }

    private static final String POINT_CHAR = "/\\";
    private static final String EMPYT_CHAR = " ";
    /**
     * 打印三角形图案
     * * @param n 入参 n 表示图案层数
     */
    public void printTree(int n) {
        for (int i = 0; i < n; i++) {
            String empty = getEmptys(n-i);
            String pointsLine = getPointLine(i + 1);
            System.out.println(empty + pointsLine);
        }
    }

    /**
     * 输入n，返回三角形个数
     * @param n
     * @return
     */
    private String getPointLine(int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            buffer.append(POINT_CHAR);
        }
        return buffer.toString();
    }

    /**
     * 空格
     * @param n
     * @return
     */
    private String getEmptys(int n) {
        StringBuffer empty = new StringBuffer();
        for (int i = n; i >= 0; i--) {
            empty.append(EMPYT_CHAR);
        }
        return empty.toString();
    }
}
