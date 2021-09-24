package com.nirmal.arrays;

public class ReverseArrayGroup {
    private void reverseInGroups(int[] arr, int shift) {
        for (int i = 0; i < arr.length; i+= shift) {
            int left = i;
            int right = Math.min(i + shift - 1 , arr.length - 1);
            while (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                right--;
                left++;
            }
        }
    }
    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        ReverseArrayGroup rag = new ReverseArrayGroup();
        int[] arr = {1,2,3,4,5};
        rag.reverseInGroups(arr,3);
        rag.printArray(arr);
    }
}
