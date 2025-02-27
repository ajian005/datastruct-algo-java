package com.data.struct.basic.sort.quickSort;

/**
 * https://www.geeksforgeeks.org/quick-sort/?ref=lbp
 * 快速排序法
 */
public class QuickSort {
    /**
     * 交换元素
     * A utility function to swap two elements
     */
    private static void swap(int[]arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
      根据某个元素pivot进行元素划分函数
      This function takes last element as pivot,
      places the pivot element at its correct position
      in sorted array, and places all smaller to left
      of pivot and all greater elements to right of pivot
     */
    private static int partition(int[] arr, int low, int high) {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // if current element is smaller than the pivot
            if (arr[j] < pivot) {
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        // pivot和当前元素进行交互
        swap(arr, i+1, high);
        return (i + 1);
    }
    /**
     * QuickSort主框架
     * The main function that implements QuickSort
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p]is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    /**
     * 打印数组
     */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    /**
     * Driver Code
     */
    public static void main(String[] args) {
        int[] arr2 = { 10, 7, 8, 9, 1, 5 };
        int[] arr3 = { 9, 8, 7, 6, 5, 4 };
        int[] arr4 = { 1, 2, 3, 4, 5, 6 };
        int[] arr = { 1, 3, 2, 4, 5, 6 };

        int length = arr.length;

        // Function call
        quickSort(arr, 0, length - 1);
        System.out.println("Sorted array:");
        printArr(arr);
    }
}