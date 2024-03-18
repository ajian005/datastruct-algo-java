package com.data.struct.basic.sort;

public class MergeSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        DArray arr = new DArray(maxSize);
        arr.insert(64);
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);

        arr.display();

        arr.mergeSort();

        arr.display();
    }
}
