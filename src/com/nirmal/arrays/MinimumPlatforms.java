package com.nirmal.arrays;

import java.util.Arrays;

public class MinimumPlatforms {
    private int getPlatforms(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int platformsRequired = 1 , result = 1;
        int i = 1 , j = 0 ;
        int size = arrival.length;
        while (i < size && j < size) {
            if (arrival[i] < departure[j]) {
                platformsRequired++;
                i++;
                if (platformsRequired > result) {
                    result = platformsRequired;
                }
            } else {
                platformsRequired--;
                j++;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        MinimumPlatforms mp = new MinimumPlatforms();
        System.out.println(mp.getPlatforms(arr,dep));
    }
}
