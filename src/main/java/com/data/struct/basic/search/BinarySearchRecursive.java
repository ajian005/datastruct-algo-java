package com.data.struct.basic.search;

/**
 * 二分查找递归版本
 * https://www.geeksforgeeks.org/binary-search/?ref=outind
 * Create a recursive function and compare the mid of the search space with the key.
 * And based on the result either return the index where the key is found or call the recursive function for the next search space.
 */
public class BinarySearchRecursive {
    /**
     * Returns index of x if it is present in arr[l..r], else return -1
     */
    private int binarySearch(int[] arr, int left, int right, int key) {
        if (right >= 1) {
            int mid =  left + (right - left)/2;
            // if the element is present at the middle itself
            if (arr[mid] == key) {
                return mid;
            }
            // if element is smaller than mid, then it can only be present in left subarray
            if (arr[mid] > key) {
                return binarySearch(arr, left, mid - 1, key);
            } else {  // else the element can only be present int right subarray
                return binarySearch(arr, mid + 1, right, key);
            }
        }
        // we reach here when element is not present in array
        return -1;
    }

    // Driver code
    public static void main(String args[]) {
        BinarySearchRecursive ob = new BinarySearchRecursive();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int key = 10;
        int result = ob.binarySearch(arr, 0, n - 1, key);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println(
                    "Element is present at index " + result);
    }
}