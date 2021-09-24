package com.nirmal.arrays;

public class SortAnArrayOf012 {
    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private void sortArray(int[] arr) {
        int low = 0 ;
        int high = arr.length - 1;
        int mid = 0 ;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SortAnArrayOf012 sa = new SortAnArrayOf012();
        int arr[] = {0, 1, 2, 0, 1, 2};
        sa.sortArray(arr);
        sa.printArray(arr);
    }
}
