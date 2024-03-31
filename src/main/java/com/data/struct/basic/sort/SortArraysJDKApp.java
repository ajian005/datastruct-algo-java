package com.data.struct.basic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * JDK自带 数字排序功能
 */
public class SortArraysJDKApp {
    /**
     * 快速排序 & 合并排序
     */
    @Test
    public void testSort() {
        int[] array = {2,3,4,1,5};
        Arrays.sort(array);
        System.out.println(array);
    }
}