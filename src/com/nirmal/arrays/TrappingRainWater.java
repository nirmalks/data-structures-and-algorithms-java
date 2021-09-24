package com.nirmal.arrays;

public class TrappingRainWater {
    private int getTrappedRainWater(int[] arr) {
        int size = arr.length;
        int result = 0;
        int low = 0;
        int high = size - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (low < high) {
            if (arr[low] < arr[high]) {
                if(arr[low] > leftMax) {
                    leftMax = arr[low];
                } else {
                    result += leftMax - arr[low];
                    low++;
                }
            } else {
                if (arr[high] > rightMax) {
                    rightMax = arr[high];
                } else {
                    result += rightMax - arr[high];
                    high--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] arr = {3, 0, 0, 2, 0, 4};
        System.out.println(trw.getTrappedRainWater(arr));
    }
}
