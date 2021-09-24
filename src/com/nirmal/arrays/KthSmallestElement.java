package com.nirmal.arrays;

public class KthSmallestElement {
    private int getKthSmallestElement(int[] arr, int left, int right, int resultPosition) {
        int position = partition(arr,left,right);
        if (resultPosition > 0 && resultPosition <= right - left + 1) {

            if (position - left == resultPosition - 1) {
                return arr[position];
            }
            if (position - left > resultPosition - 1) {
                return getKthSmallestElement(arr, left, position - 1, resultPosition);
            }
        }
        return getKthSmallestElement(arr, position + 1, right, resultPosition -
                position + left - 1);
    }

    private int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j <= right - 1 ; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }
    public static void main(String[] args) {
        KthSmallestElement kse = new KthSmallestElement();
        int[] arr = {7, 10, 4, 3, 20, 15};

        int result = kse.getKthSmallestElement(arr,0, arr.length - 1, 3);
        System.out.println(result);
    }
}
