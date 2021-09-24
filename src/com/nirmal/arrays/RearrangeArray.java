package com.nirmal.arrays;

public class RearrangeArray {
    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private int[] rearrangeArray(int[] arr) {
        int temp[] = new int[arr.length];
        int small = 0 , large = arr.length - 1;
        boolean flag = true;

        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                temp[i] = arr[large--];
            } else {
                temp[i] = arr[small++];
            }
            flag = !flag;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        return temp;
    }

    private int[] rearrangeArrayInPlace(int[] arr) {
        int minIndex = 0 , maxIndex = arr.length - 1;
        int maxElement = arr[maxIndex] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % maxElement) * maxElement;
                maxIndex--;
            } else {
                arr[i] += (arr[minIndex] % maxElement) * maxElement;
                minIndex++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElement;
        }

        return arr;
    }


    public static void main(String[] args) {
        RearrangeArray ra = new RearrangeArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
//        ra.printArray(ra.rearrangeArray(arr));
        ra.printArray(ra.rearrangeArrayInPlace(arr));
    }
}
