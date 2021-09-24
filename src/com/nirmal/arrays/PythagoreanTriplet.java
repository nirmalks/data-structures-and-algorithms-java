package com.nirmal.arrays;

import java.util.Arrays;

public class PythagoreanTriplet {
    private boolean getTriplet(int[] arr) {
        int maximum = 0 ;
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum,arr[i]);
        }
        int arraySize = maximum + 1;
        int hash[] = new int[arraySize];
        hash[arraySize - 1] = 0;

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < maximum + 1; i++) {
            if (hash[i] == 0) {
                continue;
            }
            for (int j = 1; j < maximum + 1; j++) {
                if (i == j && hash[i] == 1 || hash[j] ==0 ) {
                    continue;
                }

                double val = Math.sqrt(i * i + j * j);
                if (val * val != (i *i + j * j)) {
                    continue;
                }

                if (val > maximum) {
                    continue;
                }

                if (hash[(int)val] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n2IsTriplet(int[] arr) {
        int size = arr.length;
        int square[] = new int[size];
        for (int i = 0; i < size; i++) {
            square[i] = arr[i] * arr[i];
        }
        Arrays.sort(square);
        for (int i = size - 1; i >= 2; i--) {
            int left = 0 ;
            int right = i - 1;
            while (left < right) {
                if (square[left] + square[right] == square[i]) {
                    return true;
                }

                if (square[left] + square[right] > square[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        PythagoreanTriplet pt = new PythagoreanTriplet();
        int arr[] = { 3, 2, 4, 6, 5 };
//        System.out.println(pt.getTriplet(arr));
        System.out.println(pt.n2IsTriplet(arr));
    }
}
