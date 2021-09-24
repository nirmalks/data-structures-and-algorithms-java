package com.nirmal.arrays;

public class MissingNumber {

    int getMissingNo(int a[], int n)
    {
        int givenXor = a[0], xorOFAll=1;

        for (int j = 1; j < a.length; j++) {
            givenXor ^= a[j];
        }

        for (int j = 2; j <= a.length + 1; j++) {
            xorOFAll ^= j;
        }
        return (givenXor ^ xorOFAll);
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int arr[] = {1, 2, 3, 5};
        System.out.println(mn.getMissingNo(arr,arr.length));
    }
}
