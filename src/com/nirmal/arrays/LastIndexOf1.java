package com.nirmal.arrays;

public class LastIndexOf1 {
    private int getLastIndex(String str, char target) {
        int lastIndex = -1;
        for (int i = str.length() - 1; i > 0 ; i--) {
            if(str.charAt(i) == target) {
                lastIndex = i;
                return lastIndex;
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        LastIndexOf1 li = new LastIndexOf1();
        String str = "00001";
        System.out.println(li.getLastIndex(str,'1'));
    }
}
