package com.nirmal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumberFromArray {
    public static void main(String[] args) {
        LargestNumberFromArray ln = new LargestNumberFromArray();
        int[] arr = {1, 34, 3, 98, 9, 76, 45, 4, 12, 121};
        ln.getLargestNumber(arr);
    }

    private void getLargestNumber(int[] arr) {
        String result = "";
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            numbers.add(String.valueOf(arr[i]));
        }

        Collections.sort(numbers, (a,b) -> (b+a).compareTo(a+b));
//        numbers.stream().forEach(System.out::print);
        System.out.println(numbers.toString().join("",numbers));
    }
}
