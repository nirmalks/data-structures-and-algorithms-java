package com.nirmal.sorting;

public class MergeSort {
    private void merge(int[] arr, int low, int mid, int high) {
        int leftLength = mid - low + 1;
        int rightLength = high - mid;
        int leftArray[] = new int[leftLength];
        int rightArray[] = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = arr[low + i];
        }

        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0 , j = 0 , k = low;

        while (i < leftLength && j < rightLength) {
            if (rightArray[j] >= leftArray[i]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } else if (rightArray[j] <= leftArray[j]) {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftLength) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low , mid);
            mergeSort(arr, mid +1 , high);
            merge(arr,low,mid,high);
        }
    }
    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int arr[] = {50,40,30,20,10};
        ms.mergeSort(arr, 0 , arr.length - 1);
        ms.printArray(arr);
    }
}
