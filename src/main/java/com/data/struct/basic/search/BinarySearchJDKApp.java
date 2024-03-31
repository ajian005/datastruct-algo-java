package com.data.struct.basic.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void testCollectionBinarySearch() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Collections.sort(list);
        int position = Collections.binarySearch(list, "c");
        System.out.println(position);
    }
}
