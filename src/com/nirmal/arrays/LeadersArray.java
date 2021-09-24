package com.nirmal.arrays;

public class LeadersArray {
    private void leaders(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            for (j = i + 1; j < arr.length ; j++) {
                if (arr[i] <= arr[j]) {
                    break;
                }
            }
            if (j == arr.length) {
                System.out.println(arr[i]);
            }
        }
    }

    private void effLeaders(int[] arr) {

        int max = arr[arr.length - 1];
        System.out.println(max);
        for (int i = arr.length - 2; i >= 0 ; i--) {
            if (arr[i] > max) {
                max = arr[i];
                System.out.println(max);
            }
        }
    }

    public static void main(String[] args) {
        LeadersArray la = new LeadersArray();
        int[] arr = {16, 17, 4, 3, 5, 2};
        la.effLeaders(arr);
    }
}
