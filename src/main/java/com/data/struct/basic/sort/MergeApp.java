package com.data.struct.basic.sort;

/**
 * 把两个有序数组合并为一个有序数组
 */
public class MergeApp {

    public static void main(String[] args) {
        int[] arrayA = {23, 47, 81, 95};
        int[] arrayB = {7, 14, 39, 55, 62, 74};
        int[] arrayC = new int[10];

        merge(arrayA, arrayB, arrayC);
        display(arrayC, arrayC.length);
    }

    /**
     * @param arrayA
     * @param arrayB
     * @param arrayC
     */
    public static void merge(int[] arrayA, int[] arrayB, int[] arrayC) {
        int aDex=0, bDex=0, cDex=0;
        while (aDex < arrayA.length  && bDex < arrayB.length) {
            if (arrayA[aDex] < arrayB[bDex]) {
                arrayC[cDex++] = arrayA[aDex++];
            } else {
                arrayC[cDex++] = arrayB[bDex++];
            }
        }

        while (aDex < arrayA.length) {
            arrayC[cDex++] = arrayA[aDex++];
        }

        while (bDex < arrayB.length) {
            arrayC[cDex++] = arrayB[bDex++];
        }
    }

    public static void display(int[] theArray, int size) {
        for (int j=0; j<size;j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");
    }
}
