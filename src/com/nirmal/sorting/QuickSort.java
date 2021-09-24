package com.nirmal.sorting;

public class QuickSort {
    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void quickSort(int[] arr, int low , int high) {
        if (low < high) {
            int partition = partition(arr,low,high);
            quickSort(arr,low, partition - 1);
            quickSort(arr,partition + 1 , high);
        }
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int arr[] = {50,40,10,20,30};
        qs.quickSort(arr,0,arr.length - 1);
        qs.printArray(arr);
    }
}
