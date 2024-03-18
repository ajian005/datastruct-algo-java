package com.data.struct.basic.sort;

/**
 * 合并排序
 */
public class DArray {
    private long[] theArray;
    private int nElems;

    public DArray(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println(" ");
    }

    public void mergeSort() {
        for (int j = 0; j < nElems; j++) {
            long[] workSpace = new long[nElems];
            recMergeSort(workSpace, 0, nElems-1);
        }
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        }
        int mid = (lowerBound + upperBound) / 2;
        recMergeSort(workSpace, lowerBound, mid);
        recMergeSort(workSpace, mid+1, upperBound);
        merge(workSpace, lowerBound, mid+1, upperBound);
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
          if ( theArray[lowPtr] < theArray[highPtr]) {
            workSpace[j++] = theArray[lowPtr++];
          } else {
              workSpace[j++] = theArray[highPtr++];
          }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = theArray[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = theArray[highPtr++];
        }

        for (int i=0; i < n; i++) {
            theArray[lowerBound+i] = workSpace[i];
        }
    }
}