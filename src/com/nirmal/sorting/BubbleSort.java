package com.nirmal.sorting;

public class BubbleSort {
    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
        BubbleSort bs = new BubbleSort();
        int arr[] = {50,20,10,34,48};
        bs.bubbleSort(arr);

    }
}
