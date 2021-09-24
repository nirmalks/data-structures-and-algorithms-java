package com.nirmal.HeapSort;

public class HeapSort {
    public void heapSort(int[] arr) {
        int size = arr.length;
        for (int i = size / 2 - 1; i >= 0 ; i--) {
            heapify(i, arr, size);
        }

        for (int i = size - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(0, arr, i);
        }
        printArray(arr);
    }

    public void heapify(int i , int[] arr , int size) {
        int maxIndex = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if(leftIndex < size && arr[leftIndex] > arr[maxIndex]) {
            maxIndex = leftIndex;
        }
        if(rightIndex < size && arr[rightIndex] > arr[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (i != maxIndex) {
            int temp = arr[i];
            arr[i]= arr[maxIndex];
            arr[maxIndex] = temp;
            heapify(maxIndex,arr, size);
        }

    }


    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int arr[] = { 5,4,3,2,1};
        hs.heapSort(arr);

    }
}
