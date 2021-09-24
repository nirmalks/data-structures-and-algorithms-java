package com.nirmal.arrays;

public class MergeSortedArrays {
    public int[] mergeTwoArrays(int[] arr1, int[] arr2) {
        int result[] = new int[arr1.length + arr2.length];
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int i = 0 , j = 0 , k = 0;
        while (i < arr1Length && j < arr2Length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                k++;
                i++;
            } else {
                result[k] = arr1[j];
                k++;
                j++;
            }
        }

        while (i < arr1Length) {
            result[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2Length) {
            result[k] = arr2[j];
            k++;
            j++;
        }
        return result;
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        MergeSortedArrays ms = new MergeSortedArrays();
        int arr1[] = {1,2,3};
        int arr2[] = {4,5,66};
        ms.printArray(ms.mergeTwoArrays(arr1,arr2));
    }
}