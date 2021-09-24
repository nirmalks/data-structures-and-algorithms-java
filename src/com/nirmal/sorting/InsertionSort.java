package com.nirmal.sorting;

public class InsertionSort {
    private void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        printArray(arr);
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr contetn" + arr[i]);
        }
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        int arr[] = {50,20,10,34,48};
        is.insertionSort(arr);

    }
}
