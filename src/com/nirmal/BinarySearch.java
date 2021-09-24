package com.nirmal;

public class BinarySearch {

    //recursive implementation
    public int binarySearchRecursive(int key, int arr[], int left, int right) {
        if(left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return binarySearchRecursive(key, arr, 0, mid - 1);
            } else {
                return binarySearchRecursive(key, arr, mid + 1, right);
            }
        }
        return -1;
    }

    public int binarySearchIterative(int key, int arr[], int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int arr[] = {50,40,10,20,30};
        System.out.println(bs.binarySearchRecursive(10,arr,0,arr.length - 1));
        System.out.println(bs.binarySearchRecursive(30,arr,0,arr.length - 1));
        System.out.println(bs.binarySearchRecursive(1111,arr,0,arr.length - 1));

        System.out.println(bs.binarySearchIterative(10,arr,0,arr.length - 1));
        System.out.println(bs.binarySearchIterative(30,arr,0,arr.length - 1));
        System.out.println(bs.binarySearchIterative(1111,arr,0,arr.length - 1));

    }
}
