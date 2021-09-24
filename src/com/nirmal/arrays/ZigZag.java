package com.nirmal.arrays;

public class ZigZag {
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 8, 6, 5, 1};
        ZigZag zigzag = new ZigZag();
        zigzag.shuffleArray(arr);
        zigzag.printArray(arr);
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    private void shuffleArray(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (flag == true) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i + 1] = temp;
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            flag = !flag;

        }
    }
}
