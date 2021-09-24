package com.nirmal.arrays;

public class CountIntversionArray {

        private int getNumberOfPairs(int[] arr1) {
            int pairs = 0;
            for (int i = 0; i < arr1.length; i++) {
                for (int j = i + 1; j < arr1.length - 1; j++) {
                    if (arr1[j] > arr1[i]) {
                        pairs++;
                    }
                }
            }
            return pairs;
        }

        public static void main(String[] args) {
            CountIntversionArray ci = new CountIntversionArray();
            int X[] = {2, 4, 1, 3, 5};
            System.out.println(ci.getNumberOfPairs(X));
        }

}
