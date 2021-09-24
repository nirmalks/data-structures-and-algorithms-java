package com.nirmal.arrays;

public class EquilibriumPoint {
    private int getEquilibriumPoint(int[] arr) {
        int leftSum = 0 ;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (leftSum == sum) {
                return i;
            }
            leftSum = leftSum + arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        EquilibriumPoint ep = new EquilibriumPoint();
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(ep.getEquilibriumPoint(arr));
    }
}
