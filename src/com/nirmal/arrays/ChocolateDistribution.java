package com.nirmal.arrays;

import java.util.Arrays;

public class ChocolateDistribution {
    private int getChocolateDist(int[] arr, int size) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(i + size - 1 < arr.length) {
                if ((arr[i + size - 1] - arr[i]) < minDiff) {
                    minDiff = arr[i + size - 1] - arr[i];
                }
            }
        }
        return minDiff;
    }

    private void printArray(int[] arr) {
              for (int i : arr) {
                 System.out.println(i);
             }

    }
    public static void main(String[] args) {
        ChocolateDistribution cd = new ChocolateDistribution();
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(cd.getChocolateDist(arr, 5));
    }
}
