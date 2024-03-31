package com.data.struct.basic.search;

import org.junit.Test;

import java.util.Arrays;

/**
 * JDK自带二分查找
 */
public class BinarySearchJDKApp {
    @Test
    public void testBinarySearch() {
        int[] array = {2,3,4,1,5};
        Arrays.sort(array);
        int postion = Arrays.binarySearch(array, 4);
        System.out.println(postion);
    }
}
