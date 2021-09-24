package com.nirmal.arrays;

public class ElementsMinMax {

    public static void main(String[] args) {
        ElementsMinMax minMax = new ElementsMinMax();
        int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(minMax.getIndexOfMiddleNo(arr));
    }

    private int getIndexOfMiddleNo(int[] arr) {
        int rightMin = Integer.MAX_VALUE;
        int leftMaxArr[] = new int[arr.length];

        for (int i = 1; i < arr.length ; i++) {
            leftMaxArr[i] = Math.max(leftMaxArr[i-1],arr[i-1]);
        }

        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (leftMaxArr[i] < arr[i] && rightMin > arr[i]) {
                return i;
            }
            rightMin = Math.min(rightMin,arr[i]);
        }
        return -1;
    }
}
