package com.data.struct.basic.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListJDKApp {
    @Test
    public void testListSort() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Collections.sort(list);
        System.out.println(list);
    }
}
