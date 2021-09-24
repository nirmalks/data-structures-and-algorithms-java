package com.nirmal.arrays;

public class NumberOfPairs {
    private int getNumberOfPairs(int[] arr1, int[] arr2) {
        int pairs = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.pow(arr1[i],arr2[j]) > Math.pow(arr2[j], arr1[i])) {
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        NumberOfPairs numberOfPairs = new NumberOfPairs();
        int X[] = {2, 1, 6};
        int Y[] = {1, 5};
        System.out.println(numberOfPairs.getNumberOfPairs(X,Y));
    }

}
